insert into users (name, username, password)
values ('Артем Кириллов', 'sprigrance@yandex.ru', '$2a$10$Xl0yhvzLIaJCDdKBS0Lld.ksK7c2Zytg/ZKFdtIYYQUv8rUfvCR4W');

insert into assets (quantity, last_price, target_percent, actual_sum, target_sum, to_buy_count, to_buy_sum, actual_percent, to_buy_count_rounded, to_buy_sum_rounded)
values ('0', '0', '0', '0', 0, 0, 0, 0, 0, 0);

insert into users_assets (user_id, asset_id)
values (1, 1);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN');