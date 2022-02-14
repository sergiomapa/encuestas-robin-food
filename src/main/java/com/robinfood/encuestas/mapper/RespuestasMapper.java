package com.robinfood.encuestas.mapper;

import com.robinfood.encuestas.domain.Respuestas;
import com.robinfood.encuestas.dto.FormatoRespuestaCompletaDTO;
import com.robinfood.encuestas.dto.RespuestasDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface RespuestasMapper {
	
	FormatoRespuestaCompletaDTO INSTANCE = Mappers.getMapper(FormatoRespuestaCompletaDTO.class);
	    
    public Respuestas formatoEncuestaCompletaDTOToTbRespuestas(
    		FormatoRespuestaCompletaDTO formatoEncuestaCompletaDTO);

	public FormatoRespuestaCompletaDTO tbRespuestasToFormatoEncuestaCompletaDTO(Respuestas tbRespuestas);

}
