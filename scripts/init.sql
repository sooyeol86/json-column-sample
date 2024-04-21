CREATE TABLE IF NOT EXISTS "product"
(
    "id" BIGSERIAL PRIMARY KEY,
    "name" VARCHAR(128),
    "option" JSONB,
    "paid_type" JSONB,
    "price_type" INTEGER
    );

CREATE TABLE IF NOT EXISTS "product_normal_price"
(
    "id" BIGINT PRIMARY KEY,
    "price" INT,
    "display_price" INT,
    CONSTRAINT fk_product foreign key (id) references product(id)
    );

CREATE TABLE IF NOT EXISTS "product_dynamic_price"
(
    "id" BIGINT PRIMARY KEY,
    "range_name" VARCHAR(32),
    "detail" JSONB,
    CONSTRAINT fk_product foreign key (id) references product(id)
    );

insert into "product" (id, name, option, paid_type, price_type)
values (1, '무료 상품', '{ "is_paid_usable" : false, "is_pre_apply_able" : true }', '["카드", "CMS"]', 0);

insert into "product" (id, name, option, paid_type, price_type)
values (2, '일반 유료 상품', '{ "is_paid_usable" : true, "is_pre_apply_able" : false }', '["카드"]', 1);

insert into "product_normal_price" (id, price, display_price)
values(2, 10000, 15000);

insert into "product" (id, name, option, paid_type, price_type)
values (3, '가변 상품', '{ "is_paid_usable" : false, "is_pre_apply_able" : true }', '["CMS"]', 2);

insert into "product_dynamic_price" (id, range_name, detail)
values(3, '개수 별 가격 변동', '[{ "start_range" : 1, "finish_range" : 9, "price" : 10000 }, { "start_range" : 10, "finish_range" : 19, "price" : 9000 }, { "start_range" : 20, "finish_range" : 30, "price" : 8000 }]');
