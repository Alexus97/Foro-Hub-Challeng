package com.lexcorp.Foro_Hub_Challeng.domain.dto;

import java.time.LocalDateTime;

public record DatosRespuestaListado(
        Long id,
        String mensaje,
        String autor,
        LocalDateTime fechaCreacion
) {
}
