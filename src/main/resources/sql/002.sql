-- 확장 정보 테이블

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