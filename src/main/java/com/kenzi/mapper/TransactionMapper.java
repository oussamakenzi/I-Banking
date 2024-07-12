package com.kenzi.mapper;


import com.kenzi.dto.TransactionDTO;
import com.kenzi.model.Transaction;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(source = "compte.idCompte", target = "compteId")
    })
    TransactionDTO toDTO(Transaction transaction);

    @Mappings({
            @Mapping(source = "compteId", target = "compte.idCompte")
    })
    Transaction toEntity(TransactionDTO transactionDTO);
}
