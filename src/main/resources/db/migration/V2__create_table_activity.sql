CREATE TABLE activity
(
    id                bigint auto_increment primary key,
    timestamp         datetime NOT NULL,
    owner_account_id  BIGINT   NOT NULL,
    source_account_id BIGINT   NOT NULL,
    target_account_id BIGINT   NOT NULL,
    amount            DECIMAL  NOT NULL,
    created_at datetime default current_timestamp not null,
    updated_at datetime default current_timestamp not null on update current_timestamp
);