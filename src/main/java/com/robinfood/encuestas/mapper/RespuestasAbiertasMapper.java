package com.robinfood.encuestas.mapper;

import com.robinfood.encuestas.domain.RespuestasAbiertas;
import com.robinfood.encuestas.dto.RespuestasAbiertasDTO;

import org.mapstruct.Mapper;

import java.util.List;


/**
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface RespuestasAbiertasMapper {

    public RespuestasAbiertas tbRespuestasAbiertasDTOToTbRespuestasAbiertas(
        RespuestasAbiertasDTO tbRespuestasAbiertasDTO);

    public List<RespuestasAbiertas> listTbRespuestasAbiertasDTOToListTbRespuestasAbiertas(
        List<RespuestasAbiertasDTO> tbRespuestasAbiertasDTOs);
}
