package com.robinfood.encuestas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespuestasAbiertasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer idpregunta;
    @NotNull
    @JsonIgnore
    private Integer idrespuestaabierta;
    @NotNull
    @JsonIgnore
    private Integer idrespuestaencuesta;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String respuesta;
}
