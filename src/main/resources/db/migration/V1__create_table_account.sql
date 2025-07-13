create table account
(
    id         bigint auto_increment primary key,
    created_at datetime default current_timestamp not null,
    updated_at datetime default current_timestamp not null on update current_timestamp
);

