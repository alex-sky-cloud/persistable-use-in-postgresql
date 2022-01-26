CREATE TABLE examples(
                         id  BIGSERIAL
                             CONSTRAINT id_pk
                                 PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         about VARCHAR(255) NULL
);



create unique index example_id_uindex
    on "examples" (id);