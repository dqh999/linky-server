CREATE
DATABASE linky_db;
use
linky_db;
CREATE TABLE tbl_user_accounts
(
    id               varchar(36) primary key,
    role             varchar(36) not null,
    user_name        varchar(36) not null,
    phone_number     varchar(20),
    email            varchar(255),
    password         varchar(255),
    oauth_provider   varchar(50),
    oauth_account_id varchar(255),
    is_active        boolean,
    created_at       timestamp,
    updated_at       timestamp
);
CREATE TABLE tbl_user_tokens
(
    id                 varchar(36) primary key,
    account_id         varchar(36) not null,
    value              varchar(255),
    issued_at          datetime,
    expires_at         datetime,
    refresh_token      varchar(255),
    refresh_expires_at datetime,
    device_info        varchar(255),
    ip_address         varchar(45),
    created_at         timestamp,
    updated_at         timestamp
);
CREATE TABLE tbl_chat_conversations
(
    id         varchar(36) primary key,
    type       varchar(36) not null,
    name       varchar(255),
    creator_id varchar(36),
    created_at timestamp,
    updated_at timestamp
);
CREATE TABLE tbl_chat_conversation_participants
(
    id              varchar(36) primary key,
    conversation_id varchar(36),
    account_id      varchar(36),
    role            varchar(36),
    created_at      timestamp,
    updated_at      timestamp
);
CREATE TABLE tbl_chat_messages
(
    id              varchar(36) primary key,
    conversation_id varchar(36),
    participant_id  varchar(36),
    content         varchar(1000),
    status          varchar(36),
    created_at      timestamp,
    updated_at      timestamp
);
