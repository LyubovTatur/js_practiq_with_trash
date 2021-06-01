create database test1;
use test1;
create table employee
(
id int primary key,
job varchar(30)
);

create table place
(
id int primary key,
namee varchar(30)
);

create table entity_empl_pl
(
id int primary key,
id_emp int,
id_place int,
foreign key (id_emp) references employee(id) on delete cascade on update cascade,
foreign key (id_place) references place(id) on delete cascade on update cascade
);