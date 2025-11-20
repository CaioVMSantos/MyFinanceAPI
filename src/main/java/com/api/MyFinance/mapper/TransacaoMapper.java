package com.api.MyFinance.mapper;

import com.api.MyFinance.dto.request.TransacaoRequestDTO;
import com.api.MyFinance.dto.response.TransacaoResponseDTO;
import com.api.MyFinance.model.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {

    @Mapping(target = "categoria", ignore = true) // O banco já busca
    @Mapping(target = "id", ignore = true) // O banco já gera o "id"
    Transacao toEntity(TransacaoRequestDTO dto);

    @Mapping(target = "categoriaId", source = "categoria.id") // O MapStruct entra dentro do objeto categoria e pega só o ID.
    @Mapping(target = "categoriaNome", source = "categoria.nome") // Sem isso, o response seria só o número e não o nome.
    TransacaoResponseDTO toDto(Transacao entity);

}
