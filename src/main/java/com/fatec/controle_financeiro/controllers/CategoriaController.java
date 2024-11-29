package com.fatec.controle_financeiro.controllers;
import com.fatec.controle_financeiro.entities.Categoria;
import com.fatec.controle_financeiro.domain.categoria.CategoriaService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Categoria categoria) {
        try {
            Categoria categoriaCreated = categoriaService.create(categoria);
            return new ResponseEntity<>(categoriaCreated, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/read")
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> categoria = categoriaService.findAll();
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
    
    @GetMapping("/read/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        return categoriaService.findById(id)
        .map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}