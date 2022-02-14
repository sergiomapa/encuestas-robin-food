package com.robinfood.encuestas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robinfood.encuestas.domain.RespuestasOptsMultiple;

import java.math.BigDecimal;


public interface RespuestasOptsMultipleRepository extends JpaRepository<RespuestasOptsMultiple, Integer> {
}
