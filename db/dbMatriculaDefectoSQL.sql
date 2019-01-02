PGDMP         ,                 w         
   dbMaternal    10.6    10.6 $    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            |          0    16577    alumno 
   TABLE DATA               �   COPY public.alumno (id_alumno, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, edad, tipo_sangre, id_nota, alergias, id_pago, sexo, fecha_nacimiento, direccion, foto) FROM stdin;
    public       postgres    false    197   v        �          0    16599    asistencia_a 
   TABLE DATA               _   COPY public.asistencia_a (id_asistencia, id_alumno, id_usuario, asistencia, fecha) FROM stdin;
    public       postgres    false    201   �        �          0    16793    asistencia_d 
   TABLE DATA               c   COPY public.asistencia_d (id_asistencia_d, id_empleado, asistencia, fecha, id_usuario) FROM stdin;
    public       postgres    false    225   �        �          0    16611    empleado 
   TABLE DATA               �   COPY public.empleado (id_empleado, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, edad, telefono1, telefono2, direccion, correo, cedula, sexo, fecha_nacimiento) FROM stdin;
    public       postgres    false    205   �        �          0    16619 	   matricula 
   TABLE DATA               [   COPY public.matricula (id_matricula, id_alumno, id_empleado, seccion, periodo) FROM stdin;
    public       postgres    false    207   �        �          0    16631    nota 
   TABLE DATA               L   COPY public.nota (id_nota, nota, id_empleado, id_alumno, fecha) FROM stdin;
    public       postgres    false    211   !       �          0    16643    pago 
   TABLE DATA               L   COPY public.pago (id_pago, id_alumno, total, mora, saldo_favor) FROM stdin;
    public       postgres    false    215   9!       �          0    16650    representante 
   TABLE DATA               �   COPY public.representante (id_representante, primer_nombre, primer_apellido, edad, telefono1, telefono2, direccion, correo, id_alumno, parentesco, ocupacion, sexo, fecha_nacimiento, cedula, empresa, foto, tipo) FROM stdin;
    public       postgres    false    218   V!       �          0    16826 
   requisitos 
   TABLE DATA               �   COPY public.requisitos (id_requisito, id_alumno, partida, foto_postal, foto_carnet, foto_familiar, cedula_padres, observaciones) FROM stdin;
    public       postgres    false    227   s!       �          0    16660    usuario 
   TABLE DATA               �   COPY public.usuario (id_usuario, id_empleado, nombre_usuario, clave, pregunta_secreta, respuesta_secreta, admin, activo) FROM stdin;
    public       postgres    false    221   �!       �          0    16868 	   variables 
   TABLE DATA               �   COPY public.variables (id_variable, iva, ubicacion_reporte, limite_alumno, precio_mora, precio_cuota, dias_mora, periodo_actual) FROM stdin;
    public       postgres    false    229   �!       �           0    0    alumno_id_nota_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.alumno_id_nota_seq', 1, true);
            public       postgres    false    198            �           0    0    alumno_id_pago_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.alumno_id_pago_seq', 1, true);
            public       postgres    false    199            �           0    0    alumnos_id_alumnos_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.alumnos_id_alumnos_seq', 1, true);
            public       postgres    false    200            �           0    0    asistencia_A_id_alumno_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public."asistencia_A_id_alumno_seq"', 1, false);
            public       postgres    false    202            �           0    0    asistencia_A_id_asistencia_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public."asistencia_A_id_asistencia_seq"', 1, true);
            public       postgres    false    203            �           0    0    asistencia_A_id_empleado_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public."asistencia_A_id_empleado_seq"', 1, true);
            public       postgres    false    204            �           0    0     asistencia_d_id_asistencia_d_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.asistencia_d_id_asistencia_d_seq', 1, true);
            public       postgres    false    224            �           0    0    empleado_id_empleado_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.empleado_id_empleado_seq', 1, true);
            public       postgres    false    206            �           0    0    matricula_id_alumno_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.matricula_id_alumno_seq', 1, false);
            public       postgres    false    208            �           0    0    matricula_id_empleado_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.matricula_id_empleado_seq', 1, true);
            public       postgres    false    209            �           0    0    matricula_id_matricula_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.matricula_id_matricula_seq', 1, true);
            public       postgres    false    210            �           0    0    nota_id_alumno_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.nota_id_alumno_seq', 1, false);
            public       postgres    false    212            �           0    0    nota_id_empleado_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.nota_id_empleado_seq', 1, false);
            public       postgres    false    213            �           0    0    nota_id_nota_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.nota_id_nota_seq', 1, true);
            public       postgres    false    214            �           0    0    pago_id_alumno_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.pago_id_alumno_seq', 1, false);
            public       postgres    false    216            �           0    0    pago_id_pago_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.pago_id_pago_seq', 1, true);
            public       postgres    false    217            �           0    0    representante_id_alumno_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.representante_id_alumno_seq', 1, false);
            public       postgres    false    219            �           0    0 "   representante_id_representante_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.representante_id_representante_seq', 1, true);
            public       postgres    false    220            �           0    0    requisitos_id_requisito_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.requisitos_id_requisito_seq', 1, true);
            public       postgres    false    226            �           0    0    usuario_id_empleado_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.usuario_id_empleado_seq', 1, false);
            public       postgres    false    222            �           0    0    usuario_id_usuario_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 2, true);
            public       postgres    false    223            �           0    0    variables_id_variable_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.variables_id_variable_seq', 1, true);
            public       postgres    false    228            |      x������ � �      �      x������ � �      �      x������ � �      �   "   x�3�LL����B�a�p�rp��qqq b5%      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   &   x�3�4�LL��̃��F�F�f�&�F�%�%\1z\\\ ���      �   !   x�3�4����42��@#C] a����� L��     