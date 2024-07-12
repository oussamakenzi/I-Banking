package com.kenzi.mapper;


import com.kenzi.dto.CompteDTO;
import com.kenzi.model.Compte;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface CompteMapper {
    @Mapping(source = "userId", target = "user.userId")
    Compte toEntity(CompteDTO compteDTO);

    @Mapping(source = "user.userId", target = "userId")
    CompteDTO toDTO(Compte compte);
}