package com.robinfood.encuestas.controller;

import com.robinfood.encuestas.domain.*;
import com.robinfood.encuestas.dto.EncuestasDTO;
import com.robinfood.encuestas.mapper.EncuestasMapper;
import com.robinfood.encuestas.service.EncuestasService;

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
*	Controlador de encuestas REST
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/

@RestController
@RequestMapping("/api/v1/encuesta")
@Slf4j
public class EncuestasRestController {
    @Autowired
    private EncuestasService tbEncuestasService;
    @Autowired
    private EncuestasMapper tbEncuestasMapper;

    @GetMapping(value = "/{idEncuesta}")
    public ResponseEntity<?> findById(
        @PathVariable("idEncuesta")
    Integer idEncuesta) throws Exception {
        log.debug("Request to findById() TbEncuestas");

        Encuestas tbEncuestas = (tbEncuestasService.findById(idEncuesta)
                                                     .isPresent() == true)
            ? tbEncuestasService.findById(idEncuesta).get() : null;

        return ResponseEntity.ok()
                             .body(tbEncuestasMapper.tbEncuestasToTbEncuestasDTO(
                tbEncuestas));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() TbEncuestas");

        return ResponseEntity.ok()
                             .body(tbEncuestasMapper.listTbEncuestasToListTbEncuestasDTO(
                tbEncuestasService.findAll()));
    }
}
