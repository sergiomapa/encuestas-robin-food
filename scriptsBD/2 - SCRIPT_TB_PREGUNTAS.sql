CREATE TABLE TB_PREGUNTAS (
    id_pregunta          SERIAL PRIMARY KEY NOT NULL,
    descripcion_pregunta VARCHAR(255) NOT NULL,
    estado_pregunta      CHAR(1) NOT NULL
);

COMMENT ON COLUMN TB_PREGUNTAS.id_pregunta IS
    'Identificador de la pregunta en base de datos';

COMMENT ON COLUMN TB_PREGUNTAS.descripcion_pregunta IS
    'Descripcion de la pregunta';

COMMENT ON COLUMN TB_PREGUNTAS.estado_pregunta IS
    'Estado de la pregunta. A - Activo I - Inactivo';

alter table TB_PREGUNTAS
  add constraint CK_ESTADO
  check (estado_pregunta IN ('A', 'I'));