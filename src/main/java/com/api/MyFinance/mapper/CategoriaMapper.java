package com.api.MyFinance.mapper;

import com.api.MyFinance.dto.request.CategoriaRequestDTO;
import com.api.MyFinance.dto.response.CategoriaResponseDTO;
import com.api.MyFinance.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(target = "id", ignore = true) // O banco já gera o "id")
    Categoria toEntity(CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO toDto(Categoria entity);

}
