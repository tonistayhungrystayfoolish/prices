create table prices (
	id BIGINT not null,
    start_date TimeStamp,
    end_date TimeStamp,
	brand_id BIGINT not null,
    currency CHAR(10) not null,
    price_list BIGINT not null,
    product_id BIGINT not null,
    price NUMERIC(20, 2) not null,
    priority Integer not null,
	PRIMARY KEY (id)
);
INSERT INTO prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES  (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');