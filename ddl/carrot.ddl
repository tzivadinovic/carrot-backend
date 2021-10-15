create table user
(
    user_id            int auto_increment primary key,
    first_name         varchar(64)                              not null,
    last_name          varchar(64)                              not null,
    phone              varchar(10)                              null,
    birth_date         date                                     null,
    email              varchar(32)                              not null unique,
    username           varchar(32)                              not null unique,
    password           varchar(64)                              not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);