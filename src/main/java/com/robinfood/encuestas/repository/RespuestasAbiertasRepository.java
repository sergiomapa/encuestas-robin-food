package com.robinfood.encuestas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robinfood.encuestas.domain.RespuestasAbiertas;


public interface RespuestasAbiertasRepository extends JpaRepository<RespuestasAbiertas, Integer> {
}
