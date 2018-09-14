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

insert into restaurants (name, vote_count) values ('test_restaurant_1', 0);
insert into restaurants (name, vote_count) values ('test_restaurant_2', 0);

insert into food (description, restaurant_id) values ('food_1', 1);
insert into food (description, restaurant_id) values ('food_2', 1);
insert into food (description, restaurant_id) values ('food_3', 1);
insert into food (description, restaurant_id) values ('food_4', 2);
insert into food (description, restaurant_id) values ('food_5', 2);
insert into food (description, restaurant_id) values ('food_6', 2);

insert into users (name, email, password) values ('Admin', 'admin@gmail.com', 'password');
insert into users (name, email, password) values ('User', 'user@gmail.com', 'password');

insert into user_roles (user_id, role) values ('1', 'ROLE_ADMIN');
insert into user_roles (user_id, role) values ('1', 'ROLE_USER');
insert into user_roles (user_id, role) values ('2', 'ROLE_USER');
