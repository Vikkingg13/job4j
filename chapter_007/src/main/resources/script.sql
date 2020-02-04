--Создание таблицы types
create table types(
	id serial primary key,
	name varchar(2000)
);
--Создание таблицы product
create table product(
	id serial primary key,
	name varchar(2000),
	type_id int references types(id),
	expired_date date,
	price money
);
--Заполнение таблиц
insert into types (name) values ('колбаса');
insert into types (name) values ('сыр');
insert into types (name) values ('молоко');
insert into types (name) values ('мороженное');
insert into product values (default, 'Пошехонский сыр', 2, '2020-01-20', 4.50);
insert into product values (default, 'Тофу', 2, '2020-03-13', 7.00);
insert into product values (default, 'Российский сыр', 2, '2019-12-29', 5.70);
insert into product values (default, 'Мацарелла', 2, '2019-12-23', 5.00);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Фруктовое мороженное', 4, '2020-01-09', 1.20);
insert into product values (default, 'Ванильное мороженное', 4, '2019-11-30', 1.00);
insert into product values (default, 'Новогрудское молоко', 3, '2020-04-13', 1.50);
insert into product values (default, 'Брестское молоко', 3, '2020-04-17', 1.45);
insert into product values (default, 'Мацарелла', 2, '2019-12-23', 5.00);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Фруктовое мороженное', 4, '2020-01-09', 1.20);
insert into product values (default, 'Ванильное мороженное', 4, '2019-11-30', 1.00);
insert into product values (default, 'Новогрудское молоко', 3, '2020-04-13', 1.50);
insert into product values (default, 'Ванильное мороженное', 4, '2019-11-30', 1.00);
insert into product values (default, 'Новогрудское молоко', 3, '2020-04-13', 1.50);
insert into product values (default, 'Ванильное мороженное', 4, '2019-11-30', 1.00);
insert into product values (default, 'Новогрудское молоко', 3, '2020-04-13', 1.50);
insert into product values (default, 'Ванильное мороженное', 4, '2019-11-30', 1.00);
insert into product values (default, 'Новогрудское молоко', 3, '2020-04-13', 1.50);
insert into product values (default, 'Ванильное мороженное', 4, '2019-11-30', 1.00);
insert into product values (default, 'Новогрудское молоко', 3, '2020-04-13', 1.50);
insert into product values (default, 'Тофу', 2, '2020-03-13', 7.00);
insert into product values (default, 'Мацарелла', 2, '2019-12-23', 5.00);
insert into product values (default, 'Советский пломбир', 4, '2020-01-10', 1.20);
insert into product values (default, 'Фруктовое мороженное', 4, '2020-01-09', 1.20);
insert into product values (default, 'Ванильное мороженное', 4, '2019-11-30', 1.00);
insert into product values (default, 'Новогрудское молоко', 3, '2020-04-13', 1.50);
insert into product values (default, 'Тофу', 2, '2020-03-13', 7.00);
insert into product values (default, 'Тофу', 2, '2020-01-08', 7.00);
insert into product values (default, 'Тофу', 2, '2020-01-08', 7.00);
insert into product values (default, 'Тофу', 2, '2020-01-08', 7.00);
insert into product values (default, 'Советский пломбир', 4, '2020-02-10', 1.20);
insert into product values (default, 'Фруктовое мороженное', 4, '2020-02-09', 1.20);
insert into product values (default, 'Новогрудское молоко', 3, '2020-02-13', 1.50);
insert into product values (default, 'Тофу', 2, '2020-02-13', 7.00);
--Написать запрос получение всех продуктов с типом "СЫР"
select * from product where type_id = 2;
-- Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product where name like '%мороженное%';
--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product where expired_date between date_trunc('month', now() + interval '1 month') and date_trunc('month', now() + interval '2 month');
--Написать запрос, который выводит самый дорогой продукт.
select MAX(price) from product;
--Написать запрос, который выводит количество всех продуктов определенного типа(молоко).
select count(*) from product where type_id=3;
--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product where type_id=2 or type_id=3;
--Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select name from types where id=(select type_id from product group by type_id having count(*)<10);
--Вывести все продукты и их тип.
select p.name as Продукт, t.name as Тип from product as p inner join types as t ON t.id = p.type_id;

