CREATE TABLE empresa (
    id_empresa BIGINT NOT NULL AUTO_INCREMENT,
    nome_empresa VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (id_empresa)
);

CREATE TABLE jogo (
    id_jogo BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    ano VARCHAR(4) NOT NULL,
    quantidade INT NOT NULL,
    plataforma VARCHAR(100) NOT NULL,
    preco float,
    id_empresa BIGINT, 
    
    PRIMARY KEY (id_jogo),
    FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa) ON DELETE SET NULL
);

CREATE TABLE cliente (
    id_cliente BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(30) NOT NULL,
    senha VARCHAR(60) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (id_cliente)
);

CREATE TABLE funcionario (
    id_funcionario BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(30) NOT NULL,
    senha VARCHAR(60) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (id_funcionario)
);

CREATE TABLE pedido (
    id_pedido BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    valorTotal FLOAT NOT NULL,
    data_pedido DATETIME,
    data_entrega DATETIME,
    forma_pagamento VARCHAR(30) NOT NULL,
    finalizado BOOLEAN NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE item (
    id_item BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_jogo BIGINT,
    quantidade INT NOT NULL,
    id_pedido BIGINT,
    FOREIGN KEY (id_jogo) REFERENCES jogo(id_jogo),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);