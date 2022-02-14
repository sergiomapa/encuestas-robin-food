package com.robinfood.encuestas.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.encuestas.domain.Encuestas;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
@Transactional
class EncuestasServiceImplTest {

	@Autowired
	private EncuestasServiceImpl encuestasServiceImpl;
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Test
	void testSave() throws Exception {
				
		Encuestas encuesta = Encuestas.builder()
				.idencuesta(Integer.valueOf((int) timestamp.getTime()/100000))
				.codencuesta("C21")
				.descripcionencuesta("Encuesta de café")
				.nombreencuesta("Encuesta para incorporar presentaciones de café en la carta")
				.estadoencuesta("A")
				.build();
		
		Encuestas encuestaregistro = encuestasServiceImpl.save(encuesta);
	
		assertThat(encuestaregistro).hasFieldOrPropertyWithValue("codencuesta", "C21");
		
	}

	@Test
	void testFindAll() throws Exception {
		
		Encuestas encuesta = Encuestas.builder()
				.idencuesta(Integer.valueOf((int) timestamp.getTime()/100000))
				.codencuesta("C3")
				.descripcionencuesta("Encuesta de pizza")
				.nombreencuesta("Encuesta para nuevas adiciones de pizza en la carta")
				.estadoencuesta("A")
				.build();
		
		encuestasServiceImpl.save(encuesta);
		
		Encuestas encuesta2 = Encuestas.builder()
				.idencuesta(Integer.valueOf((int) timestamp.getTime()/1000000))
				.codencuesta("C34")
				.descripcionencuesta("Encuesta de queso")
				.nombreencuesta("Encuesta para nuevas presentaciones de queso en la carta")
				.estadoencuesta("A")
				.build();
		
		encuestasServiceImpl.save(encuesta2);
		
		assertThat(encuestasServiceImpl.findAll().size() > 0);		
	}
	
	@Test
	void testFindById() {	
		
		Encuestas encuesta = new Encuestas();
		encuesta.setIdencuesta(Integer.valueOf((int) timestamp.getTime()/100000));
		encuesta.setCodencuesta("AS3");
		encuesta.setNombreencuesta("Encuesta de helados");
		encuesta.setDescripcionencuesta("Encuesta para saber la opinion de los helados");
		encuesta.setEstadoencuesta("I");
						
		assertNotNull(encuestasServiceImpl.findById(Integer.valueOf((int) timestamp.getTime()/100000)));
	}
	
	@Test
	void testMetodosNoImplementados() throws Exception {
		
		Encuestas encuesta = Encuestas.builder()
				.idencuesta(Integer.valueOf((int) timestamp.getTime()/1000000))
				.codencuesta("C34")
				.descripcionencuesta("Encuesta de queso")
				.nombreencuesta("Encuesta para nuevas presentaciones de queso en la carta")
				.estadoencuesta("A")
				.build();
		
		encuestasServiceImpl.save(encuesta);
		
		encuesta = Encuestas.builder()
				.idencuesta(Integer.valueOf((int) timestamp.getTime()/1000000))
				.codencuesta("C34")
				.descripcionencuesta("Encuesta de jamones")
				.nombreencuesta("Encuesta para nuevas presentaciones de jamon en la carta")
				.estadoencuesta("A")
				.build();			
		
	}	
}
