CREATE TABLE TB_ENCUESTA_PREGUNTAS (
    id_encuesta_pregunta     SERIAL PRIMARY KEY NOT NULL,
    id_encuesta              SMALLINT NOT NULL,
    id_pregunta              SMALLINT NOT NULL,
    estado_encuesta_pregunta CHAR(1) NOT NULL,
	UNIQUE(id_encuesta, id_pregunta)
);

COMMENT ON COLUMN tb_encuesta_preguntas.id_encuesta_pregunta IS
    'Identificador de la relacion en base de datos';

COMMENT ON COLUMN tb_encuesta_preguntas.id_encuesta IS
    'Encuesta relacionada a la pregunta';

COMMENT ON COLUMN tb_encuesta_preguntas.id_pregunta IS
    'Pregunta relacionada a la encuesta';

COMMENT ON COLUMN tb_encuesta_preguntas.estado_encuesta_pregunta IS
    'Estado de la relacion. A - Activo I - Inactivo';
	
alter table TB_ENCUESTA_PREGUNTAS
  add constraint CK_ESTADO
  check (estado_encuesta_pregunta IN ('A', 'I'));
  
alter table TB_ENCUESTA_PREGUNTAS
   add constraint FK_ENCUESTA_PREGUNTA_E
   foreign key (id_encuesta)
   references TB_ENCUESTAS(id_encuesta);

alter table TB_ENCUESTA_PREGUNTAS
   add constraint FK_ENCUESTA_PREGUNTA_P
   foreign key (id_pregunta)
   references TB_PREGUNTAS(id_pregunta);