CREATE TABLE task (
	id INT PRIMARY KEY auto_increment, 
	title varchar(200), 
	description TEXT, 
	points int,
	status int DEFAULT 0,
	user_id int
);

CREATE TABLE user (
	id bigint PRIMARY KEY auto_increment,
	name varchar(200),
	email varchar(200),
	password varchar(200),
	githubuser varchar(200)
);

CREATE TABLE role (
	id int primary key auto_increment,
	name varchar(200)
);

CREATE TABLE user_roles(
	user_id int,
	roles_id int
);

INSERT INTO role (name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

INSERT INTO user (name, email, password, githubuser) VALUES
('Joao Carlos', 'joao@gmail.com', '$2a$12$MR71xdTK7TLEufynjWM3yudy/afK7WSP.pEEaPZTK76zaRsCNQT02', 'joaocarloslima'),
('Carla Lopes', 'carla@gmail.com', '$2a$12$MR71xdTK7TLEufynjWM3yudy/afK7WSP.pEEaPZTK76zaRsCNQT02', 'carla'),
('Fabio Cabrini', 'fabio@fiap.com.br', '$2a$12$MR71xdTK7TLEufynjWM3yudy/afK7WSP.pEEaPZTK76zaRsCNQT02', 'jose'),
('Gabriel Silva', 'gabriel@fiap.com.br', '$2a$12$MR71xdTK7TLEufynjWM3yudy/afK7WSP.pEEaPZTK76zaRsCNQT02', 'gsilvasouza'),
('Admin', 'admin@fiap.com.br', '$2a$10$PExO1bsfgppWhp2LPW17MuKInX1susT33ZLxPMIEg3R.RcG9Ehn/O', 'admin');

INSERT INTO user_roles VALUES (1,1), (1,2), (2,2), (3,2), (4,2), (5,1), (5,2);

INSERT INTO task (id, title, description, points, status, user_id) VALUES 
(1, 'Criar banco de dados', 'Criar o banco no mysql', 50, 10, 1);

INSERT INTO task (id, title, description, points, status) VALUES 
(2, 'Prototipação do sistema', 'Protótipo de alta fidelidade', 350, 60);

INSERT INTO task (id, title, description, points, status, user_id) VALUES 
(3, 'Modelagem de dados', 'Criar diagramas', 150, 90, 2);

INSERT INTO task (id, title, description, points, status, user_id) VALUES
(4, 'Testes unitarios', 'Criar testes unitarios em java', 300, 100, 4);
