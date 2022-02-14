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
*	Entidad de relacion Encuestas - Preguntas
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Builder
@Entity
@Table(name = "tb_encuesta_preguntas", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncuestaPreguntas implements java.io.Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_encuesta_pregunta", unique = true, nullable = false)
    @NotNull
    private Integer idencuestapregunta;
    
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta")
    @NotNull
    @JsonBackReference
    private Encuestas tbencuestas;
    
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    @NotNull
    @JsonManagedReference
    private Preguntas tbpreguntas;
    
    @NotNull
    @NotEmpty
    @Size(max = 1)
    @Column(name = "estado_encuesta_pregunta", nullable = false)
    private String estadoencuestapregunta;	
}
