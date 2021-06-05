create table categories (id bigserial primary key, category varchar(255));
insert into categories (category) values
('Fruit'),
('Vegetable');

create table products (id bigserial primary key, category_id bigint references categories(id), title varchar(255), cost int);
insert into products (category_id, title, cost) values
(1, 'Apple', 100),
(2,'Potato',4),
(2,'Tomato',5),
(2,'Sweet Potato',6),
(2,'Cucumber',7),
(2,'Radish',8),
(2,'Pepper',9),
(2,'Pepper Bell',10),
(2,'Horse Radish',1),
(2,'Zucchini',2),
(2,'Pumpkin',3);

