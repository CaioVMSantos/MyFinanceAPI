package com.api.MyFinance.service;

import com.api.MyFinance.dto.request.CategoriaRequestDTO;
import com.api.MyFinance.dto.response.CategoriaResponseDTO;
import com.api.MyFinance.mapper.CategoriaMapper;
import com.api.MyFinance.model.Categoria;
import com.api.MyFinance.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaResponseDTO criar(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = categoriaRepository.save(categoriaMapper.toEntity(categoriaRequestDTO));
        return categoriaMapper.toDto(categoria);
    }

    public List<CategoriaResponseDTO> listar(){
        List<Categoria> listaDeCategorias = categoriaRepository.findAll();
        return listaDeCategorias.stream()
                .map(categoriaMapper::toDto)
                .toList();
    }
}
