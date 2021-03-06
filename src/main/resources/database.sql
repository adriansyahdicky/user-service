CREATE DATABASE authentication
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

INSERT INTO public."role"
(id, "name", created_on, modified_on)
VALUES(1, 'PROJECT_MANAGER', '2021-09-19 04:06:59.573', '2021-09-19 04:06:59.573');
INSERT INTO public."role"
(id, "name", created_on, modified_on)
VALUES(2, 'KONSULTAN', '2021-09-19 04:07:16.964', '2021-09-19 04:07:16.964');
INSERT INTO public."role"
(id, "name", created_on, modified_on)
VALUES(3, 'DEVELOPMENT', '2021-09-19 04:07:29.107', '2021-09-19 04:07:29.107');


INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(1, '2021-09-19 04:09:32.146', '2021-09-19 04:09:32.146', 'Create project order', 1);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(2, '2021-09-19 04:09:32.146', '2021-09-19 04:09:32.146', 'Close project order', 1);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(3, '2021-09-19 04:09:32.146', '2021-09-19 04:09:32.146', 'Delete project order', 1);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(4, '2021-09-19 04:11:53.885', '2021-09-19 04:11:53.885', 'Read project order', 2);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(5, '2021-09-19 04:11:53.885', '2021-09-19 04:11:53.885', 'Create sub task project', 2);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(6, '2021-09-19 04:11:53.885', '2021-09-19 04:11:53.885', 'Update sub task project', 2);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(7, '2021-09-19 04:11:53.885', '2021-09-19 04:11:53.885', 'Delete sub task project', 2);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(8, '2021-09-19 04:11:53.885', '2021-09-19 04:11:53.885', 'View project order', 3);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(9, '2021-09-19 04:11:53.885', '2021-09-19 04:11:53.885', 'View sub task project', 3);
INSERT INTO public.authentication_acl
(id, created_on, modified_on, "name", role_id)
VALUES(10, '2021-09-19 04:11:53.885', '2021-09-19 04:11:53.885', 'Update sub task project', 3);
