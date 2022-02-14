package com.robinfood.encuestas.service;

import com.robinfood.encuestas.domain.Respuestas;
import com.robinfood.encuestas.dto.FormatoRespuestaCompletaDTO;

import java.math.*;

import java.util.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;


public interface RespuestasService {

	Respuestas save(FormatoRespuestaCompletaDTO formatoEncuestaCompletaDTO) throws Exception;
	
	void validate(Respuestas tbRespuestas) throws ConstraintViolationException;

}
