package com.api.MyFinance.dto.request;

import com.api.MyFinance.enums.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoRequestDTO(
    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 3, message = "A descrição deve ter no mínimo 3 caracteres")
    String descricao,

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    BigDecimal valor,

    @NotNull(message = "A data é obrigatória")
    LocalDate data,

    @NotNull(message = "O tipo de transação é obrigatório")
    TipoTransacao tipo,

    @NotNull(message = "O ID da categoria é obrigatório")
    Long categoriaId
) {
}
