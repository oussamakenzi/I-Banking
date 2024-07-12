package com.kenzi.mapper;

import com.E_Bank.Solution.dto.TransferDTO;
import com.E_Bank.Solution.model.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransferMapper {
    @Mapping(source = "compteSourceId", target = "compteSource.idCompte")
    @Mapping(source = "compteDestinationId", target = "compteDestination.idCompte")
    Transfer toEntity(TransferDTO transferDTO);

    @Mapping(source = "compteSource.idCompte", target = "compteSourceId")
    @Mapping(source = "compteDestination.idCompte", target = "compteDestinationId")
    TransferDTO toDTO(Transfer transfer);
}
