create table if not exists `country`
(
    id        binary(16)    unique not null default (UUID_TO_BIN(UUID(), true)),
    name      varchar(255)  unique not null,
    country_code varchar(50) not null,
    primary key (id)
    );