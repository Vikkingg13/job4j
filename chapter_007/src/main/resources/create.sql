create database system_items;
\c system_items
create table role (
	id serial primary key,
	title varchar(2000)
);
create table rules (
	id serial primary key,
	rule_type varchar(2000)
);
create table role_and_rules (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);
create table users (
	id serial primary key,
	name varchar(2000),
	role_rules_id int references role_and_rules(id)
);
create table category (
	id serial primary key,
	types varchar(2000)
);
create table status (
	id serial primary key,
	types varchar(2000)
);
create table info (
	id serial primary key,
	category_id int references category(id),
	status_id int references status(id)
);
create table items (
	id serial primary key,
	text varchar(2000),
	user_id int references users(id),
	info_id int references info(id)
);
create table comments (
	id serial primary key,
	comments_text varchar(2000),
	item_id int references items(id)
);
create table attachs (
	id serial primary key,
	path_to_file varchar(2000),
	item_id int references items(id)
);
insert into role (title) values('Administrator');
insert into rules (rule_type) values('Full');
insert into role_and_rules (role_id, rules_id) values(1, 1);
insert into users (name, role_rules_id) values('Viktor', 1);
insert into category (types) values('Important');
insert into status (types) values('Active');
insert into info (category_id, status_id) values(1, 1);
insert into items (text, user_id, info_id) values('Very important item', 1, 1);
insert into comments (comments_text, item_id) values('This comment!', 1);
insert into attachs (path_to_file, item_id) values('/tempdir/diagram.jpg', 1);



