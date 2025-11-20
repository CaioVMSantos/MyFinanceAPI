package com.api.MyFinance.dto.response;

import com.api.MyFinance.enums.TipoTransacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoResponseDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDate data,
        TipoTransacao tipo,
        Long categoriaId,
        String categoriaNome // Facilitador pro Front
) {
}
