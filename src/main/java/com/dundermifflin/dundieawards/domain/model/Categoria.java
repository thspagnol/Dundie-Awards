package com.dundermifflin.dundieawards.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da categoria é obrigatório")
    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cerimonia_id", nullable = false)
    private CerimoniaDundie cerimonia;

    protected Categoria() {}

    public Categoria(String nome, CerimoniaDundie cerimonia) {
        this.nome = nome;
        this.cerimonia = cerimonia;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public CerimoniaDundie getCerimonia() {
        return cerimonia;
    }

    void setCerimonia(CerimoniaDundie cerimonia) {
        this.cerimonia = cerimonia;
    }
}