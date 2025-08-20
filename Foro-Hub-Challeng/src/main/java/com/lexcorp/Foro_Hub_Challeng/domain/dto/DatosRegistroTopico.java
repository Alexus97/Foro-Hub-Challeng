package com.lexcorp.Foro_Hub_Challeng.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String status,
        @NotNull Long autor,
        @NotNull Long curso
) {
}
