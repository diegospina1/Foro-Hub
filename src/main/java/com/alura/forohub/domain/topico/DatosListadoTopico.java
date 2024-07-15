package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String descripcion,
        LocalDateTime fecha,
        Long autor_id,
        Long curso_id
) {

}
