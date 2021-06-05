create table categories (id bigserial primary key, category_name varchar(255));
insert into categories (category_name) values
('Fruit'),
('Vegetable'),
('Berry');

create table products (id bigserial primary key, title varchar(255), cost int, category_id bigint references categories(id));
insert into products (title, cost, category_id) values
('Apple', 100, 1),
('Potato',4, 2),
('Tomato',5, 2),
('Sweet Potato',6, 2),
('Cucumber',7, 2),
('Radish',8, 2),
('Pepper',9, 2),
('Pepper Bell',10, 2),
('Horse Radish',1, 2),
('Zucchini',2, 2),
('Pumpkin',3, 2);

