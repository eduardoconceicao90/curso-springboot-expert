package com.eduardo.vendas.repository;

import com.eduardo.vendas.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
