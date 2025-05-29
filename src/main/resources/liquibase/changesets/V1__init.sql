create table if not exists users
(
    id       bigserial primary key,
    name     varchar(255) not null,
    username varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists tickers
(
    id           BIGSERIAL PRIMARY KEY,
    isin         VARCHAR(255),
    short_name   VARCHAR(255),
    last_price   DECIMAL(19, 2)
);

create table if not exists assets
(
    id                    BIGSERIAL PRIMARY KEY,                              -- Автоинкрементный идентификатор
    ticker_id             BIGINT,                                             -- Внешний ключ, связанный с таблицей "tickers"
    quantity              BIGINT NOT NULL,                                    -- Количество
    last_price            DECIMAL(19, 2) NOT NULL,                            -- Последняя цена
    showed_name           VARCHAR(255),                                       -- Отображаемое имя
    target_percent        FLOAT NOT NULL,                                     -- Целевой процент
    actual_sum            DECIMAL(16, 2) NOT NULL,                            -- Фактическая сумма
    target_sum            DECIMAL(16, 2) NOT NULL,                            -- Целевая сумма
    to_buy_count          FLOAT NOT NULL,                                     -- Количество для покупки
    to_buy_sum            DECIMAL(16, 2) NOT NULL,                            -- Сумма для покупки
    actual_percent        FLOAT NOT NULL,                                     -- Фактический процент
    to_buy_count_rounded  BIGINT NOT NULL,                                    -- Округлённое количество для покупки
    to_buy_sum_rounded    DECIMAL(16, 2) NOT NULL,                            -- Сумма покупки после округления
    CONSTRAINT fk_ticker FOREIGN KEY (ticker_id) REFERENCES tickers(id)       -- Внешний ключ к таблице "tickers"
);

create table if not exists users_assets
(
    user_id bigint not null,
    asset_id bigint not null,
    primary key (user_id, asset_id),
    constraint fk_users_assets_users foreign key (user_id) references users (id) on delete cascade on update no action,
    constraint fk_users_assets_assets foreign key (asset_id) references assets (id) on delete cascade on update no action
);

create table if not exists users_roles
(
    user_id  bigint       not null,
    role     varchar(255) not null,
    primary  key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users (id) on delete cascade on update no action
);

-- create table if not exists tasks_images
-- (
--     task_id bigint       not null,
--     image   varchar(255) not null,
--     constraint fk_tasks_images_tasks foreign key (task_id) references tasks (id) on delete cascade on update no action
-- );