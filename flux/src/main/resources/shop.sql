drop database if not exists b2b2c;
create database b2b2c;

create table depots
(
    id          int unsigned auto_increment primary key,
    title       varchar(255)      not null,
    country     varchar(255)      not null,
    province    varchar(255)      not null,
    city        varchar(255)      not null,
    area        varchar(255)      not null,
    category    tinyint not default 0 comment '0 综合 1 生鲜 2 食品 3 电器',
    address     varchar(255)      not null,
    description varchar(255)      null,
    zip_code    char(6)           not null,
    used_at     timestamp          null,
    state       tinyint default 0 null comment '0 正常 1 关闭',
    updated_at  timestamp          null
);

create table products
(
    id          bigint unsigned auto_increment primary key,
    title       varchar(255)             not null,
    description text                     null,
    image       varchar(64)              null,
    on_sale     tinyint      default 0   null comment '0 在售 1 下架',
    sold_count  int unsigned default '0' null comment '销量',
    category    tinyint not null,
    price       decimal(10, 2)           null,
    created_at  timestamp                 null,
    updated_at  timestamp                 null,
    column_10   int                      null
);

create table products_skus
(
    id          bigint unsigned auto_increment primary key,
    title       varchar(255)    not null,
    description text            null,
    stock       int unsigned    not null,
    price       decimal(10, 2)  null,
    store_id    int unsigned    null,
    product_id  bigint unsigned null,
    depot_id    int unsigned    null comment '仓库 id',
    created_at  timestamp        null,
    updated_at  timestamp        null,
    constraint sku_map_id foreign key (product_id) references products (id)
);

create table store
(
    id           int unsigned auto_increment primary key,
    name         varchar(255)      not null,
    company_name varchar(255)      not null,
    is_self      tinyint default 0 null comment '0 自营 1 非自营',
    address      varchar(255)      null,
    state        tinyint default 0 null comment '0 正常 1 异常'
);

create table users
(
    id         bigint unsigned auto_increment primary key,
    name       varchar(64)       not null,
    password   char(64)          not null,
    gender     tinyint default 0 null comment '0 未知 1 男 2 女',
    birthday   date              not null,
    phone      char(11)          not null,
    state      tinyint default 0 null comment '0 正常 1 异常 2 封禁',
    email      varchar(64)       null,
    created_at timestamp          null,
    updated_at timestamp          null
);

create table user_favorites
(
    id bigint unsigned primary key auto_increment,
    user_id        bigint unsigned not null,
    product_sku_id bigint unsigned not null,
    created_at     timestamp        null,
    is_deleted     timestamp        null,
    constraint user_map_favorites foreign key (user_id) references user (id)
);

create table user_addresses
(
    id bigint primary key auto_increment,
    user_id bigint unsigned,
    country varchar(255) default '中国',
    province varchar(255) not null,
    city varchar(255) not null,
    area varchar(255) not null,
    address varchar(255) not null,
    alias varchar(64),
    created_at timestamp,
    updated_at timestamp,
    CONSTRAINT user_map_address FOREIGN KEY (user_id) REFERENCES user (id)
)

create table admins(
    id int unsigned primary key auto_increment,
    name varchar(64) not null,
    level tinyint default 0 not null,
    office not null,
    company_id int unsigned not null,
    parent_id int unsigned not null,
    role_id int unsigned not null,
    created_at timestamp,
    updated_at timestamp
)