package com.robinfood.encuestas.repository;

import com.robinfood.encuestas.domain.Encuestas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


public interface EncuestasRepository extends JpaRepository<Encuestas, Integer> {
}
