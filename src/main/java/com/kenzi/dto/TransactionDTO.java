package com.kenzi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long idTransaction;
    private LocalDateTime timestamp;
    private double montant;
    private String typeDeTransaction;
    private String description;
    private Long compteId;
}
