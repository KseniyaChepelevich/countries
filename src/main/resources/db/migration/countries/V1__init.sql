create table if not exists `country`
(
    id        binary(16)    unique not null default (UUID_TO_BIN(UUID(), true)),
    country_name      varchar(255)  unique not null,
    iso_code char(2) unique not null,
    primary key (id)
    );