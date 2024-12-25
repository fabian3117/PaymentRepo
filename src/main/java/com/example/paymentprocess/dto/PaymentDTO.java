package com.example.paymentprocess.dto;

import com.example.paymentprocess.enums.PaymentResponseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private String source;
    private String email;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentResponseType responseType;
    private String user_id;
//    private
}
