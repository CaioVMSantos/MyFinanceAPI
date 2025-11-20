package com.api.MyFinance.service;

import com.api.MyFinance.dto.request.TransacaoRequestDTO;
import com.api.MyFinance.dto.response.TransacaoResponseDTO;
import com.api.MyFinance.enums.TipoTransacao;
import com.api.MyFinance.mapper.TransacaoMapper;
import com.api.MyFinance.model.Categoria;
import com.api.MyFinance.model.Transacao;
import com.api.MyFinance.repository.CategoriaRepository;
import com.api.MyFinance.repository.TransacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Essa anotação diz que o JUnit deve usar o Mockito para permitir mocks nesta classe de teste.
class TransacaoServiceTest {

    @InjectMocks // Cria uma instância de TransacaoService e injeta os mocks anotados com @Mock nela.
    private TransacaoService service;

    @Mock
    private TransacaoRepository transacaoRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private TransacaoMapper mapper;

    // ---------------------------------------------------------
    // CENÁRIO 1: Tudo dá certo
    // ---------------------------------------------------------
    @Test // Irei testa-lo
    @DisplayName("Deve criar transação com sucesso quando tudo estiver ok") // Descrição amigável do teste
    void criarTransacaoSucesso() {
        // A. ARRANGE - Preparação do cenário desse teste (Simula)
        Long categoriaId = 1L;
        TransacaoRequestDTO dtoEntrada = new TransacaoRequestDTO(
                        "Cinema", BigDecimal.valueOf(50.00), LocalDate.now(), TipoTransacao.DESPESA, categoriaId
                );
        Categoria categoriaFalsa = new Categoria();
        categoriaFalsa.setId(categoriaId);

        Transacao transacaoSemId = new Transacao();
        transacaoSemId.setCategoria(categoriaFalsa);

        Transacao transacaoSalvaNoBanco = new Transacao();
        transacaoSalvaNoBanco.setId(100L);

        TransacaoResponseDTO dtoSaida = new TransacaoResponseDTO(
                100L, "Cinema", BigDecimal.valueOf(50.00), LocalDate.now(), TipoTransacao.DESPESA, 1L, "Lazer"
        );

        // Configurações Mock
        // Buscar categoria no banco deve retornar a categoria válida
        when(categoriaRepository.findById(categoriaId)).thenReturn(Optional.of(categoriaFalsa));

        // Mapper deve converter DTO para entidade
        when(mapper.toEntity(dtoEntrada)).thenReturn(transacaoSemId);

        // Salvando a transação no repositório deve retornar a transação com ID
        when(transacaoRepository.save(any(Transacao.class))).thenReturn(transacaoSalvaNoBanco);

        // Mapper deve converter entidade para DTO de resposta
        when(mapper.toDto(transacaoSalvaNoBanco)).thenReturn(dtoSaida);

        // B. ACT
        TransacaoResponseDTO resultado = service.criar(dtoEntrada);

        // C. ASSERT
        assertNotNull(resultado); // Verifica se o resultado não é nulo
        assertEquals(100L, resultado.id()); // Verifica se o ID retornado é o esperado
        verify(transacaoRepository, times(1)).save(any(Transacao.class)); // Verifica se o metodo save foi chamado exatamente uma vez
    }

    // ---------------------------------------------------------
    // CENÁRIO 2: Erro (Categoria não existe)
    // ---------------------------------------------------------
    @Test
    @DisplayName("Deve lançar erro quando a categoria não for encontrada")
    void criarTransacaoErro() {
        Long idInexistente = 99L;
        TransacaoRequestDTO dto = new TransacaoRequestDTO(
                        "Teste", BigDecimal.TEN, LocalDate.now(), TipoTransacao.DESPESA, idInexistente
                );

        // Mock que indica que a categoria não foi encontrada
        when(categoriaRepository.findById(idInexistente)).thenReturn(Optional.empty());

        // Verifica se a exceção EntityNotFoundException é lançada, se for deu certo!
        assertThrows(EntityNotFoundException.class, () -> {
            service.criar(dto);
        });
    }
}