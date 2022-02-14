CREATE TABLE TB_PREGUNTA_OPCIONES (
    id_pregunta_opcion     SERIAL PRIMARY KEY NOT NULL,
    id_pregunta            SMALLINT NOT NULL,
    id_opcion              SMALLINT NOT NULL,
    estado_pregunta_opcion CHAR(1) NOT NULL,
	UNIQUE(id_pregunta, id_opcion)
);

COMMENT ON COLUMN tb_pregunta_opciones.id_pregunta_opcion IS
    'Identificador de la relacion';

COMMENT ON COLUMN tb_pregunta_opciones.id_pregunta IS
    'Pregunta relacionada a la opcion';

COMMENT ON COLUMN tb_pregunta_opciones.id_opcion IS
    'Opcion relacionada a la pregunta';

COMMENT ON COLUMN tb_pregunta_opciones.estado_pregunta_opcion IS
    'Estado de la relacion. A - Activo I - Inactivo';
	
alter table TB_PREGUNTA_OPCIONES
  add constraint CK_ESTADO
  check (estado_pregunta_opcion IN ('A', 'I'));
  
alter table TB_PREGUNTA_OPCIONES
   add constraint FK_PREGUNTA_OPCIONES_P
   foreign key (id_pregunta)
   references TB_PREGUNTAS(id_pregunta);

alter table TB_PREGUNTA_OPCIONES
   add constraint FK_PREGUNTA_OPCIONES_O
   foreign key (id_opcion)
   references TB_OPCIONES(id_opcion);