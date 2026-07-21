package com.dundermifflin.dundieawards.dto;

import com.dundermifflin.dundieawards.domain.model.CerimoniaDundie;
import com.dundermifflin.dundieawards.domain.model.StatusCerimonia;

import java.time.LocalDate;
import java.util.List;

public record CerimoniaDundieResponse(
        Long id,
        Integer ano,
        LocalDate data,
        StatusCerimonia status,
        List<CategoriaResponse> categorias
) {
    public static CerimoniaDendieResponse fromEntity(CerimoniaDundie cerimonia) {
        List<CategoriaResponse> categoriasDto = cerimonia.getCategorias().stream()
                .map(c -> new CategoriaResponse(c.getId(), c.getNome()))
                .toList();

        return new CerimoniaDundieResponse(
                cerimonia.getId(),
                cerimonia.getAno(),
                cerimonia.getData(),
                cerimonia.getStatus(),
                categoriasDto
        );
    }
}