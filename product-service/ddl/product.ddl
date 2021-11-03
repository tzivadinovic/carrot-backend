set foreign_key_checks = 0;

drop table if exists category;
create table category
(
    category_id        int auto_increment primary key,
    name               varchar(64),
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

drop table if exists sub_category;
create table sub_category
(
    sub_category_id    int auto_increment primary key,
    name               varchar(64)                              not null,
    category_fk        int                                      not null,
    sub_category_fk    int comment 'Sub category of sub category',
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint fk_sub_category_category foreign key (category_fk) references category (category_id)
        on update cascade on delete restrict,
    constraint fk_sub_category_self foreign key (sub_category_fk) references sub_category (sub_category_id)
        on update cascade on delete restrict
);

drop table if exists product_brand;
create table product_brand
(
    product_brand_id   int auto_increment primary key,
    name               varchar(32)                              not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

drop table if exists product_model;
create table product_model
(
    product_model_id   int auto_increment primary key,
    name               varchar(32)                              not null,
    product_brand_fk   int,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

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
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint fk_product_brand foreign key (product_brand_fk) references product_brand (product_brand_id)
        on update cascade on delete restrict,

    constraint fk_product_model foreign key (product_model_fk) references product_model (product_model_id)
        on update cascade on delete restrict,

    constraint fk_product_sub_category foreign key (sub_category_fk) references sub_category (sub_category_id)
        on update cascade on delete restrict
);

drop table if exists product_image;
create table product_image
(
    product_image_id   int auto_increment primary key,
    product_fk         int                                      not null,
    uri                varchar(256),
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint fk_product_image_product foreign key (product_fk) references product (product_id)
        on update cascade on delete restrict
);

drop table if exists `comment`;
create table `comment`
(
    comment_id         int auto_increment primary key,
    product_fk         int                                      not null,
    user_fk            int                                      not null,
    content            text,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

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
    last_modified_by         varchar(128) default 'system'            null,
    created_date             timestamp    default current_timestamp() null,
    record_status            int          default 1                   null,

    constraint fk_product_specification_product foreign key (product_fk) references product (product_id)
        on update cascade on delete restrict
);

drop table if exists product_order;
create table product_order
(
    product_order_id   int auto_increment primary key,
    product_fk         int                                      not null,
    order_fk           int                                      not null,
    quantity           int          default 1,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint product_order_product foreign key (product_fk) references product (product_id)
        on update cascade on delete restrict,

    constraint product_order_order foreign key (order_fk) references `order` (order_id)
        on update cascade on delete restrict

);

set foreign_key_checks = 1;