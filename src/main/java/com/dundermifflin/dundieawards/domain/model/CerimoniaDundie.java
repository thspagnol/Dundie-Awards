package com.dundermifflin.dundieawards.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name + "cerimonias_dundie")
public class CerimoniaDundie {

    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNUll(messagem = "Ano é obrigatório")
    @Column(nullable = false, unique = true)
    private Integer ano;

    @NotNull(message = "Data é obrigatória")
    @Column(nullable = false)
    private StatusCerimonia status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCerimonia status;

    @OneToMany(mappedBy = "cerimonia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categorias = new ArrayList<>();

    protected CerimoniaDundie() {
    }

    public CerimoniaDundie(Integer ano, LocalDate data) {
        this.ano = ano;
        this.data = data;
        this.status = StatusCerimonia.ABERTA;
    }

    public Long getId() {
        return id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public LocalDate getData() {
        return data;
    }

    public void setStatus(StatusCerimonia status) {
        this.status = status;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void adicionarCategoria(Categoria categoria) {
        categorias.add(categoria);
        categoria.setCerimonia(this);
    }
}