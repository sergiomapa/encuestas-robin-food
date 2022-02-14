package com.robinfood.encuestas.mapper;

import com.robinfood.encuestas.domain.Encuestas;
import com.robinfood.encuestas.dto.EncuestasDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


/**
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface EncuestasMapper {
		
    public EncuestasDTO tbEncuestasToTbEncuestasDTO(Encuestas tbEncuestas);

    public List<EncuestasDTO> listTbEncuestasToListTbEncuestasDTO(
        List<Encuestas> tbEncuestass);

}
