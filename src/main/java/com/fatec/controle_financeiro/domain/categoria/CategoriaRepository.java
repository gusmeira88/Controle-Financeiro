package com.fatec.controle_financeiro.domain.categoria;
import com.fatec.controle_financeiro.entities.Categoria;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByDescricao(String descricao);
 }