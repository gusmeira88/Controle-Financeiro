package com.fatec.controle_financeiro.domain;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.controle_financeiro.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByDescricao(String descricao);
}
