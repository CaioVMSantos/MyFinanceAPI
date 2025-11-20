package com.api.MyFinance.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequestDTO(
        @NotBlank(message = "O nome da Categoria é obrigatório")
        @Size(min = 2, message = "O nome da categoria deve ter no mínimo 2 caracteres")
        String nome) {
}
