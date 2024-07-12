package com.kenzi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteDTO {

    private Long idCompte;
    private String typeDeCompte;
    private double soldeInitial;
    private LocalDateTime dateDeCreation;
    private String status;
    private String raisonClosure;
    private Long userId;
}
