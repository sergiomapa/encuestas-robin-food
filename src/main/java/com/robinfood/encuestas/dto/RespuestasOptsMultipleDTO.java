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
public class RespuestasOptsMultipleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer idopcion;
    @NotNull
    private Integer idpregunta;
    @NotNull
    @JsonIgnore
    private Integer idrespuestaencuesta;
    @NotNull
    @JsonIgnore
    private Integer idrespuestamultiple;
}
