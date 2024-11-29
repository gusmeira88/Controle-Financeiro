package com.fatec.controle_financeiro.domain.categoria;
import com.fatec.controle_financeiro.entities.Categoria;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria create(Categoria categoria){
        if (categoria.getDescricao() == null) {
            throw new IllegalArgumentException("Descricão não pode ser vazio.");
        }

        if (descricaoJaExiste(categoria.getDescricao())) {
            throw new IllegalArgumentException("Já existe uma categoria com essa descrição.");
        }

        if (categoria.getAtivo() == null){
            categoria.setAtivo(true);
        }

        return categoriaRepository.save(categoria);
    }

    @Transactional(readOnly = true)
    public boolean descricaoJaExiste(String descricao) {
        return categoriaRepository.findByDescricao(descricao).isPresent();
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

}
