package com.fatec.controle_financeiro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.domain.CategoriaRepository;
import com.fatec.controle_financeiro.entities.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<String> criarCategoria(@RequestBody Categoria categoria) {
    
        if (categoria == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: A categoria não pode ser null.");
        }

        if (categoria.getDescricao() == null || categoria.getDescricao().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: A descrição é obrigatória e não pode ser vazia.");
        }

        if (categoriaRepository.findByDescricao(categoria.getDescricao()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: A descrição já está em uso.");
        }

        categoriaRepository.save(categoria);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Categoria criada com sucesso.");
    }
}