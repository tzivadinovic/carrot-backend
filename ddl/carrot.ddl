set
foreign_key_checks = 0;

drop table if exists user;
create table user
(
    user_id            int auto_increment primary key,
    first_name         varchar(64) not null,
    last_name          varchar(64) not null,
    phone              varchar(10) null,
    birth_date         date null,
    email              varchar(32) not null unique,
    username           varchar(32) not null unique,
    password           varchar(64) not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null
);

drop table if exists role;
create table role
(
    role_id            int auto_increment primary key,
    name               varchar(32) not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null
);

drop table if exists user_role;
create table user_role
(
    user_role_id       int auto_increment primary key,
    user_fk            int not null,
    role_fk            int not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_user_user_role foreign key (user_fk) references user (user_id)
        on update cascade on delete cascade,
    constraint fk_role_user_role foreign key (role_fk) references role (role_id)
        on update cascade on delete cascade
);

drop table if exists category;
create table category
(
    category_id        int auto_increment primary key,
    name               varchar(64),
    sub_category_fk    int,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_category_sub_category foreign key (sub_category_fk) references sub_category (sub_category_id)
        on update cascade on delete restrict
);

drop table if exists sub_category;
create table sub_category
(
    sub_category_id    int auto_increment primary key,
    name               varchar(64) not null,
    category_fk        int         not null,
    sub_category_fk    int comment 'Sub category of sub category',
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_sub_category_category foreign key (category_fk) references category (category_id)
        on update cascade on delete restrict,
    constraint fk_sub_category_self foreign key (sub_category_fk) references sub_category (sub_category_id)
        on update cascade on delete restrict
);

drop table if exists product_brand;
create table product_brand
(
    product_brand_id   int auto_increment primary key,
    name               varchar(32) not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null
);

drop table if exists product_model;
create table product_model
(
    product_model_id   int auto_increment primary key,
    name               varchar(32) not null,
    product_brand_fk   int,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_model_brand foreign key (product_brand_fk) references product_brand (product_brand_id)
        on update cascade on delete restrict
);

drop table if exists product;
create table product
(
    product_id         int auto_increment primary key,
    name               varchar(128),
    product_brand_fk   int,
    product_model_fk   int,
    stock              int,
    price              float,
    discount_price     float,
    ean                varchar(32) comment 'Barcode',
    sub_category_fk    int,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_product_brand foreign key (product_brand_fk) references product_brand (product_brand_id)
        on update cascade on delete restrict,

    constraint fk_product_model foreign key (product_model_fk) references product_model (product_model_id)
        on update cascade on delete restrict
);

drop table if exists product_image;
create table product_image
(
    product_image_id   int auto_increment primary key,
    product_fk         int not null,
    uri                varchar(256),
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_product_image_product foreign key (product_fk) references product (product_id)
        on update cascade on delete restrict
);

drop table if exists `comment`;
create table `comment`
(
    comment_id         int auto_increment primary key,
    product_fk         int not null,
    user_fk            int not null,
    content            text,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_comment_product foreign key (product_fk) references product (product_id)
        on update cascade on delete restrict,
    constraint fk_comment_user foreign key (user_fk) references user (user_id)
        on update cascade on delete restrict
);

drop table if exists product_specification;
create table product_specification
(
    product_specification_id int auto_increment primary key,
    `key`                    varchar(32),
    `value`                  varchar(32),
    product_fk               int,
    last_modified_date       timestamp    default current_timestamp() null,
    last_modified_by         varchar(128) default 'system' null,
    created_date             timestamp    default current_timestamp() null,
    record_status            int          default 1 null,

    constraint fk_product_specification_product foreign key (product_fk) references product (product_id)
        on update cascade on delete restrict
);

drop table if exists `order`;
create table `order`
(
    order_id           int auto_increment primary key,
    user_fk            int not null,
    total_price        float,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_order_user foreign key (user_fk) references user (user_id)
        on update cascade on delete restrict
);

drop table if exists product_order;
create table product_order
(
    product_order_id   int auto_increment primary key,
    product_fk         int not null,
    order_fk           int not null,
    quantity           int          default 1,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint product_order_product foreign key (product_fk) references product (product_id)
        on update cascade on delete restrict,

    constraint product_order_order foreign key (order_fk) references `order` (order_id)
        on update cascade on delete restrict

);

drop table if exists country;
create table country
(
    country_id         int auto_increment primary key,
    name               varchar(32),
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null
);

drop table if exists municipality;
create table municipality
(
    municipality_id    int auto_increment primary key,
    name               varchar(32),
    country_fk         int,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_municipality_country foreign key (country_fk) references country (country_id)
        on update cascade on delete restrict
);

drop table if exists city;
create table city
(
    city_id            int auto_increment primary key,
    name               varchar(32),
    zip_code           varchar(16),
    municipality_fk    int,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_city_municipality foreign key (municipality_fk) references municipality (municipality_id)
        on update cascade on delete restrict
);

drop table if exists address;
create table address
(
    address_id         int auto_increment primary key,
    country_fk         int not null,
    municipality_fk    int not null,
    city_fk            int not null,
    user_fk            int not null,
    street             varchar(64),
    number             varchar(8),
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system' null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1 null,

    constraint fk_address_country foreign key (country_fk) references country (country_id)
        on update cascade on delete restrict,
    constraint fk_address_municipality foreign key (municipality_fk) references municipality (municipality_id)
        on update cascade on delete restrict,
    constraint fk_address_city foreign key (city_fk) references city (city_id)
        on update cascade on delete restrict,
    constraint fk_address_user foreign key (user_fk) references user (user_id)
        on update cascade on delete restrict
);

set
foreign_key_checks = 1;