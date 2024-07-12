package com.kenzi.mapper;


import com.kenzi.dto.CarteDTO;
import com.kenzi.model.Carte;

@Mapper(componentModel = "spring")
public interface CarteMapper {
    CarteDTO toDTO(Carte carte);
    Carte toEntity(CarteDTO carteDTO);
}
