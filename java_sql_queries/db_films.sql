drop database db_films;
create database db_films;
use db_films;

create table actors
(
id int primary key,
fio varchar(50),
age int,
start_career_date date
);

insert into actors values("1","ACTOR_1","22","20000304");
insert into actors values("2","ACTOR_2","34","20080202");
insert into actors values("3","ACTOR_3","14","20020220");
insert into actors values("4","ACTOR_4","32","20200405");
insert into actors values("5","ACTOR_5","87","20070203");

create table languages
(
id int primary key,
title varchar(20),
short_title varchar(3)
);

insert into languages values("1","english","eng");
insert into languages values("2","spanish","spa");
insert into languages values("3","russian","rus");
insert into languages values("4","belorussian","bel");
insert into languages values("5","chinese","chi");

create table dubbing
(
id int primary key,
title varchar(30),
id_language int,
dubbing_actors_list text,
foreign key (id_language) references languages(id) on delete cascade on update cascade
);

insert into dubbing values("1","DUBBING_1",3,"DUB_ACTOR_1, DUB_ACTOR_2, DUB_ACTOR_3");
insert into dubbing values("2","DUBBING_2",4,"DUB_ACTOR_4");
insert into dubbing values("3","DUBBING_3",2,"DUB_ACTOR_5, DUB_ACTOR_6");
insert into dubbing values("4","DUBBING_4",1,"DUB_ACTOR_7, DUB_ACTOR_8, DUB_ACTOR_9");
insert into dubbing values("5","DUBBING_5",3,"DUB_ACTOR_10, DUB_ACTOR_11");

create table films
(
id int primary key,
title varchar(30),
show_date date,
budget int,
dues int,
mark varchar(4)
);

insert into films values("1","FILM_1","20210202","2000","5000","-");
insert into films values("2","FILM_2","20050202","1000","8000","-");
insert into films values("3","FILM_3","20200321","100","1000","-");
insert into films values("4","FILM_4","20180908","4000","400","-");
insert into films values("5","FILM_5","20151111","700","3000","-");

create table actor_film
(
id int primary key,
id_film int,
id_actor int,
name_of_person varchar(30),
foreign key (id_film) references films(id) on delete cascade on update cascade,
foreign key (id_actor) references actors(id) on delete cascade on update cascade
);

insert into actor_film values("1","1","1","NAME_OF_PERSON_1");
insert into actor_film values("2","1","2","NAME_OF_PERSON_2");
insert into actor_film values("3","1","3","NAME_OF_PERSON_3");
insert into actor_film values("4","1","4","NAME_OF_PERSON_4");
insert into actor_film values("5","1","5","NAME_OF_PERSON_5");

insert into actor_film values("6","2","1","NAME_OF_PERSON_6");
insert into actor_film values("7","2","3","NAME_OF_PERSON_7");

insert into actor_film values("8","3","1","NAME_OF_PERSON_8");
insert into actor_film values("9","3","2","NAME_OF_PERSON_9");
insert into actor_film values("10","3","3","NAME_OF_PERSON_10");

insert into actor_film values("11","4","2","NAME_OF_PERSON_11");
insert into actor_film values("12","4","3","NAME_OF_PERSON_12");
insert into actor_film values("13","4","5","NAME_OF_PERSON_13");

insert into actor_film values("14","5","2","NAME_OF_PERSON_14");
insert into actor_film values("15","5","5","NAME_OF_PERSON_15");

create table voice_acting
(
id int primary key,
id_dubbing int,
id_film int,
foreign key (id_film) references films(id) on delete cascade on update cascade,
foreign key (id_dubbing) references dubbing(id) on delete cascade on update cascade
);

insert into voice_acting values("1","1","5");
insert into voice_acting values("2","2","4");
insert into voice_acting values("3","3","3");
insert into voice_acting values("4","4","2");
insert into voice_acting values("5","5","1");

create table comments
(
id int primary key,
commentator varchar(30),
id_film int,
comment_text text,
mark int,
foreign key (id_film) references films(id) on delete cascade on update cascade
);

insert into comments values("1","COMMENTATOR_1","3","COMMENT_1",2);
insert into comments values("2","COMMENTATOR_2","2","COMMENT_2",4);
insert into comments values("3","COMMENTATOR_3","4","COMMENT_3",5);
insert into comments values("4","COMMENTATOR_3","5","COMMENT_4",2);
insert into comments values("5","COMMENTATOR_2","3","COMMENT_5",2);
insert into comments values("6","COMMENTATOR_3","3","COMMENT_6",4);
insert into comments values("7","COMMENTATOR_4","2","COMMENT_7",5);
insert into comments values("8","COMMENTATOR_5","2","COMMENT_8",5);

SELECT * FROM actors;
SELECT * FROM languages;
SELECT * FROM dubbing;
SELECT * FROM films;
SELECT * FROM actor_film;
SELECT * FROM voice_acting;
SELECT * FROM comments;

# 5 запросов с тремя таблицами и встроенными процедурами типо каунт мин макс 

#select count(voice_acting.id_film) "Количество фильмов, которые озвучил белорусский дубляж" from  voice_acting  join dubbing on dubbing.id = voice_acting.id_dubbing join languages on dubbing.id_language = languages.id where languages.title = "belorussian";
#select films.title "Фильм(ы), в котором(ых) снималось максимальное из всех фильмов количество совершеннолетних актеров" from films join actor_film on films.id = actor_film.id_film join actors on actor_film.id_actor = actors.id where actors.age>=18 group by  films.id  having count(actor_film.id_film) = (select max(count(actor_film.id)) from actor_film where actors.age>=18 group by actor_film.id_film);
