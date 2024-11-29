package com.fatec.controle_financeiro.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;

    @NotNull
    @Column(unique = true, length = 255)
    private String descricao;

    @Column()
    private Boolean ativo;

    public Categoria() { } // Empty Constructor

    public Categoria(Long id, String descricao, Boolean ativo){
        this.id = id;
        this.descricao = descricao;
        this.ativo = ativo; 
    } // Constructor

    public Long getId(){
        return id;
    }

    public void setID(Long id){
        this.id = id;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
 
    public Boolean getAtivo(){
        return ativo;
    }

    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }
}
