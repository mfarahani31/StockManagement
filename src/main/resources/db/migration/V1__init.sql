create sequence hibernate_sequence start with 1 increment by 1;
create table products
(
    id          bigint    not null,
    created_at  timestamp not null,
    updated_at  timestamp not null,
    color       varchar(255),
    description varchar(255),
    name        varchar(255),
    stock       bigint,
    primary key (id)
);
