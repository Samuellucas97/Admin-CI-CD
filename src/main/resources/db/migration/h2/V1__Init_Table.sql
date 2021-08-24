CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY,
                       password VARCHAR(255) NOT NULL,
                       enabled BOOLEAN NOT NULL
);
CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL
);
CREATE TABLE customers (
                           id BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           firstname VARCHAR(50) NOT NULL,
                           lastname VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           added_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO customers (id, firstname, lastname, email, added_date)
VALUES (1, 'Uchiha', 'Sasuke', 'uchiha_sasuke@konohagakure.com', '2020-03-29 07:52:34'),
       (2, 'Uzumaki', 'Naruto', 'uzumaki_naruto2@konohagakure.com', '2020-03-29 08:18:59');
