create table empresa(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    primary key (id_empresa)
);

create table jogo(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    ano varchar(100) not null,
    quantidade int (100) not null,
    plataforma varchar(100) not null,
    id_empresa BIGINT,
    primary key (id),
    FOREIGN KEY (id_empresa) REFERENCES Empresa(id)
);
