package com.robinfood.encuestas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
*	Entidad de Respuestas Opcion Multiple
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Entity
@Table(name = "tb_respuestas_opts_multiple", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestasOptsMultiple implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_respuesta_multiple", unique = true, nullable = false)
    private Integer idrespuestamultiple;
    @NotNull
    @Column(name = "id_opcion", nullable = false)
    private Integer idopcion;
    @JsonIgnore
    @NotNull
    @Column(name = "id_pregunta", nullable = false)
    private Integer idpregunta;
    @JsonIgnore
    @NotNull
    @Column(name = "id_respuesta_encuesta", nullable = false)
    private Integer idrespuestaencuesta;
}
