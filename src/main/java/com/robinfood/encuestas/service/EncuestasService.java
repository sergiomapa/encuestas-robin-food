package com.robinfood.encuestas.service;

import com.robinfood.encuestas.domain.Encuestas;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public interface EncuestasService  {
	
	public List<Encuestas> findAll();
 	
 	public Optional<Encuestas> findById(Integer idEncuesta);

    public Encuestas save(Encuestas entity) throws Exception;

    public void validate(Encuestas tbEncuestas) throws Exception;
	
}
