CREATE TABLE TB_OPCIONES (
    id_opcion          SERIAL PRIMARY KEY NOT NULL,
    descripcion_opcion VARCHAR(255) NOT NULL,
    estado_opcion      CHAR(1) NOT NULL
);

COMMENT ON COLUMN TB_OPCIONES.id_opcion IS
    'Identificador de la opcion en base de datos';

COMMENT ON COLUMN TB_OPCIONES.descripcion_opcion IS
    'Descripcion de la opcion. Valor visible en la pregunta de la encuesta.';

COMMENT ON COLUMN TB_OPCIONES.estado_opcion IS
    'Estado de la opcion. A - Activo I - Inactivo';

alter table TB_OPCIONES
  add constraint CK_ESTADO
  check (estado_opcion IN ('A', 'I'));