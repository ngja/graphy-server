create table person
(
    id         serial primary key,
    surname    varchar(100) not null,
    given_name varchar(100) not null,
    gender     varchar(10)  not null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table person_extra_info
(
    id         serial primary key,
    person_id  integer     not null,
    height     integer     null,
    blood_type char(1)     null,
    mbti       varchar(10) null,
    created_at timestamp   not null,
    updated_at timestamp   not null
);

create table country
(
    id          serial primary key,
    name        varchar(100) not null,
    iso_alpha_2 CHAR(2)      NOT NULL,
    iso_alpha_3 CHAR(3)      NOT NULL,
    created_at  timestamp    not null,
    updated_at  timestamp    not null
);

create table person_nationality
(
    id         serial primary key,
    person_id  integer      not null,
    country_id integer      not null,
    name       varchar(200) not null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table member
(
    id         serial primary key,
    stage_name varchar(100) not null,
    artist_id  integer      not null,
    start_date timestamp    null,
    end_date   timestamp    null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table member_position
(
    id          serial primary key,
    member_id   integer   not null,
    position_id integer   not null,
    created_at  timestamp not null,
    updated_at  timestamp not null
);

create table position
(
    id         serial primary key,
    name       varchar(100) not null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table artist
(
    id         serial primary key,
    name       varchar(100) not null,
    created_at timestamp    not null,
    updated_at timestamp    not null
);

create table artist_nationality
(
    id         serial primary key,
    artist_id  integer   not null,
    country_id integer   not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table record
(
    id         serial primary key,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table song
(
    id         serial primary key,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table song_featuring
(
    id         serial primary key,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table song_composer
(
    id         serial primary key,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table song_lyricist
(
    id         serial primary key,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table song_arranger
(
    id         serial primary key,
    created_at timestamp not null,
    updated_at timestamp not null
);