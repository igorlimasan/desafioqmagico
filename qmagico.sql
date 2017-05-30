drop schema if exists qmagico;
CREATE SCHEMA qmagico DEFAULT CHARACTER SET utf8;

create table qmagico.usuario(
		id int auto_increment,
        nome varchar(255) not null,
        login varchar(255) not null unique,
        senha varchar(256) not null,
        CONSTRAINT pk__usuario___id PRIMARY KEY (id)
);

insert into qmagico.usuario values(1,'admin','admin',SHA2('admin',256));

create table qmagico.autorizacao(
		id int,
        nome varchar(255) unique,
        CONSTRAINT pk__autorizacao___id PRIMARY KEY (id)
);

insert into qmagico.autorizacao values (1,'ROLE_ADMIN'),(2,'ROLE_STUDENT');

create table qmagico.autorizacao_usuario(
		fk_usuario int,
        fk_autorizacao int,
        CONSTRAINT fk__autorizacao_usuario___fk_usuario FOREIGN KEY (fk_usuario) references qmagico.usuario(id),
        CONSTRAINT fk__autorizacao_usuario___fk_autorizacao FOREIGN KEY (fk_autorizacao) references qmagico.autorizacao(id),
        CONSTRAINT pk__autorizacao_usuario___id PRIMARY KEY (fk_usuario,fk_autorizacao)
);
insert into qmagico.autorizacao_usuario values (1,1);

create table qmagico.perguntas(
	id int auto_increment,
    pergunta text,
    fk_usuario int,
    CONSTRAINT pk__perguntas___id PRIMARY KEY (id),
    CONSTRAINT fk__perguntas__fk_usuario FOREIGN KEY (fk_usuario) references qmagico.usuario(id)    

);

create table qmagico.respostas(
	id int auto_increment,
    respostas text,
    fk_usuario int,
    CONSTRAINT pk__respostas___id PRIMARY KEY (id),
    CONSTRAINT fk__respostas___fk_usuario FOREIGN KEY (fk_usuario) references qmagico.usuario(id)
);

create table qmagico.perguntas_respostas(
	fk_perguntas int,
    fk_respostas int,
    CONSTRAINT fk__perguntas_respostas___fk_perguntas FOREIGN KEY (fk_perguntas) references qmagico.perguntas(id),
	CONSTRAINT fk__perguntas_respostas___fk_respostas FOREIGN KEY (fk_respostas) references qmagico.respostas(id),
    CONSTRAINT pk__perguntas_respostas___id PRIMARY KEY (fk_perguntas,fk_respostas)    
);
        
        