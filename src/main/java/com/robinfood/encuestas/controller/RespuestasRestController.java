package com.robinfood.encuestas.controller;

import com.robinfood.encuestas.domain.*;
import com.robinfood.encuestas.dto.FormatoRespuestaCompletaDTO;
import com.robinfood.encuestas.dto.RespuestasDTO;
import com.robinfood.encuestas.mapper.RespuestasMapper;
import com.robinfood.encuestas.service.RespuestasService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
*	Controlador de respuestas REST
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@RestController
@RequestMapping("/api/v1/respuesta-encuesta")
@Slf4j
public class RespuestasRestController {
    @Autowired
    private RespuestasService tbRespuestasService;

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    FormatoRespuestaCompletaDTO formatoEncuestaCompletaDTO) throws Exception {
        log.debug("Request to save TbRespuestas: {}", formatoEncuestaCompletaDTO);
        
        tbRespuestasService.save(formatoEncuestaCompletaDTO);

        return ResponseEntity.ok()
                             .body(formatoEncuestaCompletaDTO);
        
    }
}
