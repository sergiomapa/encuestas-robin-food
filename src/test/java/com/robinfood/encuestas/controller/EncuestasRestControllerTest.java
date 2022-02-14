package com.robinfood.encuestas.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinfood.encuestas.domain.Encuestas;
import com.robinfood.encuestas.mapper.EncuestasMapper;
import com.robinfood.encuestas.repository.EncuestasRepository;
import com.robinfood.encuestas.service.EncuestasService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(EncuestasRestController.class)
@ComponentScan(basePackages = {"com.robinfood.encuestas.mapper"})
class EncuestasRestControllerTest {
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
    @Autowired 
    MockMvc mockMvc; 
     
    @MockBean
    EncuestasService encuestasService;
		    
	@Test
	void testFindById() throws Exception {
				
		Encuestas encuesta = Encuestas.builder()
				.idencuesta(Math.abs(Integer.valueOf((int) timestamp.getTime()/100000)))
				.codencuesta("C21")
				.descripcionencuesta("Encuesta de café")
				.nombreencuesta("Encuesta para incorporar presentaciones de café en la carta")
				.estadoencuesta("A")
				.build();
				
		Mockito.when(encuestasService.findById(Math.abs(Integer.valueOf((int) timestamp.getTime()/100000)))).thenReturn(java.util.Optional.of(encuesta));
				
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/v1/encuesta/"+(Math.abs(Integer.valueOf((int) timestamp.getTime()/100000))))
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()));
	}
	
	@Test
	void testFindAll() throws Exception {
				
		Encuestas encuesta = Encuestas.builder()
				.idencuesta(Integer.valueOf((int) timestamp.getTime()/100000))
				.codencuesta("C22")
				.descripcionencuesta("Encuesta de café")
				.nombreencuesta("Encuesta para incorporar presentaciones de café en la carta")
				.estadoencuesta("A")
				.build();
		
		Encuestas encuesta2 = Encuestas.builder()
				.idencuesta(Integer.valueOf((int) timestamp.getTime()/100000))
				.codencuesta("C24")
				.descripcionencuesta("Encuesta de pan")
				.nombreencuesta("Encuesta para incorporar presentaciones de pan en la carta")
				.estadoencuesta("A")
				.build();
		
		List<Encuestas> encuestas = new ArrayList<>(Arrays.asList(encuesta, encuesta2));	
		
		Mockito.when(encuestasService.findAll()).thenReturn(encuestas);
				
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/v1/encuesta/")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].codencuesta", is("C22")));
	}

}
