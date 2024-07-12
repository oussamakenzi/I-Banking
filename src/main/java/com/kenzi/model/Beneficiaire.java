package com.kenzi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity

public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beneficiaireId;

    private String name;
    private String accountNumber;
    private String bankName;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;
}
