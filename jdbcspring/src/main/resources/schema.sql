create table item (
    id SERIAL primary key,
    name varchar(50) null default null,
    category varchar(50) null default null
);

create index idItem on item (id);