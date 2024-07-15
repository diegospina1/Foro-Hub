package com.alura.forohub.domain.topico;

import com.alura.forohub.domain.curso.DatosRegistroCurso;
import com.alura.forohub.domain.usuario.DatosRegistroUsuario;
import com.alura.forohub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String descripcion,
        @NotNull
        Long usuario_id,
        @NotNull
        Long curso_id
) {
}
