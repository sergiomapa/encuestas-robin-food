package com.robinfood.encuestas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.*;

import com.robinfood.encuestas.domain.EncuestaPreguntas;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncuestasDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @NotNull
    private Integer idencuesta;
    
    @NotNull
    @NotEmpty
    @Size(max = 3)
    private String codencuesta;
    
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombreencuesta;
    
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String descripcionencuesta;
    
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estadoencuesta;
    private List<EncuestaPreguntas> tbencuestapreguntases;
}
