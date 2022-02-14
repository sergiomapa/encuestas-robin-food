package com.robinfood.encuestas.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.encuestas.domain.Encuestas;
import com.robinfood.encuestas.domain.Respuestas;
import com.robinfood.encuestas.dto.FormatoRespuestaCompletaDTO;
import com.robinfood.encuestas.dto.RespuestasAbiertasDTO;
import com.robinfood.encuestas.dto.RespuestasOptsMultipleDTO;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
@Transactional
class RespuestasServiceImplTest {

	@Autowired
	private RespuestasServiceImpl respuestasServiceImpl;
	
	@Test
	void testSave() {
		
		RespuestasAbiertasDTO respuAbierta = RespuestasAbiertasDTO.builder()
				.idpregunta(1)
				.idrespuestaabierta(1)
				.idrespuestaencuesta(1)
				.respuesta("Me encantaría. El café es delicioso")
				.build();
		
		RespuestasAbiertasDTO respuAbierta2 = RespuestasAbiertasDTO.builder()
				.idpregunta(1)
				.idrespuestaabierta(2)
				.idrespuestaencuesta(1)
				.respuesta("Prefiero el americano")
				.build();
		
		List<RespuestasAbiertasDTO> listaRespuAbiertas = new ArrayList<>();
		listaRespuAbiertas.add(respuAbierta);
		listaRespuAbiertas.add(respuAbierta2);
		
		RespuestasOptsMultipleDTO respuOptMultiple = RespuestasOptsMultipleDTO.builder()
				.idpregunta(1)
				.idrespuestaencuesta(1)
				.idrespuestamultiple(1)
				.idopcion(2)
				.build();
		
		RespuestasOptsMultipleDTO respuOptMultiple2 = RespuestasOptsMultipleDTO.builder()
				.idpregunta(1)
				.idrespuestaencuesta(1)
				.idrespuestamultiple(2)
				.idopcion(3)
				.build();
		
		List<RespuestasOptsMultipleDTO> listaRespusOptMultiple = new ArrayList<>();
		listaRespusOptMultiple.add(respuOptMultiple);
		listaRespusOptMultiple.add(respuOptMultiple2);
		
		FormatoRespuestaCompletaDTO respuesta = FormatoRespuestaCompletaDTO.builder()
				.idencuesta(1)
				.nombreencuestado("Robin")
				.listrespuestasabiertas(listaRespuAbiertas)
				.listrespuestasoptmultiple(listaRespusOptMultiple)				
				.build();
		
		Respuestas respuestaRegistro = respuestasServiceImpl.save(respuesta);
		
		assertThat(respuestaRegistro).hasFieldOrPropertyWithValue("nombreencuestado", "Robin");
		
		
	}

}
