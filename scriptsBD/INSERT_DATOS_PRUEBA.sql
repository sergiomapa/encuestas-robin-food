--
-- TOC entry 2913 (class 0 OID 24712)
-- Dependencies: 207
-- Data for Name: tb_encuestas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_encuestas (id_encuesta, cod_encuesta, nombre_encuesta, descripcion_encuesta, estado_encuesta) VALUES (nextval('tb_encuestas_id_encuesta_seq'), 'EC1', 'Encuesta satisfacción cliente', 'Encuesta para saber la satisfacción del cliente con el servicio brindado', 'A');


--
-- TOC entry 2911 (class 0 OID 24703)
-- Dependencies: 205
-- Data for Name: tb_opciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_opciones (id_opcion, descripcion_opcion, estado_opcion) VALUES (nextval('tb_opciones_id_opcion_seq'), 'Buena', 'A');
INSERT INTO public.tb_opciones (id_opcion, descripcion_opcion, estado_opcion) VALUES (nextval('tb_opciones_id_opcion_seq'), 'Regular', 'A');
INSERT INTO public.tb_opciones (id_opcion, descripcion_opcion, estado_opcion) VALUES (nextval('tb_opciones_id_opcion_seq'), 'Mala', 'A');
INSERT INTO public.tb_opciones (id_opcion, descripcion_opcion, estado_opcion) VALUES (nextval('tb_opciones_id_opcion_seq'), 'Alimentos', 'A');
INSERT INTO public.tb_opciones (id_opcion, descripcion_opcion, estado_opcion) VALUES (nextval('tb_opciones_id_opcion_seq'), 'Bebidas', 'A');
INSERT INTO public.tb_opciones (id_opcion, descripcion_opcion, estado_opcion) VALUES (nextval('tb_opciones_id_opcion_seq'), 'SI', 'A');
INSERT INTO public.tb_opciones (id_opcion, descripcion_opcion, estado_opcion) VALUES (nextval('tb_opciones_id_opcion_seq'), 'NO', 'A');


--
-- TOC entry 2909 (class 0 OID 24694)
-- Dependencies: 203
-- Data for Name: tb_preguntas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_preguntas (id_pregunta, descripcion_pregunta, estado_pregunta) VALUES (nextval('tb_preguntas_id_pregunta_seq'), '¿Cómo te pareció la atención?', 'A');
INSERT INTO public.tb_preguntas (id_pregunta, descripcion_pregunta, estado_pregunta) VALUES (nextval('tb_preguntas_id_pregunta_seq'), '¿Qué prefieres alimentos o bebidas?', 'A');
INSERT INTO public.tb_preguntas (id_pregunta, descripcion_pregunta, estado_pregunta) VALUES (nextval('tb_preguntas_id_pregunta_seq'), '¿Te gustaría tener una sede más cerca?', 'A');
INSERT INTO public.tb_preguntas (id_pregunta, descripcion_pregunta, estado_pregunta) VALUES (nextval('tb_preguntas_id_pregunta_seq'), '¿Qué le incluirías a nuestra carta?', 'A');

--
-- TOC entry 2917 (class 0 OID 24748)
-- Dependencies: 211
-- Data for Name: tb_pregunta_opciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_pregunta_opciones (id_pregunta_opcion, id_pregunta, id_opcion, estado_pregunta_opcion) VALUES (nextval('tb_pregunta_opciones_id_pregunta_opcion_seq'), 1, 1, 'A');
INSERT INTO public.tb_pregunta_opciones (id_pregunta_opcion, id_pregunta, id_opcion, estado_pregunta_opcion) VALUES (nextval('tb_pregunta_opciones_id_pregunta_opcion_seq'), 1, 2, 'A');
INSERT INTO public.tb_pregunta_opciones (id_pregunta_opcion, id_pregunta, id_opcion, estado_pregunta_opcion) VALUES (nextval('tb_pregunta_opciones_id_pregunta_opcion_seq'), 1, 3, 'A');
INSERT INTO public.tb_pregunta_opciones (id_pregunta_opcion, id_pregunta, id_opcion, estado_pregunta_opcion) VALUES (nextval('tb_pregunta_opciones_id_pregunta_opcion_seq'), 2, 4, 'A');
INSERT INTO public.tb_pregunta_opciones (id_pregunta_opcion, id_pregunta, id_opcion, estado_pregunta_opcion) VALUES (nextval('tb_pregunta_opciones_id_pregunta_opcion_seq'), 2, 5, 'A');
INSERT INTO public.tb_pregunta_opciones (id_pregunta_opcion, id_pregunta, id_opcion, estado_pregunta_opcion) VALUES (nextval('tb_pregunta_opciones_id_pregunta_opcion_seq'), 3, 6, 'A');
INSERT INTO public.tb_pregunta_opciones (id_pregunta_opcion, id_pregunta, id_opcion, estado_pregunta_opcion) VALUES (nextval('tb_pregunta_opciones_id_pregunta_opcion_seq'), 3, 7, 'A');




INSERT INTO public.tb_encuesta_preguntas (id_encuesta_pregunta, id_encuesta, id_pregunta, estado_encuesta_pregunta) VALUES (nextval('tb_encuesta_preguntas_id_encuesta_pregunta_seq'), 1, 1, 'A');
INSERT INTO public.tb_encuesta_preguntas (id_encuesta_pregunta, id_encuesta, id_pregunta, estado_encuesta_pregunta) VALUES (nextval('tb_encuesta_preguntas_id_encuesta_pregunta_seq'), 1, 2, 'A');
INSERT INTO public.tb_encuesta_preguntas (id_encuesta_pregunta, id_encuesta, id_pregunta, estado_encuesta_pregunta) VALUES (nextval('tb_encuesta_preguntas_id_encuesta_pregunta_seq'), 1, 3, 'A');
INSERT INTO public.tb_encuesta_preguntas (id_encuesta_pregunta, id_encuesta, id_pregunta, estado_encuesta_pregunta) VALUES (nextval('tb_encuesta_preguntas_id_encuesta_pregunta_seq'), 1, 4, 'A');


--
-- TOC entry 2919 (class 0 OID 32770)
-- Dependencies: 213
-- Data for Name: tb_respuestas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_respuestas (id_respuesta, id_encuesta, nombre_encuestado, fecha_registro) VALUES (nextval('tb_respuestas_id_respuesta_seq'), 1, 'Lupe', '2022-02-13');


--
-- TOC entry 2923 (class 0 OID 32820)
-- Dependencies: 217
-- Data for Name: tb_respuestas_abiertas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_respuestas_abiertas (id_respuesta_abierta, id_respuesta_encuesta, id_pregunta, respuesta) VALUES (nextval('tb_respuestas_abiertas_id_respuesta_abierta_seq'), 1, 4, 'Margaritas y comida mexicana');


--
-- TOC entry 2921 (class 0 OID 32795)
-- Dependencies: 215
-- Data for Name: tb_respuestas_opts_multiple; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_respuestas_opts_multiple (id_respuesta_multiple, id_respuesta_encuesta, id_pregunta, id_opcion) VALUES (nextval('tb_respuestas_opts_multiple_id_respuesta_multiple_seq'), 1, 1, 1);
INSERT INTO public.tb_respuestas_opts_multiple (id_respuesta_multiple, id_respuesta_encuesta, id_pregunta, id_opcion) VALUES (nextval('tb_respuestas_opts_multiple_id_respuesta_multiple_seq'), 1, 2, 5);
INSERT INTO public.tb_respuestas_opts_multiple (id_respuesta_multiple, id_respuesta_encuesta, id_pregunta, id_opcion) VALUES (nextval('tb_respuestas_opts_multiple_id_respuesta_multiple_seq'), 1, 3, 6);