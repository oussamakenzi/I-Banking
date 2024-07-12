package com.kenzi.dto;

import com.E_Bank.Solution.model.Compte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarteDTO {

    private Long idCart;
    private String numéroCarte;
    private LocalDate dateExpiration;
    private String typeDeCarte;
    private boolean active;
    private Compte compte;

}
