DROP TABLE IF EXISTS product;
CREATE TABLE product(id NUMBER AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, quantity NUMBER(100) NOT NULL);
INSERT INTO product(name, quantity) VALUES('Apple', 100),('Orange', 200),('Mango', 300);