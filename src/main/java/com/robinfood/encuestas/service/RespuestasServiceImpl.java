package com.robinfood.encuestas.service;

import com.robinfood.encuestas.domain.*;
import com.robinfood.encuestas.dto.FormatoRespuestaCompletaDTO;
import com.robinfood.encuestas.exception.*;
import com.robinfood.encuestas.mapper.RespuestasAbiertasMapper;
import com.robinfood.encuestas.mapper.RespuestasMapper;
import com.robinfood.encuestas.mapper.RespuestasOptsMultipleMapper;
import com.robinfood.encuestas.repository.*;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

@Scope("singleton")
@Service
@Slf4j
public class RespuestasServiceImpl implements RespuestasService {
    @Autowired
    private RespuestasRepository tbRespuestasRepository;
    
    @Autowired
    private RespuestasOptsMultipleRepository tbRespuestasOptsMultipleRepository;
    
    @Autowired
    private RespuestasAbiertasRepository tbRespuestasAbiertasRepository;
    
    @Autowired
    private Validator validator;
    
    @Autowired
    private RespuestasMapper tbRespuestasMapper;
    
    @Autowired
    private RespuestasOptsMultipleMapper tbRespuestasOptsMultipleMapper;
    
    @Autowired
    private RespuestasAbiertasMapper tbRespuestasAbiertasMapper;

    @Override
    public void validate(Respuestas tbRespuestas)
        throws ConstraintViolationException {
        Set<ConstraintViolation<Respuestas>> constraintViolations = validator.validate(tbRespuestas);
                
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

	@Override
	public Respuestas save(FormatoRespuestaCompletaDTO formatoEncuestaCompletaDTO) {
		
		if (formatoEncuestaCompletaDTO == null) {
            throw new ZMessManager().new NullEntityExcepcion("Respuestas de Encuesta");
        }
        
		Respuestas tbRespuestas = tbRespuestasMapper.formatoEncuestaCompletaDTOToTbRespuestas(formatoEncuestaCompletaDTO);
		
		tbRespuestas.setIdRespuesta(tbRespuestasRepository.getNextSeqRespuestas());
		
		validate(tbRespuestas);

        if (tbRespuestasRepository.existsById(tbRespuestas.getIdRespuesta())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }
        
        List<RespuestasOptsMultiple> listTbRespuestasOptsMultiple = tbRespuestasOptsMultipleMapper.listTbRespuestasOptsMultipleDTOToListTbRespuestasOptsMultiple(formatoEncuestaCompletaDTO.getListrespuestasoptmultiple());
        
        listTbRespuestasOptsMultiple.stream().forEach((p)-> {
        	p.setIdrespuestaencuesta(tbRespuestas.getIdRespuesta());
        });
        
        List<RespuestasAbiertas> listTbRespuestasAbiertas = tbRespuestasAbiertasMapper.listTbRespuestasAbiertasDTOToListTbRespuestasAbiertas(formatoEncuestaCompletaDTO.getListrespuestasabiertas());
        
        listTbRespuestasAbiertas.stream().forEach((p)-> {
        	p.setIdrespuestaencuesta(tbRespuestas.getIdRespuesta());
        });
        
        tbRespuestasRepository.save(tbRespuestas);
        
        tbRespuestasAbiertasRepository.saveAll(listTbRespuestasAbiertas);
        
        tbRespuestasOptsMultipleRepository.saveAll(listTbRespuestasOptsMultiple);
                
        return tbRespuestas;
	}
}
