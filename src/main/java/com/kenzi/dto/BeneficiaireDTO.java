package com.kenzi.dto;

import com.E_Bank.Solution.model.Compte;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaireDTO {

    private Long beneficiaireId;
    private String name;
    private String accountNumber;
    private String bankName;
    private Long compteId;
}
