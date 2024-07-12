package com.kenzi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private String typeDeCompte;
    private double soldeInitial;
    @NotNull
    private LocalDateTime dateDeCreation;
    private String status;
    private String raisonClosure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compteSource")
    private List<Transfer> transfertsEnvoyes;

    @OneToMany(mappedBy = "compteDestination")
    private List<Transfer> transfertsRecus;

    @OneToMany(mappedBy = "compte")
    private List<Beneficiaire> beneficiaires;

    @OneToOne(mappedBy = "compte")
    private Carte carte;
}
