package com.api.MyFinance.controller;

import com.api.MyFinance.dto.request.TransacaoRequestDTO;
import com.api.MyFinance.dto.response.TransacaoResponseDTO;
import com.api.MyFinance.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/myfinance/transacoes")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> criarTransacao(@RequestBody @Valid TransacaoRequestDTO dto) {
        TransacaoResponseDTO novaTransacao = transacaoService.criar(dto);
        return ResponseEntity.ok(novaTransacao);
    }

    @GetMapping
    public ResponseEntity<List<TransacaoResponseDTO>> listarTransacoes() {
        List<TransacaoResponseDTO> transacoes = transacaoService.listar();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoResponseDTO> listarTransacaoPorId(@PathVariable Long id) {
        TransacaoResponseDTO transacao = transacaoService.listarPorId(id);
        return ResponseEntity.ok(transacao);
    }

    @DeleteMapping("/{id}")
    public void removerTransacao(@PathVariable Long id) {
        transacaoService.remover(id);
    }
}
