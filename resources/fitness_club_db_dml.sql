INSERT INTO sport_name(name)
VALUES ('Бодибилдинг'),
       ('Плавание'),
       ('Тяжелая Атлетика'),
       ('Кроссфит'),
       ('Бег'),
       ('Йога');

INSERT INTO coach_education(name_education)
VALUES ('Колледж'),
       ('Интститут'),
       ('Курсы');

INSERT INTO coach(last_name, first_name, education_id, sport_id, years_experience)
VALUES ('Голубочкин', 'Дмитрий', 2, 1, 25),
       ('Спасокукотский', 'Юрий', 1, 4, 7),
       ('Иванов', 'Олег', 3, 6, 12),
       ('Семенова', 'Ирина', 2, 2, 13),
       ('Явлинская', 'Оксана', 1, 5, 5),
       ('Бодюк', 'Василий', 2, 2, 12),
       ('Бодюк', 'Иван', 2, 3, 11),
       ('Бодюк', 'Валерий', 2, 4, 9);

INSERT INTO client_status(status_name)
VALUES ('VIP'),
       ('SPA-ONLY'),
       ('POOL-ONLY'),
       ('GYM-ONLY');

INSERT INTO client(last_name, first_name, status_id, days_left)
VALUES ('Иванов', 'Иван', 1, 345),
       ('Семенов', 'Семен', 2, 185),
       ('Александров', 'Александр', 3, 300),
       ('Дмитриев', 'Дмитрий', 4, 145),
       ('Олегов', 'Олег', 1, 445),
       ('Валериев', 'Валерий', 3, 348),
       ('Шилдт', 'Герберт', 1, 315),
       ('Басилиев', 'Басилий', 4, 333),
       ('Сергеев', 'Сергей', 1, 243),
       ('Алексеев', 'Алексей', 1, 312),
       ('Ростиславов', 'Ростислав', 2, 0),
       ('Вячеславов', 'Вячеслав', 1, 45),
       ('Дауни', 'Младший', 1, 111),
       ('Шаудоу', 'Фиенд', 2, 0),
       ('Войд', 'Спирит', 2, 0),
       ('Ковалев', 'Иван', 1, 545),
       ('Березовский', 'Дмитрий', 4, 145),
       ('Мешков', 'Мешок', 2, 321),
       ('Шконвов', 'Иван', 4, 35),
       ('Сильченко', 'Олег', 1, 45);

INSERT INTO schedule(coach_id, sport_id, duration_hours)
VALUES (1, 1, 3),
       (2, 4, 1),
       (3, 2, 1),
       (4, 4, 1),
       (5, 5, 1),
       (6, 2, 1),
       (7, 3, 2),
       (8, 4, 1);

INSERT INTO traning(coach_id, sport_id, client_id, price, shedule_id)
    VALUES (1, 3, 21, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 3, 25, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 3, 27, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 1, 29, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 1, 30, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 1, 32, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 1, 33, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 1, 36, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1),
       (1, 1, 40, 2400 * (select duration_hours from schedule where schedule.coach_id = 1), 1);
VALUES (2, 4, 40, 1500 * (select duration_hours from schedule where schedule.coach_id = 2), 2),
 (2, 4, 39, 1500 * (select duration_hours from schedule where schedule.coach_id = 2), 2),
 (2, 4, 37, 1500 * (select duration_hours from schedule where schedule.coach_id = 2), 2),
 (2, 4, 28, 1500 * (select duration_hours from schedule where schedule.coach_id = 2), 2),
 (2, 4, 24, 1500 * (select duration_hours from schedule where schedule.coach_id = 2), 2);

VALUES (3, 6, 40, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 36, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 33, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 32, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 30, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 29, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 27, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 25, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1),
 (3, 6, 21, 1200 * (select duration_hours from schedule where schedule.coach_id = 3), 1);

VALUES (4, 2, 23, 1500 * (SELECT duration_hours FROM schedule WHERE schedule.coach_id = 4), 4),
       (6, 2, 26, 1100 * (SELECT duration_hours FROM schedule WHERE schedule.coach_id = 4), 6);

VALUES (5,5,21,1000 * (SELECT duration_hours FROM schedule WHERE schedule.coach_id = 4),5),
 (5,5,27,1000 * (SELECT duration_hours FROM schedule WHERE schedule.coach_id = 4),5),
 (5,5,29,1000 * (SELECT duration_hours FROM schedule WHERE schedule.coach_id = 4),5);
