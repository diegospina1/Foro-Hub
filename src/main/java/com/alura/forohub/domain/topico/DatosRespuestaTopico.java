package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String descripcion,
        LocalDateTime fecha,
        Estado estado,
        Long autor_id,
        Long curso_id
) {
}
