ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', '{noop}password'),
       ('user@javaops.ru', 'User2_First', 'User2_Last', '{noop}user'),
       ('user@user.ru', 'User3_First', 'User3_Last', '{noop}user'),
       ('admin@gmail.com', 'Admin_First', 'Admin_Last', '{noop}admin'),
       ('admin@admin.ru', 'Second_admin', 'Admin_Last_2', '{noop}admin');

INSERT INTO USER_ROLES (ROLE, USER_ID)
VALUES ('USER', 100000),
       ('USER', 100001),
       ('USER', 100002),
       ('ADMIN', 100003),
       ('USER', 100003),
       ('ADMIN', 100004),
       ('USER', 100004);

INSERT INTO RESTAURANTS (NAME, DESCRIPTION)
VALUES ('Mac', 'FastFood, address etc'),
       ('7/11', 'FastFood2, address etc'),
       ('Fried chicken', 'FastFood3, description'),
       ('Bochka', 'restaurant');

INSERT INTO DISHES (DATE_MENU, NAME, DESCRIPTION, PRICE, RESTAURANT_ID)
VALUES (now()-1, 'Mac Burger', 'Fat', 100, 100005),
       (now()-1, 'Mac Fries', 'Fast', 50, 100005),
       (now()-1, 'Mac Tea', '0 kkal', 20, 100005),
       (now()-1, '7/11 Burger', 'Fat', 130, 100006),
       (now()-1, '7/11 Donut', 'Fat', 80, 100006),
       (now()-1, '7/11 SevenUp', 'cool', 200, 100006),
       (now()-1, 'FC Burger', 'Fat', 90, 100007),
       (now()-1, 'FC wings', 'Fat', 60, 100007),
       (now()-1, 'FC Cola', 'vanilla', 90, 100007),
       (now()-1, 'Bochka business lunch', 'lunch', 180, 100008),
       (now()-1, 'Bochka beer', 'lunch', 80, 100008),
       (now(), 'Mac CheeseBurger', 'today s Fat', 110, 100005),
       (now(), 'Mac Fries', 'today s Fast', 45, 100005),
       (now(), 'Mac Tea', 'today s 0 kkal', 30, 100005),
       (now(), '7/11 Burger', 'today s Fat', 110, 100006),
       (now(), '7/11 Donut', 'today s Fat', 70, 100006),
       (now(), '7/11 SevenUp', 'today s cool', 200, 100006),
       (now(), 'FC Burger', 'today s Fat', 90, 100007),
       (now(), 'FC wings', 'today s Fat', 60, 100007),
       (now(), 'FC Cola', 'today s vanilla', 90, 100007),
       (now(), 'Bochka business lunch', 'today s lunch', 170, 100008),
       (now(), 'Bochka beer', 'today s beer', 79, 100008);

INSERT INTO VOTES (VOTE_DATE, USER_ID, RESTAURANT_ID)
values (now()-1, 100000, 100006),
       (now()-1, 100001, 100007),
       (now()-1, 100002, 100006),
       (now()-1, 100003, 100008),
       (now()-1, 100004, 100006),
       (now(), 100000, 100007),
       (now(), 100001, 100008),
       (now(), 100002, 100006),
       (now(), 100003, 100008);
