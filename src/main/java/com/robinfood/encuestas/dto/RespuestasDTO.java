package com.robinfood.encuestas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespuestasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Date fecharegistro;
    @NotNull
    private Integer idencuesta;

    private Integer idrespuesta;
    
    @Size(max = 70)
    private String nombreencuestado;
}
