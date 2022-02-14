CREATE TABLE TB_ENCUESTAS (
    id_encuesta          SERIAL PRIMARY KEY NOT NULL,
    cod_encuesta         VARCHAR(3) NOT NULL UNIQUE,
    nombre_encuesta      VARCHAR(255) NOT NULL,
    descripcion_encuesta VARCHAR(255) NOT NULL,
    estado_encuesta      CHAR(1) NOT NULL
);

COMMENT ON COLUMN tb_encuestas.id_encuesta IS
    'Identificador de la  encuesta en base de datos';

COMMENT ON COLUMN tb_encuestas.cod_encuesta IS
    'Codigo de la encuesta';

COMMENT ON COLUMN tb_encuestas.nombre_encuesta IS
    'Nombre de la encuesta';

COMMENT ON COLUMN tb_encuestas.descripcion_encuesta IS
    'Descripcion de la encuesta';

COMMENT ON COLUMN tb_encuestas.estado_encuesta IS
    'Estado de la encuesta';

alter table TB_ENCUESTAS
  add constraint CK_ESTADO
  check (estado_encuesta IN ('A', 'I'));
  
CREATE INDEX IDX_COD_ENCUESTA
ON TB_ENCUESTAS (cod_encuesta);