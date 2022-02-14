package com.robinfood.encuestas.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
*	Entidad de Opciones
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Entity
@Builder
@Table ( name="tb_opciones", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Opciones implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_opcion", unique=true, nullable=false)
	@NotNull
	private Integer idopcion;

	@NotNull
	@NotEmpty
	@Size(max=255)
	@Column(name="descripcion_opcion"  , nullable=false  )
	private String descripcionopcion;	
	
	@NotNull
	@NotEmpty
	@Size(max=1)
	@Column(name="estado_opcion"  , nullable=false  )
	private String estadoopcion;	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="tbopciones")
	@JsonBackReference
	private List<PreguntaOpciones> tbpreguntaopcioneses = new ArrayList<>();	

}	