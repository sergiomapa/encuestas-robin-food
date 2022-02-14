package com.robinfood.encuestas.domain;

import java.util.List;


import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*	Entidad de Encuestas
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Builder
@Entity
@Table ( name="tb_encuestas", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encuestas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_encuesta", unique=true, nullable=false)
	@NotNull
	private Integer idencuesta;

	@NotNull
	@NotEmpty
	@Size(max=3)
	@Column(name="cod_encuesta"  , nullable=false  )
	private String codencuesta;	
	
	@NotNull
	@NotEmpty
	@Size(max=255)
	@Column(name="descripcion_encuesta"  , nullable=false  )
	private String descripcionencuesta;	
	
	@NotNull
	@NotEmpty
	@Size(max=1)
	@Column(name="estado_encuesta"  , nullable=false  )
	private String estadoencuesta;	
	
	@NotNull
	@NotEmpty
	@Size(max=255)
	@Column(name="nombre_encuesta"  , nullable=false  )
	private String nombreencuesta;	

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy="tbencuestas")
	@JsonManagedReference
	private List<EncuestaPreguntas> tbencuestapreguntases;	
        
}	