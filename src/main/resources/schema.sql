--CREATE TABLE IF NOT EXISTS users (
--    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    username VARCHAR(50) NOT NULL,
--    password VARCHAR(100) NOT NULL,
--    role VARCHAR(50) NOT NULL
--);

-- Creating tables
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE authorities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    authority VARCHAR(50) NOT NULL
);

CREATE TABLE user_roles (
    user_id INT,
    role_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE role_authorities (
    role_id INT,
    authority_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (authority_id) REFERENCES authorities(id)
);