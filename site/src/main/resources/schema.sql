create table if not exists `user` (
    `id` bigint(20) not null auto_increment,
    `username` varchar(255) not null,
    `password` varchar(255) not null,
    `enabled` boolean not null default true,
    `role_id` bigint(20) not null,
    `updated_at` bigint(20) not null,
    `created_at` bigint(20) not null,
    primary key (`id`),
    unique (`username`)
) default charset=utf8;

create table if not exists `role` (
    `id` bigint(20) not null,
    `name` varchar(255) not null,
    primary key (`id`),
    unique (`name`)
) default charset=utf8;
