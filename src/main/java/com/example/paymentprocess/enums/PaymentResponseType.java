package com.example.paymentprocess.enums;

import lombok.Getter;

@Getter
public enum PaymentResponseType {
    OK("OK"),
    PENDING("PENDING"),
    FAIL("FAIL");
    private String value;

    PaymentResponseType(String value) {
        this.value = value;
    }
}
