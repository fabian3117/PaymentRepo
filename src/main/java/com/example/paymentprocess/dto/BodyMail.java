package com.example.paymentprocess.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
/**
 * Clase DTO para el intercambio de mails. Campo tipo indicaria la categoria para enviar el archivo adjunto
 * TODO implementar logica para envio de dato adjunto segun el tipo
 */
public class BodyMail implements Serializable {
    private String destino;
    private String texto;
    private String asunto;
    private String tipo;
}

