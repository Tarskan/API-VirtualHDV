CREATE TABLE IF NOT EXISTS user (
  id_user INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  adress VARCHAR(50),
  city VARCHAR(50),
  email VARCHAR(100),
  pseudo VARCHAR(50),
  password VARCHAR(50),
  url VARCHAR(200)
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
  url VARCHAR(200) NULL,
  id_adverttype INT NULL,
  FOREIGN KEY (id_adverttype) REFERENCES adverttype (id_adverttype),
  id_user INT NULL,
  FOREIGN KEY (id_user) REFERENCES user (id_user),
  soldto INT NULL,
  FOREIGN KEY (soldto) REFERENCES user (id_user)
);

CREATE TABLE IF NOT EXISTS tchat (
  id_tchat INT PRIMARY KEY AUTO_INCREMENT,
  id_userone INT NULL,
  FOREIGN KEY (id_userone) REFERENCES user (id_user),
  id_usertwo INT NULL,
  FOREIGN KEY (id_usertwo) REFERENCES user (id_user),
  id_advert INT NULL,
  FOREIGN KEY (id_advert) REFERENCES advert (id_advert)
);

CREATE TABLE IF NOT EXISTS message (
  id_message INT PRIMARY KEY AUTO_INCREMENT,
  text VARCHAR(500),
  id_user INT NULL,
  FOREIGN KEY (id_user) REFERENCES user (id_user),
  id_tchat INT NULL,
  FOREIGN KEY (id_tchat) REFERENCES tchat (id_tchat)
);