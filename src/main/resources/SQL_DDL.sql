DROP TABLE IF EXISTS public.Person CASCADE;
DROP TABLE IF EXISTS public.Item CASCADE;

--one_to_many
CREATE TABLE Person
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL,
    age  INT CHECK ( age >= 0 )
);
--one_to_many
CREATE TABLE Item
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    description VARCHAR NOT NULL,
    person_id   BIGINT  REFERENCES Person (id) ON DELETE SET NULL
);