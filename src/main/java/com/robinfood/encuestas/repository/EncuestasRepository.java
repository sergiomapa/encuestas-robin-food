package com.robinfood.encuestas.repository;

import com.robinfood.encuestas.domain.Encuestas;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EncuestasRepository extends JpaRepository<Encuestas, Integer> {
}
