PGDMP     "    7                 w         
   dbMaternal    10.6    10.6 �    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    16576 
   dbMaternal    DATABASE     �   CREATE DATABASE "dbMaternal" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Bolivarian Republic of Venezuela.1252' LC_CTYPE = 'Spanish_Bolivarian Republic of Venezuela.1252';
    DROP DATABASE "dbMaternal";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    4                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    2                        3079    16815 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                  false            �           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                       false    1            �            1259    16577    alumno    TABLE     j  CREATE TABLE public.alumno (
    id_alumno integer NOT NULL,
    primer_nombre text,
    segundo_nombre text,
    primer_apellido text,
    segundo_apellido text,
    edad integer,
    tipo_sangre text,
    id_nota integer NOT NULL,
    alergias text,
    id_pago integer NOT NULL,
    sexo text,
    fecha_nacimiento text,
    direccion text,
    foto bytea
);
    DROP TABLE public.alumno;
       public         postgres    false    4            �            1259    16583    alumno_id_nota_seq    SEQUENCE     {   CREATE SEQUENCE public.alumno_id_nota_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.alumno_id_nota_seq;
       public       postgres    false    4    197            �           0    0    alumno_id_nota_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.alumno_id_nota_seq OWNED BY public.alumno.id_nota;
            public       postgres    false    198            �            1259    16585    alumno_id_pago_seq    SEQUENCE     {   CREATE SEQUENCE public.alumno_id_pago_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.alumno_id_pago_seq;
       public       postgres    false    197    4            �           0    0    alumno_id_pago_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.alumno_id_pago_seq OWNED BY public.alumno.id_pago;
            public       postgres    false    199            �            1259    16587    alumnos_id_alumnos_seq    SEQUENCE        CREATE SEQUENCE public.alumnos_id_alumnos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.alumnos_id_alumnos_seq;
       public       postgres    false    197    4            �           0    0    alumnos_id_alumnos_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.alumnos_id_alumnos_seq OWNED BY public.alumno.id_alumno;
            public       postgres    false    200            �            1259    16599    asistencia_a    TABLE     �   CREATE TABLE public.asistencia_a (
    id_asistencia integer NOT NULL,
    id_alumno integer NOT NULL,
    id_usuario integer NOT NULL,
    asistencia boolean,
    fecha text
);
     DROP TABLE public.asistencia_a;
       public         postgres    false    4            �            1259    16605    asistencia_A_id_alumno_seq    SEQUENCE     �   CREATE SEQUENCE public."asistencia_A_id_alumno_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public."asistencia_A_id_alumno_seq";
       public       postgres    false    4    201            �           0    0    asistencia_A_id_alumno_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public."asistencia_A_id_alumno_seq" OWNED BY public.asistencia_a.id_alumno;
            public       postgres    false    202            �            1259    16607    asistencia_A_id_asistencia_seq    SEQUENCE     �   CREATE SEQUENCE public."asistencia_A_id_asistencia_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public."asistencia_A_id_asistencia_seq";
       public       postgres    false    4    201            �           0    0    asistencia_A_id_asistencia_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public."asistencia_A_id_asistencia_seq" OWNED BY public.asistencia_a.id_asistencia;
            public       postgres    false    203            �            1259    16609    asistencia_A_id_empleado_seq    SEQUENCE     �   CREATE SEQUENCE public."asistencia_A_id_empleado_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public."asistencia_A_id_empleado_seq";
       public       postgres    false    201    4            �           0    0    asistencia_A_id_empleado_seq    SEQUENCE OWNED BY     ^   ALTER SEQUENCE public."asistencia_A_id_empleado_seq" OWNED BY public.asistencia_a.id_usuario;
            public       postgres    false    204            �            1259    16793    asistencia_d    TABLE     �   CREATE TABLE public.asistencia_d (
    id_asistencia_d integer NOT NULL,
    id_empleado integer,
    asistencia boolean,
    fecha text,
    id_usuario integer
);
     DROP TABLE public.asistencia_d;
       public         postgres    false    4            �            1259    16791     asistencia_d_id_asistencia_d_seq    SEQUENCE     �   CREATE SEQUENCE public.asistencia_d_id_asistencia_d_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.asistencia_d_id_asistencia_d_seq;
       public       postgres    false    225    4            �           0    0     asistencia_d_id_asistencia_d_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.asistencia_d_id_asistencia_d_seq OWNED BY public.asistencia_d.id_asistencia_d;
            public       postgres    false    224            �            1259    16611    empleado    TABLE     C  CREATE TABLE public.empleado (
    id_empleado integer NOT NULL,
    primer_nombre text,
    segundo_nombre text,
    primer_apellido text,
    segundo_apellido text,
    edad integer,
    telefono1 text,
    telefono2 text,
    direccion text,
    correo text,
    cedula text,
    sexo text,
    fecha_nacimiento text
);
    DROP TABLE public.empleado;
       public         postgres    false    4            �            1259    16617    empleado_id_empleado_seq    SEQUENCE     �   CREATE SEQUENCE public.empleado_id_empleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.empleado_id_empleado_seq;
       public       postgres    false    205    4            �           0    0    empleado_id_empleado_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.empleado_id_empleado_seq OWNED BY public.empleado.id_empleado;
            public       postgres    false    206            �            1259    16619 	   matricula    TABLE     �   CREATE TABLE public.matricula (
    id_matricula integer NOT NULL,
    id_alumno integer NOT NULL,
    id_empleado integer NOT NULL,
    seccion text,
    periodo text
);
    DROP TABLE public.matricula;
       public         postgres    false    4            �            1259    16625    matricula_id_alumno_seq    SEQUENCE     �   CREATE SEQUENCE public.matricula_id_alumno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.matricula_id_alumno_seq;
       public       postgres    false    4    207            �           0    0    matricula_id_alumno_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.matricula_id_alumno_seq OWNED BY public.matricula.id_alumno;
            public       postgres    false    208            �            1259    16627    matricula_id_empleado_seq    SEQUENCE     �   CREATE SEQUENCE public.matricula_id_empleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.matricula_id_empleado_seq;
       public       postgres    false    4    207            �           0    0    matricula_id_empleado_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.matricula_id_empleado_seq OWNED BY public.matricula.id_empleado;
            public       postgres    false    209            �            1259    16629    matricula_id_matricula_seq    SEQUENCE     �   CREATE SEQUENCE public.matricula_id_matricula_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.matricula_id_matricula_seq;
       public       postgres    false    4    207            �           0    0    matricula_id_matricula_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.matricula_id_matricula_seq OWNED BY public.matricula.id_matricula;
            public       postgres    false    210            �            1259    16631    nota    TABLE     �   CREATE TABLE public.nota (
    id_nota integer NOT NULL,
    nota text,
    id_empleado integer NOT NULL,
    id_alumno integer NOT NULL,
    fecha text
);
    DROP TABLE public.nota;
       public         postgres    false    4            �            1259    16637    nota_id_alumno_seq    SEQUENCE     {   CREATE SEQUENCE public.nota_id_alumno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.nota_id_alumno_seq;
       public       postgres    false    211    4            �           0    0    nota_id_alumno_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.nota_id_alumno_seq OWNED BY public.nota.id_alumno;
            public       postgres    false    212            �            1259    16639    nota_id_empleado_seq    SEQUENCE     }   CREATE SEQUENCE public.nota_id_empleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.nota_id_empleado_seq;
       public       postgres    false    4    211            �           0    0    nota_id_empleado_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.nota_id_empleado_seq OWNED BY public.nota.id_empleado;
            public       postgres    false    213            �            1259    16641    nota_id_nota_seq    SEQUENCE     y   CREATE SEQUENCE public.nota_id_nota_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.nota_id_nota_seq;
       public       postgres    false    211    4            �           0    0    nota_id_nota_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.nota_id_nota_seq OWNED BY public.nota.id_nota;
            public       postgres    false    214            �            1259    16643    pago    TABLE     �   CREATE TABLE public.pago (
    id_pago integer NOT NULL,
    id_alumno integer NOT NULL,
    total real,
    mora real,
    saldo_favor real
);
    DROP TABLE public.pago;
       public         postgres    false    4            �            1259    16646    pago_id_alumno_seq    SEQUENCE     {   CREATE SEQUENCE public.pago_id_alumno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.pago_id_alumno_seq;
       public       postgres    false    4    215            �           0    0    pago_id_alumno_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.pago_id_alumno_seq OWNED BY public.pago.id_alumno;
            public       postgres    false    216            �            1259    16648    pago_id_pago_seq    SEQUENCE     y   CREATE SEQUENCE public.pago_id_pago_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.pago_id_pago_seq;
       public       postgres    false    4    215            �           0    0    pago_id_pago_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.pago_id_pago_seq OWNED BY public.pago.id_pago;
            public       postgres    false    217            �            1259    16650    representante    TABLE     �  CREATE TABLE public.representante (
    id_representante integer NOT NULL,
    primer_nombre text,
    primer_apellido text,
    edad integer,
    telefono1 text,
    telefono2 text,
    direccion text,
    correo text,
    id_alumno integer NOT NULL,
    parentesco text,
    ocupacion text,
    sexo text,
    fecha_nacimiento text,
    cedula text,
    empresa text,
    foto bytea,
    tipo integer
);
 !   DROP TABLE public.representante;
       public         postgres    false    4            �            1259    16656    representante_id_alumno_seq    SEQUENCE     �   CREATE SEQUENCE public.representante_id_alumno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.representante_id_alumno_seq;
       public       postgres    false    218    4            �           0    0    representante_id_alumno_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.representante_id_alumno_seq OWNED BY public.representante.id_alumno;
            public       postgres    false    219            �            1259    16658 "   representante_id_representante_seq    SEQUENCE     �   CREATE SEQUENCE public.representante_id_representante_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.representante_id_representante_seq;
       public       postgres    false    4    218            �           0    0 "   representante_id_representante_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.representante_id_representante_seq OWNED BY public.representante.id_representante;
            public       postgres    false    220            �            1259    16826 
   requisitos    TABLE     �   CREATE TABLE public.requisitos (
    id_requisito integer NOT NULL,
    id_alumno integer,
    partida boolean,
    foto_postal boolean,
    foto_carnet boolean,
    foto_familiar boolean,
    cedula_padres boolean,
    observaciones text
);
    DROP TABLE public.requisitos;
       public         postgres    false    4            �            1259    16824    requisitos_id_requisito_seq    SEQUENCE     �   CREATE SEQUENCE public.requisitos_id_requisito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.requisitos_id_requisito_seq;
       public       postgres    false    227    4            �           0    0    requisitos_id_requisito_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.requisitos_id_requisito_seq OWNED BY public.requisitos.id_requisito;
            public       postgres    false    226            �            1259    16660    usuario    TABLE     �   CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    id_empleado integer NOT NULL,
    nombre_usuario text,
    clave text,
    pregunta_secreta text,
    respuesta_secreta text,
    admin boolean,
    activo boolean
);
    DROP TABLE public.usuario;
       public         postgres    false    4            �            1259    16666    usuario_id_empleado_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_empleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.usuario_id_empleado_seq;
       public       postgres    false    221    4            �           0    0    usuario_id_empleado_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.usuario_id_empleado_seq OWNED BY public.usuario.id_empleado;
            public       postgres    false    222            �            1259    16668    usuario_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    CYCLE;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public       postgres    false    221    4            �           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
            public       postgres    false    223            �            1259    16868 	   variables    TABLE     
  CREATE TABLE public.variables (
    id_variable integer NOT NULL,
    iva double precision,
    ubicacion_reporte text,
    limite_alumno integer,
    precio_mora double precision,
    precio_cuota double precision,
    dias_mora integer,
    periodo_actual text
);
    DROP TABLE public.variables;
       public         postgres    false    4            �            1259    16866    variables_id_variable_seq    SEQUENCE     �   CREATE SEQUENCE public.variables_id_variable_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.variables_id_variable_seq;
       public       postgres    false    4    229            �           0    0    variables_id_variable_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.variables_id_variable_seq OWNED BY public.variables.id_variable;
            public       postgres    false    228            �
           2604    16670    alumno id_alumno    DEFAULT     v   ALTER TABLE ONLY public.alumno ALTER COLUMN id_alumno SET DEFAULT nextval('public.alumnos_id_alumnos_seq'::regclass);
 ?   ALTER TABLE public.alumno ALTER COLUMN id_alumno DROP DEFAULT;
       public       postgres    false    200    197            �
           2604    16671    alumno id_nota    DEFAULT     p   ALTER TABLE ONLY public.alumno ALTER COLUMN id_nota SET DEFAULT nextval('public.alumno_id_nota_seq'::regclass);
 =   ALTER TABLE public.alumno ALTER COLUMN id_nota DROP DEFAULT;
       public       postgres    false    198    197            �
           2604    16672    alumno id_pago    DEFAULT     p   ALTER TABLE ONLY public.alumno ALTER COLUMN id_pago SET DEFAULT nextval('public.alumno_id_pago_seq'::regclass);
 =   ALTER TABLE public.alumno ALTER COLUMN id_pago DROP DEFAULT;
       public       postgres    false    199    197            �
           2604    16673    asistencia_a id_asistencia    DEFAULT     �   ALTER TABLE ONLY public.asistencia_a ALTER COLUMN id_asistencia SET DEFAULT nextval('public."asistencia_A_id_asistencia_seq"'::regclass);
 I   ALTER TABLE public.asistencia_a ALTER COLUMN id_asistencia DROP DEFAULT;
       public       postgres    false    203    201            �
           2604    16674    asistencia_a id_alumno    DEFAULT     �   ALTER TABLE ONLY public.asistencia_a ALTER COLUMN id_alumno SET DEFAULT nextval('public."asistencia_A_id_alumno_seq"'::regclass);
 E   ALTER TABLE public.asistencia_a ALTER COLUMN id_alumno DROP DEFAULT;
       public       postgres    false    202    201            �
           2604    16675    asistencia_a id_usuario    DEFAULT     �   ALTER TABLE ONLY public.asistencia_a ALTER COLUMN id_usuario SET DEFAULT nextval('public."asistencia_A_id_empleado_seq"'::regclass);
 F   ALTER TABLE public.asistencia_a ALTER COLUMN id_usuario DROP DEFAULT;
       public       postgres    false    204    201            �
           2604    16796    asistencia_d id_asistencia_d    DEFAULT     �   ALTER TABLE ONLY public.asistencia_d ALTER COLUMN id_asistencia_d SET DEFAULT nextval('public.asistencia_d_id_asistencia_d_seq'::regclass);
 K   ALTER TABLE public.asistencia_d ALTER COLUMN id_asistencia_d DROP DEFAULT;
       public       postgres    false    224    225    225            �
           2604    16678    empleado id_empleado    DEFAULT     |   ALTER TABLE ONLY public.empleado ALTER COLUMN id_empleado SET DEFAULT nextval('public.empleado_id_empleado_seq'::regclass);
 C   ALTER TABLE public.empleado ALTER COLUMN id_empleado DROP DEFAULT;
       public       postgres    false    206    205            �
           2604    16679    matricula id_matricula    DEFAULT     �   ALTER TABLE ONLY public.matricula ALTER COLUMN id_matricula SET DEFAULT nextval('public.matricula_id_matricula_seq'::regclass);
 E   ALTER TABLE public.matricula ALTER COLUMN id_matricula DROP DEFAULT;
       public       postgres    false    210    207            �
           2604    16680    matricula id_alumno    DEFAULT     z   ALTER TABLE ONLY public.matricula ALTER COLUMN id_alumno SET DEFAULT nextval('public.matricula_id_alumno_seq'::regclass);
 B   ALTER TABLE public.matricula ALTER COLUMN id_alumno DROP DEFAULT;
       public       postgres    false    208    207            �
           2604    16681    matricula id_empleado    DEFAULT     ~   ALTER TABLE ONLY public.matricula ALTER COLUMN id_empleado SET DEFAULT nextval('public.matricula_id_empleado_seq'::regclass);
 D   ALTER TABLE public.matricula ALTER COLUMN id_empleado DROP DEFAULT;
       public       postgres    false    209    207            �
           2604    16682    nota id_nota    DEFAULT     l   ALTER TABLE ONLY public.nota ALTER COLUMN id_nota SET DEFAULT nextval('public.nota_id_nota_seq'::regclass);
 ;   ALTER TABLE public.nota ALTER COLUMN id_nota DROP DEFAULT;
       public       postgres    false    214    211            �
           2604    16683    nota id_empleado    DEFAULT     t   ALTER TABLE ONLY public.nota ALTER COLUMN id_empleado SET DEFAULT nextval('public.nota_id_empleado_seq'::regclass);
 ?   ALTER TABLE public.nota ALTER COLUMN id_empleado DROP DEFAULT;
       public       postgres    false    213    211            �
           2604    16684    nota id_alumno    DEFAULT     p   ALTER TABLE ONLY public.nota ALTER COLUMN id_alumno SET DEFAULT nextval('public.nota_id_alumno_seq'::regclass);
 =   ALTER TABLE public.nota ALTER COLUMN id_alumno DROP DEFAULT;
       public       postgres    false    212    211            �
           2604    16685    pago id_pago    DEFAULT     l   ALTER TABLE ONLY public.pago ALTER COLUMN id_pago SET DEFAULT nextval('public.pago_id_pago_seq'::regclass);
 ;   ALTER TABLE public.pago ALTER COLUMN id_pago DROP DEFAULT;
       public       postgres    false    217    215            �
           2604    16686    pago id_alumno    DEFAULT     p   ALTER TABLE ONLY public.pago ALTER COLUMN id_alumno SET DEFAULT nextval('public.pago_id_alumno_seq'::regclass);
 =   ALTER TABLE public.pago ALTER COLUMN id_alumno DROP DEFAULT;
       public       postgres    false    216    215            �
           2604    16687    representante id_representante    DEFAULT     �   ALTER TABLE ONLY public.representante ALTER COLUMN id_representante SET DEFAULT nextval('public.representante_id_representante_seq'::regclass);
 M   ALTER TABLE public.representante ALTER COLUMN id_representante DROP DEFAULT;
       public       postgres    false    220    218            �
           2604    16688    representante id_alumno    DEFAULT     �   ALTER TABLE ONLY public.representante ALTER COLUMN id_alumno SET DEFAULT nextval('public.representante_id_alumno_seq'::regclass);
 F   ALTER TABLE public.representante ALTER COLUMN id_alumno DROP DEFAULT;
       public       postgres    false    219    218            �
           2604    16829    requisitos id_requisito    DEFAULT     �   ALTER TABLE ONLY public.requisitos ALTER COLUMN id_requisito SET DEFAULT nextval('public.requisitos_id_requisito_seq'::regclass);
 F   ALTER TABLE public.requisitos ALTER COLUMN id_requisito DROP DEFAULT;
       public       postgres    false    226    227    227            �
           2604    16689    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public       postgres    false    223    221            �
           2604    16690    usuario id_empleado    DEFAULT     z   ALTER TABLE ONLY public.usuario ALTER COLUMN id_empleado SET DEFAULT nextval('public.usuario_id_empleado_seq'::regclass);
 B   ALTER TABLE public.usuario ALTER COLUMN id_empleado DROP DEFAULT;
       public       postgres    false    222    221            �
           2604    16871    variables id_variable    DEFAULT     ~   ALTER TABLE ONLY public.variables ALTER COLUMN id_variable SET DEFAULT nextval('public.variables_id_variable_seq'::regclass);
 D   ALTER TABLE public.variables ALTER COLUMN id_variable DROP DEFAULT;
       public       postgres    false    229    228    229            |          0    16577    alumno 
   TABLE DATA               �   COPY public.alumno (id_alumno, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, edad, tipo_sangre, id_nota, alergias, id_pago, sexo, fecha_nacimiento, direccion, foto) FROM stdin;
    public       postgres    false    197   Ԧ       �          0    16599    asistencia_a 
   TABLE DATA               _   COPY public.asistencia_a (id_asistencia, id_alumno, id_usuario, asistencia, fecha) FROM stdin;
    public       postgres    false    201   �       �          0    16793    asistencia_d 
   TABLE DATA               c   COPY public.asistencia_d (id_asistencia_d, id_empleado, asistencia, fecha, id_usuario) FROM stdin;
    public       postgres    false    225   �       �          0    16611    empleado 
   TABLE DATA               �   COPY public.empleado (id_empleado, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, edad, telefono1, telefono2, direccion, correo, cedula, sexo, fecha_nacimiento) FROM stdin;
    public       postgres    false    205   +�       �          0    16619 	   matricula 
   TABLE DATA               [   COPY public.matricula (id_matricula, id_alumno, id_empleado, seccion, periodo) FROM stdin;
    public       postgres    false    207   ]�       �          0    16631    nota 
   TABLE DATA               L   COPY public.nota (id_nota, nota, id_empleado, id_alumno, fecha) FROM stdin;
    public       postgres    false    211   z�       �          0    16643    pago 
   TABLE DATA               L   COPY public.pago (id_pago, id_alumno, total, mora, saldo_favor) FROM stdin;
    public       postgres    false    215   ��       �          0    16650    representante 
   TABLE DATA               �   COPY public.representante (id_representante, primer_nombre, primer_apellido, edad, telefono1, telefono2, direccion, correo, id_alumno, parentesco, ocupacion, sexo, fecha_nacimiento, cedula, empresa, foto, tipo) FROM stdin;
    public       postgres    false    218   ��       �          0    16826 
   requisitos 
   TABLE DATA               �   COPY public.requisitos (id_requisito, id_alumno, partida, foto_postal, foto_carnet, foto_familiar, cedula_padres, observaciones) FROM stdin;
    public       postgres    false    227   ѧ       �          0    16660    usuario 
   TABLE DATA               �   COPY public.usuario (id_usuario, id_empleado, nombre_usuario, clave, pregunta_secreta, respuesta_secreta, admin, activo) FROM stdin;
    public       postgres    false    221   �       �          0    16868 	   variables 
   TABLE DATA               �   COPY public.variables (id_variable, iva, ubicacion_reporte, limite_alumno, precio_mora, precio_cuota, dias_mora, periodo_actual) FROM stdin;
    public       postgres    false    229   $�       �           0    0    alumno_id_nota_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.alumno_id_nota_seq', 1, true);
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
            public       postgres    false    228            �
           2606    16692    alumno alumnos_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (id_alumno);
 =   ALTER TABLE ONLY public.alumno DROP CONSTRAINT alumnos_pkey;
       public         postgres    false    197            �
           2606    16696    asistencia_a asistencia_A_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.asistencia_a
    ADD CONSTRAINT "asistencia_A_pkey" PRIMARY KEY (id_asistencia);
 J   ALTER TABLE ONLY public.asistencia_a DROP CONSTRAINT "asistencia_A_pkey";
       public         postgres    false    201            �
           2606    16801    asistencia_d asistencia_d_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.asistencia_d
    ADD CONSTRAINT asistencia_d_pkey PRIMARY KEY (id_asistencia_d);
 H   ALTER TABLE ONLY public.asistencia_d DROP CONSTRAINT asistencia_d_pkey;
       public         postgres    false    225            �
           2606    16698    empleado empleado_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (id_empleado);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public         postgres    false    205            �
           2606    16700    matricula matricula_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_pkey PRIMARY KEY (id_matricula);
 B   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_pkey;
       public         postgres    false    207            �
           2606    16702    nota nota_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_pkey PRIMARY KEY (id_nota);
 8   ALTER TABLE ONLY public.nota DROP CONSTRAINT nota_pkey;
       public         postgres    false    211            �
           2606    16704    pago pago_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pago
    ADD CONSTRAINT pago_pkey PRIMARY KEY (id_pago);
 8   ALTER TABLE ONLY public.pago DROP CONSTRAINT pago_pkey;
       public         postgres    false    215            �
           2606    16706     representante representante_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.representante
    ADD CONSTRAINT representante_pkey PRIMARY KEY (id_representante);
 J   ALTER TABLE ONLY public.representante DROP CONSTRAINT representante_pkey;
       public         postgres    false    218            �
           2606    16879    requisitos requisitos_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.requisitos
    ADD CONSTRAINT requisitos_pkey PRIMARY KEY (id_requisito);
 D   ALTER TABLE ONLY public.requisitos DROP CONSTRAINT requisitos_pkey;
       public         postgres    false    227            �
           2606    16708    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    221            �
           2606    16876    variables variables_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.variables
    ADD CONSTRAINT variables_pkey PRIMARY KEY (id_variable);
 B   ALTER TABLE ONLY public.variables DROP CONSTRAINT variables_pkey;
       public         postgres    false    229            �
           2606    16714 (   asistencia_a asistencia_A_id_alumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asistencia_a
    ADD CONSTRAINT "asistencia_A_id_alumno_fkey" FOREIGN KEY (id_alumno) REFERENCES public.alumno(id_alumno);
 T   ALTER TABLE ONLY public.asistencia_a DROP CONSTRAINT "asistencia_A_id_alumno_fkey";
       public       postgres    false    197    201    2786            �
           2606    16719 *   asistencia_a asistencia_A_id_empleado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asistencia_a
    ADD CONSTRAINT "asistencia_A_id_empleado_fkey" FOREIGN KEY (id_usuario) REFERENCES public.empleado(id_empleado);
 V   ALTER TABLE ONLY public.asistencia_a DROP CONSTRAINT "asistencia_A_id_empleado_fkey";
       public       postgres    false    205    2790    201                       2606    16807 *   asistencia_d asistencia_d_id_empleado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asistencia_d
    ADD CONSTRAINT asistencia_d_id_empleado_fkey FOREIGN KEY (id_empleado) REFERENCES public.empleado(id_empleado);
 T   ALTER TABLE ONLY public.asistencia_d DROP CONSTRAINT asistencia_d_id_empleado_fkey;
       public       postgres    false    225    205    2790                        2606    16802 )   asistencia_d asistencia_d_id_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asistencia_d
    ADD CONSTRAINT asistencia_d_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);
 S   ALTER TABLE ONLY public.asistencia_d DROP CONSTRAINT asistencia_d_id_usuario_fkey;
       public       postgres    false    221    2800    225            �
           2606    16724 "   matricula matricula_id_alumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_id_alumno_fkey FOREIGN KEY (id_alumno) REFERENCES public.alumno(id_alumno);
 L   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_id_alumno_fkey;
       public       postgres    false    2786    207    197            �
           2606    16729 $   matricula matricula_id_empleado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_id_empleado_fkey FOREIGN KEY (id_empleado) REFERENCES public.empleado(id_empleado);
 N   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_id_empleado_fkey;
       public       postgres    false    2790    205    207            �
           2606    16734    nota nota_id_alumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_id_alumno_fkey FOREIGN KEY (id_alumno) REFERENCES public.alumno(id_alumno);
 B   ALTER TABLE ONLY public.nota DROP CONSTRAINT nota_id_alumno_fkey;
       public       postgres    false    197    211    2786            �
           2606    16739    nota nota_id_empleado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_id_empleado_fkey FOREIGN KEY (id_empleado) REFERENCES public.empleado(id_empleado);
 D   ALTER TABLE ONLY public.nota DROP CONSTRAINT nota_id_empleado_fkey;
       public       postgres    false    211    205    2790            �
           2606    16744    pago pago_id_alumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pago
    ADD CONSTRAINT pago_id_alumno_fkey FOREIGN KEY (id_alumno) REFERENCES public.alumno(id_alumno);
 B   ALTER TABLE ONLY public.pago DROP CONSTRAINT pago_id_alumno_fkey;
       public       postgres    false    215    2786    197            �
           2606    16749 *   representante representante_id_alumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.representante
    ADD CONSTRAINT representante_id_alumno_fkey FOREIGN KEY (id_alumno) REFERENCES public.alumno(id_alumno);
 T   ALTER TABLE ONLY public.representante DROP CONSTRAINT representante_id_alumno_fkey;
       public       postgres    false    218    2786    197                       2606    16880 $   requisitos requisitos_id_alumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.requisitos
    ADD CONSTRAINT requisitos_id_alumno_fkey FOREIGN KEY (id_alumno) REFERENCES public.alumno(id_alumno);
 N   ALTER TABLE ONLY public.requisitos DROP CONSTRAINT requisitos_id_alumno_fkey;
       public       postgres    false    227    2786    197            �
           2606    16754     usuario usuario_id_empleado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_id_empleado_fkey FOREIGN KEY (id_empleado) REFERENCES public.empleado(id_empleado);
 J   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_id_empleado_fkey;
       public       postgres    false    2790    221    205            |      x������ � �      �      x������ � �      �      x������ � �      �   "   x�3�LL����B�a�p�rp��qqq b5%      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   &   x�3�4�LL��̃��F�F�f�&�F�%�%\1z\\\ ���      �   !   x�3�4����42��@#C] a����� L��     