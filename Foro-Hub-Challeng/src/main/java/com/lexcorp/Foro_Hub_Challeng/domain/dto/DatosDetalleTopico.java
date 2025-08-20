package com.lexcorp.Foro_Hub_Challeng.domain.dto;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String status,
        String autor,
        String curso
) {
}
