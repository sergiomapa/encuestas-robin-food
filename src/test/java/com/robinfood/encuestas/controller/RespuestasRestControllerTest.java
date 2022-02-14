package com.robinfood.encuestas.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinfood.encuestas.domain.Encuestas;
import com.robinfood.encuestas.domain.Opciones;
import com.robinfood.encuestas.domain.PreguntaOpciones;
import com.robinfood.encuestas.domain.Preguntas;
import com.robinfood.encuestas.domain.Respuestas;
import com.robinfood.encuestas.dto.EncuestasDTO;
import com.robinfood.encuestas.dto.FormatoRespuestaCompletaDTO;
import com.robinfood.encuestas.dto.RespuestasAbiertasDTO;
import com.robinfood.encuestas.dto.RespuestasDTO;
import com.robinfood.encuestas.dto.RespuestasOptsMultipleDTO;
import com.robinfood.encuestas.service.RespuestasService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(RespuestasRestController.class)
@ComponentScan(basePackages = {"com.robinfood.encuestas.mapper"})
class RespuestasRestControllerTest {
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Autowired 
    MockMvc mockMvc; 
	
	@Autowired
    ObjectMapper mapper;
	
	@MockBean
	RespuestasService respuestasService;

	@Test
	void testSave() throws Exception {
				
		Respuestas respuestaEntity = Respuestas.builder()
				.idencuesta(10)
				.idRespuesta(1)
				.nombreencuestado("Robin")
				.fecharegistro(new Date())
				.build();
		
		RespuestasAbiertasDTO respuAbierta = RespuestasAbiertasDTO.builder()
				.idpregunta(10)
				.idrespuestaabierta(1)
				.idrespuestaencuesta(1)
				.respuesta("Me encantaría. El café es delicioso")
				.build();
		
		RespuestasAbiertasDTO respuAbierta2 = RespuestasAbiertasDTO.builder()
				.idpregunta(10)
				.idrespuestaabierta(2)
				.idrespuestaencuesta(1)
				.respuesta("Prefiero el americano")
				.build();
		
		List<RespuestasAbiertasDTO> listaRespuAbiertas = new ArrayList<>();
		listaRespuAbiertas.add(respuAbierta);
		listaRespuAbiertas.add(respuAbierta2);
		
		RespuestasOptsMultipleDTO respuOptMultiple = RespuestasOptsMultipleDTO.builder()
				.idpregunta(10)
				.idrespuestaencuesta(1)
				.idrespuestamultiple(1)
				.idopcion(2)
				.build();
		
		RespuestasOptsMultipleDTO respuOptMultiple2 = RespuestasOptsMultipleDTO.builder()
				.idpregunta(10)
				.idrespuestaencuesta(1)
				.idrespuestamultiple(2)
				.idopcion(3)
				.build();
		
		List<RespuestasOptsMultipleDTO> listaRespusOptMultiple = new ArrayList<>();
		listaRespusOptMultiple.add(respuOptMultiple);
		listaRespusOptMultiple.add(respuOptMultiple2);
		
		FormatoRespuestaCompletaDTO respuesta = FormatoRespuestaCompletaDTO.builder()
				.idencuesta(10)
				.nombreencuestado("Robin")
				.listrespuestasabiertas(listaRespuAbiertas)
				.listrespuestasoptmultiple(listaRespusOptMultiple)				
				.build();
				
		
		Mockito.when(respuestasService.save(respuesta)).thenReturn(respuestaEntity);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/respuesta-encuesta/")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(respuesta));
		
		mockMvc.perform(mockRequest)
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$", notNullValue()))
		        .andExpect(jsonPath("$.nombreencuestado", is("Robin")));
		
	}

}
