package com.robinfood.encuestas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
*	Entidad de relacion Pregunta - Opciones
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Entity
@Builder
@Table(name = "tb_pregunta_opciones", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaOpciones implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "id_pregunta_opcion", unique = true, nullable = false)
    @NotNull
    private Integer idpreguntaopcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion")
    @NotNull
    @JsonManagedReference
    private Opciones tbopciones;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    @NotNull
    @JsonBackReference
    private Preguntas tbpreguntas;
    
    @NotNull
    @NotEmpty
    @Size(max = 1)
    @Column(name = "estado_pregunta_opcion", nullable = false)
    private String estadopreguntaopcion;
}
