--Создание таблиц
CREATE TABLE car_body(
	id serial primary key,
	model varchar(200)
);

CREATE TABLE gear_box(
	id serial primary key,
	model varchar(200)
);

CREATE TABLE engine(
	id serial primary key,
	model varchar(200)
);

CREATE TABLE car(
	id serial primary key,
	name varchar(200),
	car_body_id int references car_body(id),
	gear_box_id int references gear_box(id),
	engine_id int references engine(id)
);
-- Заполнение таблиц
insert into car_body(model) values('Sedan');
insert into car_body(model) values('Universal');
insert into car_body(model) values('Hatchback');
insert into car_body(model) values('Minivan');

insert into gear_box(model) values('Mechanics');
insert into gear_box(model) values('Hydraulics');
insert into gear_box(model) values('Automatics');

insert into engine(model) values('X6');
insert into engine(model) values('PR2');
insert into engine(model) values('ML9');
insert into engine(model) values('IS1');

insert into car values(default, 'Audio', 1, 1, 3);
insert into car values(default, 'Peugeot', 3, 1, 1);
insert into car values(default, 'Mazda', 4, 3, 2);
--Получение всех машин и их частей
select c.name as Машина, b.model as Кузов, g.model as Коробка_передач, e.model as Двигатель
 from car as c 
 left join car_body as b on c.car_body_id=b.id 
 left join gear_box as g on c.gear_box_id=g.id
 left join engine as e on c.engine_id=e.id;
--Получение кузовов которые не используются.
select b.model as Кузов
 from car_body as b
 left join car as c on b.id=c.car_body_id where c.id is null;
--Получение коробок передач которые не используются. 
select g.model as Коробка_передач 
 from gear_box as g	
 left join car as c on g.id=c.gear_box_id where c.id is null;
--Получение двигателей которые не используются. 
select e.model as Двигатель
 from engine as e
 left join car as c on e.id=c.engine_id where c.id is null;


