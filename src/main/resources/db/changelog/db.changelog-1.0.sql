--liquibase formatted sql
--changeset pep_sxx:1
DROP TABLE IF EXISTS public.Person CASCADE;

--changeset pep_sxx:2
DROP TABLE IF EXISTS public.Item CASCADE;

--changeset pep_sxx:3
--one_to_many
CREATE TABLE Person
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL,
    age  INT CHECK ( age >= 0 )
);
--one_to_many

--changeset pep_sxx:4
CREATE TABLE Item
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    description VARCHAR NOT NULL,
    person_id   BIGINT  REFERENCES Person (id) ON DELETE SET NULL
);