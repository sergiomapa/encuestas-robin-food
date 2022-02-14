package com.robinfood.encuestas.service;

import com.robinfood.encuestas.domain.Respuestas;
import com.robinfood.encuestas.dto.FormatoRespuestaCompletaDTO;


import javax.validation.ConstraintViolationException;


public interface RespuestasService {

	Respuestas save(FormatoRespuestaCompletaDTO formatoEncuestaCompletaDTO) throws Exception;
	
	void validate(Respuestas tbRespuestas) throws ConstraintViolationException;

}
