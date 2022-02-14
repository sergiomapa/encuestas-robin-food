package com.robinfood.encuestas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
*	Entidad de Respuestas
* 	@author Sergio Ivan Mayor - sergiomapa0206@gmail.com
*
*/
@Entity
@Table(name = "tb_respuestas", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Respuestas implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_respuesta", unique = true, nullable = false)
    @NotNull
    private Integer idRespuesta;
    
    @Column(name = "fecha_registro")
    private Date fecharegistro;
    
    @NotNull
    @Column(name = "id_encuesta", nullable = false)
    private Integer idencuesta;
    
    @Size(max = 70)
    @Column(name = "nombre_encuestado", nullable = false)
    private String nombreencuestado;    
    
    @PrePersist
    protected void onCreate() {
    	if(nombreencuestado == null) {nombreencuestado = "Anónimo";}
    	fecharegistro = new Date();
    }
}
