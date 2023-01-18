CREATE TABLE tbl_cadena (id BIGINT PRIMARY KEY, name VARCHAR (125));
CREATE TABLE tbl_price (price_list BIGINT PRIMARY KEY, start_date TIMESTAMP, end_date TIMESTAMP,  product_id BIGINT, priority BIGINT, price DOUBLE, curr VARCHAR (25), brand_id BIGINT);

INSERT INTO tbl_cadena (id, name) VALUES (1, 'ZARA');
INSERT INTO tbl_price (price_list, start_date, end_date, product_id, priority, price, curr, brand_id) VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 35.50, '€', 1);
