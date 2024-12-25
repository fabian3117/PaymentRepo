package com.example.paymentprocess.service;

import com.example.paymentprocess.dto.BodyMail;
import com.example.paymentprocess.dto.PaymentDTO;
import com.example.paymentprocess.enums.PaymentResponseType;
import com.example.paymentprocess.kafka.facturas.KafkaMailProducterSender;
import com.example.paymentprocess.mapper.PaymentMapper;
import com.example.paymentprocess.repository.PaymentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase encargada del pago en si mismo
 */
@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private KafkaMailProducterSender kafkaMailProducterSender;

    private final PaymentRepository paymentRepository;

    /*
    Pueden pasar 3 cosas , Me llega el resultado del pago como OK o RECHAZADO
    Voy por el ok : Guardo en db el resultado --> Debo notificar al otro servicio -- Crear factura -- Enviar mail
    Voy por el Fallo : Guardo Rechazo --> Envio mail de error
     */
    public void processPayment(@NonNull PaymentDTO payment, @NonNull PaymentResponseType paymentResponseType) {
        //--->  Si puedo guardarlo en db lo saco de la cola <---
        kafkaMailProducterSender.send(BodyMail.builder()
                .texto((paymentResponseType.equals(PaymentResponseType.OK)?"Procesado correcto":"Fallo en procesado de pago"))
                .tipo(String.valueOf(paymentResponseType))
                .asunto("Pago")
                .destino(payment.getEmail())
                .build());

        paymentRepository.save(paymentMapper.PaymentDTOToPaymentsModel(payment));

    }

    public PaymentResponseType processPayment(@NonNull PaymentDTO payment) {

        paymentRepository.save(paymentMapper.PaymentDTOToPaymentsModel(payment));
        switch (payment.getUser_id()) {
            case "1" -> {
                return PaymentResponseType.OK;
            }
            case "3" -> {
                return PaymentResponseType.PENDING;
            }
            default -> {
                return PaymentResponseType.FAIL;
            }
        }
    }
}
