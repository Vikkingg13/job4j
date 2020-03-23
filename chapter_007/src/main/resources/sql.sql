CREATE TYPE status_request AS ENUM ('accepted', 'rejected');
CREATE TABLE person(id integer primary key NOT NULL, name varchar(20));
CREATE TABLE meeting(id integer primary key NOT NULL, title varchar(20));
CREATE TABLE request(
id integer primary key NOT NULL,
person_id integer references person(id),
meeting_id integer references meeting(id),
status status_request
);

INSERT INTO person VALUES
(1, 'Sam'),
(2, 'Tom'),
(3, 'Hanna'),
(4, 'Sara');

INSERT INTO meeting VALUES
(1, 'Iatina Dance'),
(2, 'Boxing Show'),
(3, 'Book lovers club');
(4, 'Concert Leningrad');

INSERT INTO request VALUES
(1, 1, 1, 'accepted'),
(2, 2, 1, 'rejected'),
(3, 3, 1, 'accepted'),
(4, 4, 1, 'accepted'),
(5, 1, 2, 'accepted'),
(6, 2, 2, 'accepted'),
(7, 3, 2, 'rejected');
(8, 1, 4, 'rejected');
(8, 2, 4, 'rejected');

select p.name, m.title, status, (select count(*) from request where status='accepted') as accepted
from request as r 
left join person as p on r.person_id=p.id 
left join meeting as m on r.meeting_id=m.id;

select title from meeting where id not in(select meeting_id from request where status='accepted');
