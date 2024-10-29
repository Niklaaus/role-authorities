--INSERT INTO users (id, username, password, role) VALUES (100000,'user', '$2a$12$QfxdmtQoTPiCoktAks4/0OlLIw5t9/ye/ElsxGJ25hB/5fPI2AQ5u', 'MANAGER'); --password is password
--INSERT INTO users (id, username, password, role) VALUES (200000,'admin', '$2a$12$A0F2W1XY7NxE0NI/ZCWE0uUfRIm0FfNZuZd7yT1io7lUS88I8iTDu', 'ADMIN'); --password is admin


-- Populating users
INSERT INTO users (username, password, enabled) VALUES ('admin_user', '$2a$12$QfxdmtQoTPiCoktAks4/0OlLIw5t9/ye/ElsxGJ25hB/5fPI2AQ5u', true); --password is password
INSERT INTO users (username, password, enabled) VALUES ('manager_user', '$2a$12$QfxdmtQoTPiCoktAks4/0OlLIw5t9/ye/ElsxGJ25hB/5fPI2AQ5u', true); --password is password

-- Populating roles
INSERT INTO roles (role_name) VALUES ('ADMIN');
INSERT INTO roles (role_name) VALUES ('MANAGER');

-- Populating authorities
INSERT INTO authorities (authority) VALUES ('ADMIN_Read');
INSERT INTO authorities (authority) VALUES ('ADMIN_Write');
INSERT INTO authorities (authority) VALUES ('MANAGER_Read');
INSERT INTO authorities (authority) VALUES ('MANAGER_Write');

-- Assign roles to users
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- Admin user with ADMIN role
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- Manager user with MANAGER role

-- Assign authorities to roles
INSERT INTO role_authorities (role_id, authority_id) VALUES (1, 1); -- ADMIN role has ADMIN_Read
INSERT INTO role_authorities (role_id, authority_id) VALUES (1, 2); -- ADMIN role has ADMIN_Write
INSERT INTO role_authorities (role_id, authority_id) VALUES (2, 3); -- MANAGER role has MANAGER_Read
--INSERT INTO role_authorities (role_id, authority_id) VALUES (2, 4); -- MANAGER role has MANAGER_Write