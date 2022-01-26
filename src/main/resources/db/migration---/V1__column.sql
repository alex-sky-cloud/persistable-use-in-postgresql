create table mesh
(
    id        bigserial not null
        constraint mesh_pkey
            primary key,
    cell_size integer,
    name      varchar(255)
);

alter table mesh
    owner to postgres;

create table mesh_column
(
    id      bigserial not null
        constraint mesh_column_pkey
            primary key,
    number  integer   not null,
    mesh_id bigint
        constraint fknreqntq3xjnseltqhad2t5g64
            references mesh
);

alter table mesh_column
    owner to postgres;

create table mesh_line
(
    id      bigserial not null
        constraint mesh_line_pkey
            primary key,
    number  integer   not null,
    mesh_id bigint
        constraint fk4oumbggw6yji5wq05yy63ouie
            references mesh
);

alter table mesh_line
    owner to postgres;

create table mesh_cell
(
    mesh_column_id bigint not null
        constraint mesh_cell_mesh_column_id_fkey
            references mesh_column,
    mesh_line_id   bigint not null
        constraint mesh_cell_mesh_line_id_fkey
            references mesh_line,
    value          text   not null,
    constraint mesh_cell_pkey
        primary key (mesh_column_id, mesh_line_id)
);

alter table mesh_cell
    owner to postgres;