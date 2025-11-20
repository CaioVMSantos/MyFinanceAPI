package com.api.MyFinance.controller;

import com.api.MyFinance.dto.request.CategoriaRequestDTO;
import com.api.MyFinance.dto.response.CategoriaResponseDTO;
import com.api.MyFinance.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myfinance/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> criarCategorias(@RequestBody @Valid CategoriaRequestDTO dto) {
        CategoriaResponseDTO novaCategoria = categoriaService.criar(dto);
        return ResponseEntity.ok(novaCategoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAll() {
        List<CategoriaResponseDTO> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

}
