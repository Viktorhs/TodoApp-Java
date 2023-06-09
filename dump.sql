PGDMP     $                    {            TodoApp %   12.14 (Ubuntu 12.14-0ubuntu0.20.04.1) %   12.14 (Ubuntu 12.14-0ubuntu0.20.04.1)     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    48591    TodoApp    DATABASE     {   CREATE DATABASE "TodoApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';
    DROP DATABASE "TodoApp";
                postgres    false            �            1259    48594    projects    TABLE     x  CREATE TABLE public.projects (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(250),
    created_at timestamp without time zone DEFAULT '2023-03-12 09:15:15.53737'::timestamp without time zone NOT NULL,
    updated_at timestamp without time zone DEFAULT '2023-03-12 09:15:15.53737'::timestamp without time zone NOT NULL
);
    DROP TABLE public.projects;
       public         heap    postgres    false            �            1259    48592    projects_id_seq    SEQUENCE     �   CREATE SEQUENCE public.projects_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.projects_id_seq;
       public          postgres    false    203            �           0    0    projects_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.projects_id_seq OWNED BY public.projects.id;
          public          postgres    false    202            �            1259    48604    tasks    TABLE       CREATE TABLE public.tasks (
    id integer NOT NULL,
    id_project integer NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(250),
    completed boolean DEFAULT true NOT NULL,
    notes character varying(255),
    deadline date NOT NULL,
    created_at timestamp without time zone DEFAULT '2023-03-12 09:22:07.148202'::timestamp without time zone NOT NULL,
    updated_at timestamp without time zone DEFAULT '2023-03-12 09:22:07.148202'::timestamp without time zone NOT NULL
);
    DROP TABLE public.tasks;
       public         heap    postgres    false            �            1259    48602    tasks_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.tasks_id_seq;
       public          postgres    false    205            �           0    0    tasks_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;
          public          postgres    false    204                       2604    48597    projects id    DEFAULT     j   ALTER TABLE ONLY public.projects ALTER COLUMN id SET DEFAULT nextval('public.projects_id_seq'::regclass);
 :   ALTER TABLE public.projects ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203                       2604    48607    tasks id    DEFAULT     d   ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);
 7   ALTER TABLE public.tasks ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            �          0    48594    projects 
   TABLE DATA           Q   COPY public.projects (id, name, description, created_at, updated_at) FROM stdin;
    public          postgres    false    203          �          0    48604    tasks 
   TABLE DATA           v   COPY public.tasks (id, id_project, name, description, completed, notes, deadline, created_at, updated_at) FROM stdin;
    public          postgres    false    205   2       �           0    0    projects_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.projects_id_seq', 7, true);
          public          postgres    false    202            �           0    0    tasks_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.tasks_id_seq', 8, true);
          public          postgres    false    204            !           2606    48601    projects projects_id_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_id_key UNIQUE (id);
 B   ALTER TABLE ONLY public.projects DROP CONSTRAINT projects_id_key;
       public            postgres    false    203            #           2606    48614    tasks tasks_id_key 
   CONSTRAINT     K   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_id_key UNIQUE (id);
 <   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_id_key;
       public            postgres    false    205            $           2606    48615    tasks tasks_idProject_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT "tasks_idProject_fkey" FOREIGN KEY (id_project) REFERENCES public.projects(id);
 F   ALTER TABLE ONLY public.tasks DROP CONSTRAINT "tasks_idProject_fkey";
       public          postgres    false    205    203    2849            �      x������ � �      �      x������ � �     