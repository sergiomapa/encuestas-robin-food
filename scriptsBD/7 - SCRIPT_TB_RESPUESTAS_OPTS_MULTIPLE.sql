CREATE TABLE TB_RESPUESTAS_OPTS_MULTIPLE (
    id_respuesta_multiple  SERIAL PRIMARY KEY NOT NULL,
    id_respuesta_encuesta  SMALLINT NOT NULL,
	id_pregunta     	   SMALLINT NOT NULL,
	id_opcion	     	   SMALLINT NOT NULL,
	UNIQUE(id_respuesta_encuesta, id_pregunta)
);

COMMENT ON COLUMN tb_respuestas_opts_multiple.id_respuesta_multiple IS
    'Identificador de la relacion';

COMMENT ON COLUMN tb_respuestas_opts_multiple.id_respuesta_encuesta IS
    'Identificador de la tabla maestra relacionada a respuesta encuesta';
	
COMMENT ON COLUMN tb_respuestas_opts_multiple.id_pregunta IS
    'Identificador de la pregunta';

COMMENT ON COLUMN tb_respuestas_opts_multiple.id_opcion IS
    'Opcion seleccionada como respuesta para la pregunta.';
	  
alter table TB_RESPUESTAS_OPTS_MULTIPLE
   add constraint FK_RESPUESTA_ENCUESTA
   foreign key (id_respuesta_encuesta)
   references TB_RESPUESTAS(id_respuesta);

alter table TB_RESPUESTAS_OPTS_MULTIPLE
   add constraint FK_PREGUNTA_RESPUESTA
   foreign key (id_pregunta)
   references TB_PREGUNTAS(id_pregunta);
   
alter table TB_RESPUESTAS_OPTS_MULTIPLE
   add constraint FK_OPT_PREGUNTA_RESPUESTA
   foreign key (id_opcion)
   references TB_OPCIONES(id_opcion);