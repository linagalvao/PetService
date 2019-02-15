create schema petservicos;

create table petservicos.funcionario(
	id serial  PRIMARY KEY,
	nome varchar(150) not null unique
);

create table petservicos.servico(
	id serial PRIMARY KEY,
	nome varchar (100) not null unique,
	tipo_servico char (1) not null,
	check (tipo_servico IN ('B', 'T')),
	descricao varchar (500)

);

create table petservicos.raca (
	id serial PRIMARY KEY,
	nome varchar (50) not null unique,
	especie varchar (1) not null,
	check (especie IN ('F', 'C'))

);

create table petservicos.cliente(
	id serial PRIMARY KEY,
	nome varchar (150) not null unique,
	email varchar (150),
	telefone1 varchar (20),
	telefone2 varchar (20)

);


create table petservicos.animal(
	id varchar (25) PRIMARY KEY not null,
	nome varchar (50) not null,
	sexo varchar (1) not null,
	data_nasc date,
	id_raca INTEGER NOT NULL,
	id_cliente INTEGER NOT NULL,
	check (sexo IN ('F', 'M')),
	CONSTRAINT FK_RACA FOREIGN KEY (id_raca) REFERENCES raca(id),
	CONSTRAINT FK_CLIENTE FOREIGN KEY (id_cliente) REFERENCES cliente(id)
	
);

create table petservicos.fila(
	id serial PRIMARY KEY,
	id_animal varchar (50) NOT NULL,
	id_servico INTEGER NOT NULL,
	id_funcionario INTEGER,
	observacao varchar (500),
	status varchar (1) NOT NULL,
	numero_coleira INTEGER NOT NULL,
	ordem INTEGER NOT NULL,
	check (status IN ('A', 'C', 'I', 'P', 'F', 'E')),
	CONSTRAINT FK_ANIMAL FOREIGN KEY (id_animal) REFERENCES animal(id),
	CONSTRAINT FK_SERVICO FOREIGN KEY (id_servico) REFERENCES servico(id),
	CONSTRAINT FK_FUNCIONARIO FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
	
);


