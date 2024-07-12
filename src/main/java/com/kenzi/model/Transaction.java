package com.kenzi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
    private LocalDateTime timestamp;
    private double montant;
    private String typeDeTransaction;
    private String description;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;


}
