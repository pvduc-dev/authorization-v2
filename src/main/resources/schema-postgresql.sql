create table public.oauth2_authorization
(
    id                            varchar(100) not null
        primary key,
    registered_client_id          varchar(100) not null,
    principal_name                varchar(200) not null,
    authorization_grant_type      varchar(100) not null,
    authorized_scopes             varchar(1000) default NULL:: character varying,
    attributes                    text,
    state                         varchar(500)  default NULL:: character varying,
    authorization_code_value      text,
    authorization_code_issued_at  timestamp,
    authorization_code_expires_at timestamp,
    authorization_code_metadata   text,
    access_token_value            text,
    access_token_issued_at        timestamp,
    access_token_expires_at       timestamp,
    access_token_metadata         text,
    access_token_type             varchar(100)  default NULL:: character varying,
    access_token_scopes           varchar(1000) default NULL:: character varying,
    oidc_id_token_value           text,
    oidc_id_token_issued_at       timestamp,
    oidc_id_token_expires_at      timestamp,
    oidc_id_token_metadata        text,
    refresh_token_value           text,
    refresh_token_issued_at       timestamp,
    refresh_token_expires_at      timestamp,
    refresh_token_metadata        text
);

create table public.oauth2_authorization_consent
(
    registered_client_id varchar(100)  not null,
    principal_name       varchar(200)  not null,
    authorities          varchar(1000) not null,
    primary key (registered_client_id, principal_name)
);

create table public.oauth2_registered_client
(
    id                            varchar(100)                            not null
        primary key,
    client_id                     varchar(100)                            not null,
    client_id_issued_at           timestamp     default CURRENT_TIMESTAMP not null,
    client_secret                 varchar(200)  default NULL:: character varying,
    client_secret_expires_at      timestamp,
    client_name                   varchar(200)                            not null,
    client_authentication_methods varchar(1000)                           not null,
    authorization_grant_types     varchar(1000)                           not null,
    redirect_uris                 varchar(1000) default NULL:: character varying,
    scopes                        varchar(1000)                           not null,
    client_settings               varchar(2000)                           not null,
    token_settings                varchar(2000)                           not null
);

create table public.oauth2_authorized_client
(
    client_registration_id  varchar(100)                            not null,
    principal_name          varchar(200)                            not null,
    access_token_type       varchar(100)                            not null,
    access_token_value      bytea                                   not null,
    access_token_issued_at  timestamp                               not null,
    access_token_expires_at timestamp                               not null,
    access_token_scopes     varchar(1000) default NULL:: character varying,
    refresh_token_value     bytea,
    refresh_token_issued_at timestamp,
    created_at              timestamp     default CURRENT_TIMESTAMP not null,
    primary key (client_registration_id, principal_name)
);

alter table public.oauth2_authorized_client
    owner to postgres;

create table public.oauth2_user
(
    id         uuid                                not null
        primary key,
    email      varchar(150)                        not null,
    first_name varchar(100)                        not null,
    last_name  varchar(100)                        not null,
    password   varchar(100)                        not null,
    is_active  boolean   default false             not null,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    created_by uuid                                not null,
    updated_at timestamp                           not null,
    updated_by uuid                                not null
);
