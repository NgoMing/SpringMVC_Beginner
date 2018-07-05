create table Customer (
  id identity,
  username varchar(30) not null,
  password varchar(30) not null,
  full_name varchar(100) not null,
  email varchar(30) not null
);