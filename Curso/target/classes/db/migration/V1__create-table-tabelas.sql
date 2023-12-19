CREATE TABLE empresa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome_empresa VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (id)
);

CREATE TABLE jogo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    ano VARCHAR(4) NOT NULL,
    quantidade INT NOT NULL,
    plataforma VARCHAR(100) NOT NULL,
    id_empresa BIGINT, 
    
    PRIMARY KEY (id),
    FOREIGN KEY (id_empresa) REFERENCES empresa(id) ON DELETE SET NULL
);
