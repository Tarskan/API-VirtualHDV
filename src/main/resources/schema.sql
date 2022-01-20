CREATE TABLE IF NOT EXISTS user (
  id_user INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  pseudo VARCHAR(50),
  password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS typeProduct (
  id_typeProduct INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS product (
  id_product INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(500),
  prix DOUBLE,
  id_typeProduct INT NULL,
  FOREIGN KEY (id_typeProduct) REFERENCES typeProduct (id_typeProduct)
);