package com.robinfood.encuestas.mapper;

import com.robinfood.encuestas.domain.RespuestasOptsMultiple;
import com.robinfood.encuestas.dto.RespuestasOptsMultipleDTO;

import org.mapstruct.Mapper;

import java.util.List;


/**
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface RespuestasOptsMultipleMapper {

    public RespuestasOptsMultiple tbRespuestasOptsMultipleDTOToTbRespuestasOptsMultiple(
        RespuestasOptsMultipleDTO tbRespuestasOptsMultipleDTO);

    public List<RespuestasOptsMultiple> listTbRespuestasOptsMultipleDTOToListTbRespuestasOptsMultiple(
        List<RespuestasOptsMultipleDTO> tbRespuestasOptsMultipleDTOs);
}
