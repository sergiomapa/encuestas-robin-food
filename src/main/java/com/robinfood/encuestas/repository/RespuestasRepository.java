package com.robinfood.encuestas.repository;

import com.robinfood.encuestas.domain.Respuestas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;


public interface RespuestasRepository extends JpaRepository<Respuestas, Integer> {
	
	@Query(value = "SELECT nextval('tb_respuestas_id_respuesta_seq')", nativeQuery =
            true)
    Integer getNextSeqRespuestas();
}
