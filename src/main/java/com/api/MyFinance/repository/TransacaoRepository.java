package com.api.MyFinance.repository;

import com.api.MyFinance.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {

    List<Transacao> findByCategoriaId(Long categoriaId);

    //Query customizada para ordenar as transações por data em ordem decrescente
    @Query("SELECT t FROM Transacao t ORDER BY t.data DESC")
    List<Transacao> findAllByOrderedByData();

}
