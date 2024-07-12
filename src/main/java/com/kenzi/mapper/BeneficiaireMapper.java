package com.kenzi.mapper;


import com.kenzi.dto.BeneficiaireDTO;
import com.kenzi.model.Beneficiaire;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface BeneficiaireMapper {
    @Mapping(source = "compteId", target = "compte.idCompte")
    Beneficiaire toEntity(BeneficiaireDTO beneficiaireDTO);

    @Mapping(source = "compte.idCompte", target = "compteId")
    BeneficiaireDTO toDTO(Beneficiaire beneficiaire);
}
