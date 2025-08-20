package com.lexcorp.Foro_Hub_Challeng.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank String login,
        @NotBlank String password
) {
}
