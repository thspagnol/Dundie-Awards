package com.dundermifflin.dundieawards.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CerimoniaDundieRequest(
        @NotNull(message = "Ano é obrigatório") Integer ano,
        @NotNull(message = "Data é obrigatória") LocalDate data
) {
}