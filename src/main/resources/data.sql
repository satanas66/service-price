CREATE TABLE tbl_cadena (id INTEGER PRIMARY KEY, name VARCHAR (125));
CREATE TABLE tbl_price (id INTEGER PRIMARY KEY, start_date TIMESTAMP, end_date TIMESTAMP,  product_id INTEGER, priority INTEGER, price DOUBLE, curr VARCHAR (25), brand_id INTEGER);

INSERT INTO tbl_cadena (id, name) VALUES (1, 'ZARA');

INSERT INTO tbl_price (id, start_date, end_date, priority, product_id, price, curr, brand_id) VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 0, 35455, 35.50, 'EUR', 1);
INSERT INTO tbl_price (id, start_date, end_date, priority, product_id, price, curr, brand_id) VALUES (2, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 1, 35455, 25.45, 'EUR', 1);
INSERT INTO tbl_price (id, start_date, end_date, priority, product_id, price, curr, brand_id) VALUES (3, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 1, 35455, 30.50, 'EUR', 1);
INSERT INTO tbl_price (id, start_date, end_date, priority, product_id, price, curr, brand_id) VALUES (4, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 1, 35455, 38.95, 'EUR', 1);
