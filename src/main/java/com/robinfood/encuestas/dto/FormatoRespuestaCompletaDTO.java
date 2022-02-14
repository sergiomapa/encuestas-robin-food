package com.robinfood.encuestas.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.robinfood.encuestas.domain.EncuestaPreguntas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormatoRespuestaCompletaDTO {

private static final long serialVersionUID = 1L;
    
    @NotNull
    private Integer idencuesta;
    
    @Size(max = 70)
    private String nombreencuestado;
    
    @NotNull
    @NotEmpty
    private List<RespuestasOptsMultipleDTO> listrespuestasoptmultiple;
    
    @NotNull
    @NotEmpty
    private List<RespuestasAbiertasDTO> listrespuestasabiertas;
    
}
