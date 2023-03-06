package com.eduardo.vendas.repository;

import com.eduardo.vendas.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(value = " delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query(value = " select c from Cliente c left join fetch c.pedidos where c.id =:id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}