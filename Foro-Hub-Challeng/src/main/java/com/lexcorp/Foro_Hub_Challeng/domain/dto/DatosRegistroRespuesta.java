package com.lexcorp.Foro_Hub_Challeng.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotNull Long topicoId,
        @NotBlank String mensaje
) {
}
