delete from food;
delete from restaurants;
delete from users;
delete from user_roles;

ALTER TABLE food
  AUTO_INCREMENT = 1;
ALTER TABLE restaurants
  AUTO_INCREMENT = 1;
ALTER TABLE users
  AUTO_INCREMENT = 1;

insert into restaurants (name) values ('test_restaurant_1');
insert into restaurants (name) values ('test_restaurant_2');

insert into food (description, restaurant_id) values ('food_1', 1);
insert into food (description, restaurant_id) values ('food_2', 1);
insert into food (description, restaurant_id) values ('food_3', 1);
insert into food (description, restaurant_id) values ('food_4', 2);
insert into food (description, restaurant_id) values ('food_5', 2);
insert into food (description, restaurant_id) values ('food_6', 2);

insert into users (name, email, password) values ('Admin', 'admin@gmail.com', '{noop}password');
insert into users (name, email, password) values ('User', 'user@gmail.com', '{noop}password');

insert into user_roles (user_id, role) values ('1', 'ROLE_ADMIN');
insert into user_roles (user_id, role) values ('1', 'ROLE_USER');
insert into user_roles (user_id, role) values ('2', 'ROLE_USER');
