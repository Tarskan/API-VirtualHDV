CREATE TABLE IF NOT EXISTS user (
  id_user INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  pseudo VARCHAR(50),
  password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS adverttype (
  id_adverttype INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS advert (
  id_advert INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(500),
  prix DOUBLE,
  id_adverttype INT NULL,
  FOREIGN KEY (id_adverttype) REFERENCES adverttype (id_adverttype),
  id_user INT NULL,
  FOREIGN KEY (id_user) REFERENCES user (id_user)
);