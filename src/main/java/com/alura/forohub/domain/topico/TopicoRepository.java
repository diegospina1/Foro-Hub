package com.alura.forohub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("select t from Topico t where t.estado != " + "DESACTIVADO")
    Page<Topico> encontrarActivos(Pageable paginacion);

}
