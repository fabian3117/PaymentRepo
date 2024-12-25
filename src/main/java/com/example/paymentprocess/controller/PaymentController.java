package com.example.paymentprocess.controller;

import com.example.paymentprocess.dto.PaymentDTO;
import com.example.paymentprocess.enums.PaymentResponseType;
import com.example.paymentprocess.service.PaymentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("")
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponseType processPayment(@RequestBody @NonNull PaymentDTO payment) {
         paymentService.processPayment(payment,PaymentResponseType.OK);
        return PaymentResponseType.OK;
    }

    //--->  Ahora le añado la cola de kafka para simular que mercadopago me despierta por un cambio de estado   <---

}
