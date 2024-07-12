package com.kenzi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;
    private String numéroCarte;
    private LocalDate dateExpiration;
    private String typeDeCarte;
    private boolean Active;

    @OneToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;
}
