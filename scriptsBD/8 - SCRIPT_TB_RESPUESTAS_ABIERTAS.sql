CREATE TABLE TB_RESPUESTAS_ABIERTAS
(
    id_respuesta_abierta     	SERIAL PRIMARY KEY NOT NULL,
    id_respuesta_encuesta 		SMALLINT NOT NULL,
    id_pregunta 				SMALLINT NOT NULL,
    respuesta 					CHARACTER VARYING(255) NOT NULL
);

COMMENT ON COLUMN public.tb_respuestas_abiertas.id_respuesta_abierta
    IS 'Identificador de la relacion';

COMMENT ON COLUMN public.tb_respuestas_abiertas.id_respuesta_encuesta
    IS 'Identificador de la tabla maestra relacionada a respuesta encuesta';

COMMENT ON COLUMN public.tb_respuestas_abiertas.id_pregunta
    IS 'Identificador de la pregunta';

COMMENT ON COLUMN public.tb_respuestas_abiertas.respuesta
    IS 'información de la respuesta para la pregunta';
	

alter table TB_RESPUESTAS_ABIERTAS
   add constraint FK_RESPUESTA_ENCUESTA
   foreign key (id_respuesta_encuesta)
   references TB_RESPUESTAS(id_respuesta);
   

alter table TB_RESPUESTAS_ABIERTAS
   add constraint FK_PREGUNTA_RESPUESTA
   foreign key (id_pregunta)
   references TB_PREGUNTAS(id_pregunta);