-- 기본 테이블
create table person
(
    id         bigint primary key,
    surname    varchar(100) not null,
    given_name varchar(100) not null,
    gender     varchar(10)  not null,
    birthday   timestamp    null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table person_extra_info
(
    id         bigint primary key,
    person_id  bigint      not null,
    height     integer     null,
    blood_type varchar(10) null,
    mbti       varchar(10) null,
    created_at timestamp   not null,
    updated_at timestamp   not null
);

create table country
(
    id          bigint primary key,
    name        varchar(100) not null,
    iso_alpha_2 CHAR(2)      NOT NULL,
    iso_alpha_3 CHAR(3)      NOT NULL,
    created_at  timestamp    not null,
    updated_at  timestamp    not null
);

create table person_nationality
(
    id         bigint primary key,
    person_id  bigint       not null,
    country_id bigint       not null,
    name       varchar(200) not null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table member
(
    id             bigint primary key,
    stage_name     varchar(100) not null,
    person_id      bigint       not null,
    artist_id      bigint       not null,
    start_datetime timestamp    null,
    end_datetime   timestamp    null,
    created_at     timestamp    not null,
    updated_at     timestamp    not null
);

create table artist
(
    id         bigint primary key,
    name       varchar(100) not null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table artist_nationality
(
    id             bigint primary key,
    artist_id      bigint    not null,
    country_id     bigint    not null,
    start_datetime timestamp null,
    end_datetime   timestamp null,
    created_at     timestamp not null,
    updated_at     timestamp not null
);

create table record
(
    id               bigint primary key,
    artist_id        bigint       not null,
    country_id       bigint       null,
    name             varchar(100) not null,
    release_datetime timestamp    null,
    created_at       timestamp    not null,
    updated_at       timestamp    not null
);

create table record_song
(
    id          bigint primary key,
    record_id   bigint        not null,
    song_id     bigint        not null,
    track       integer       null,
    description varchar(2000) null,
    created_at  timestamp     not null,
    updated_at  timestamp     not null
);

create table song
(
    id               bigint primary key,
    name             varchar(100) not null,
    release_datetime timestamp    null,
    duration         integer      null,
    created_at       timestamp    not null,
    updated_at       timestamp    not null
);