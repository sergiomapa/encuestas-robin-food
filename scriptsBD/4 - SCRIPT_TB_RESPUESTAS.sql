CREATE TABLE TB_RESPUESTAS (
    id_respuesta     		 SERIAL PRIMARY KEY NOT NULL,
    id_encuesta              SMALLINT NOT NULL,
    nombre_encuestado        VARCHAR(70) DEFAULT 'Anónimo' NOT NULL,
	fecha_registro			 DATE DEFAULT NOW() NOT NULL
);

COMMENT ON COLUMN tb_respuestas.id_respuesta IS
    'Identificador de la respuesta en base de datos';

COMMENT ON COLUMN tb_respuestas.id_encuesta IS
    'Encuesta relacionada a la respuesta del encuestado';

COMMENT ON COLUMN tb_respuestas.nombre_encuestado IS
    'Nombre del encuestado. Por defecto Anónimo';

COMMENT ON COLUMN tb_respuestas.fecha_registro IS
    'Fecha de registro de la encuesta';
	
alter table TB_RESPUESTAS
   add constraint FK_ENCUESTA_RESPUESTA
   foreign key (id_encuesta)
   references TB_ENCUESTAS(id_encuesta);