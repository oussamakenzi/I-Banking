package com.kenzi.dto;

import com.E_Bank.Solution.model.Compte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {
    private Long transferId;
    private Double montant;
    private LocalDateTime dateHeure;
    private String description;
    private Long compteSourceId;
    private Long compteDestinationId;
}
