package com.robinfood.encuestas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
*	Entidad de Respuestas Abiertas
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Entity
@Table(name = "tb_respuestas_abiertas", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestasAbiertas implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonIgnore
    @Column(name = "id_respuesta_abierta", unique = true, nullable = false)
    private Integer idrespuestaabierta;
    @NotNull
    @Column(name = "id_pregunta", nullable = false)
    private Integer idpregunta;
    @NotNull
    @JsonIgnore
    @Column(name = "id_respuesta_encuesta", nullable = false)
    private Integer idrespuestaencuesta;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    @Column(name = "respuesta", nullable = false)
    private String respuesta;
}
