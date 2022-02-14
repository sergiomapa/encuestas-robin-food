package com.robinfood.encuestas.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*	Entidad de Preguntas
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Builder
@Entity
@Table ( name="tb_preguntas", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Preguntas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pregunta", unique=true, nullable=false)
	@NotNull
	private Integer idpregunta;

	@NotNull
	@NotEmpty
	@Size(max=255)
	@Column(name="descripcion_pregunta"  , nullable=false  )
	private String descripcionpregunta;
	
	@NotNull
	@NotEmpty
	@Size(max=1)
	@Column(name="estado_pregunta"  , nullable=false  )
	private String estadopregunta;	

	@OneToMany(cascade = CascadeType.ALL , fetch=FetchType.LAZY, mappedBy="tbpreguntas")
	@JsonBackReference
	private List<EncuestaPreguntas> tbencuestapreguntases;
	
	@OneToMany(cascade = CascadeType.ALL ,fetch=FetchType.LAZY, mappedBy="tbpreguntas")
	@JsonManagedReference
	private List<PreguntaOpciones> tbpreguntaopcioneses = new ArrayList<>();	
        
}	