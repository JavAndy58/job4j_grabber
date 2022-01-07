create table post (

    id serial primary key,
    name text,
    text text,
    link text CONSTRAINT post_text UNIQUE,
    created timestamp
);