DROP TABLE IF EXISTS discount;
CREATE TABLE discount(id NUMBER AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, discount NUMBER(100) NOT NULL);
INSERT INTO discount(name, discount) VALUES('Apple', 10),('Orange', 20),('Mango', 3);