package com.example.paymentprocess.mapper;

import com.example.paymentprocess.dto.PaymentDTO;
import com.example.paymentprocess.model.PaymentsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO PaymentEntityToDTO(PaymentsModel paymentsModel);

    PaymentsModel PaymentDTOToPaymentsModel(PaymentDTO paymentDTO);
}
