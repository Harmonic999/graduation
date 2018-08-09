delete from food;
delete from restaurants;

insert into restaurants (name, vote_count) values ('test_restaurant_1', 0);
insert into restaurants (name, vote_count) values ('test_restaurant_2', 0);

insert into food (description, restaurant_id) values ('food_1', 1);
insert into food (description, restaurant_id) values ('food_2', 1);
insert into food (description, restaurant_id) values ('food_3', 1);
insert into food (description, restaurant_id) values ('food_4', 2);
insert into food (description, restaurant_id) values ('food_5', 2);
insert into food (description, restaurant_id) values ('food_6', 2);
