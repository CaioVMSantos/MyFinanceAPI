package com.api.MyFinance.service;

import com.api.MyFinance.dto.request.TransacaoRequestDTO;
import com.api.MyFinance.dto.response.TransacaoResponseDTO;
import com.api.MyFinance.mapper.TransacaoMapper;
import com.api.MyFinance.model.Categoria;
import com.api.MyFinance.model.Transacao;
import com.api.MyFinance.repository.CategoriaRepository;
import com.api.MyFinance.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final CategoriaRepository categoriaRepository;
    private final TransacaoMapper transacaoMapper;

    @Transactional // Se der certo - commit, se der errado - rollback.
    public TransacaoResponseDTO criar(TransacaoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada com id: " + dto.categoriaId()));
        Transacao transacao = transacaoMapper.toEntity(dto);
        transacao.setCategoria(categoria);
        Transacao transacaoSalva = transacaoRepository.save(transacao);
        return transacaoMapper.toDto(transacaoSalva);
    }

    public List<TransacaoResponseDTO> listar() {
        List<Transacao> listaDeTransacoes = transacaoRepository.findAll();
        return listaDeTransacoes.stream()
                .map(transacaoMapper::toDto)
                .toList();
    }



}
