# Descarte Ideal - Projeto de Nivelamento

O Descarte Ideal é um projeto de nivelamento para a disciplina de 'Fábrica de Software'.
A aplicação tem como objetivo chegar o mais perto possível de um site funcional que dê o auxílio ao descarte de diferentes tipos de lixo.

## Configurações

| Item                     | Valor                                                   |
|--------------------------|---------------------------------------------------------|
| Build Tool               | Maven                                                   |
| Dependencies             | Lombok, Spring Web, Spring Data JPA and Spring DevTools |
| DataBase                 | PostgreSQL                                              |
| Template Engine          | Thymeleaf                                               |


## SQL 

Instruções SQL
```SQL

CREATE DATABASE descarte_ideal_db;

CREATE TABLE ponto_descarte (
	id BIGINT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	endereco TEXT NOT NULL,
	horario_funcionamento TEXT NOT NULL,
	material_aceito TEXT NOT NULL 
);


CREATE TABLE solicitacao_denuncia (
	id_denuncia BIGINT PRIMARY KEY,
	descricao TEXT NOT NULL,
	cep CHAR(8) NOT NULL,
	endereco TEXT NOT NULL,
	data_criacao TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE solicitacao_coleta (
	id_coleta BIGINT PRIMARY KEY,
	nome_completo VARCHAR(255) NOT NULL,
	cpf CHAR(11) NOT NULL,
	descricao_objeto TEXT,
	cep CHAR(8) NOT NULL,
	endereco TEXT NOT NULL,
	data_criacao TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE verificacao_status (
	id_status BIGINT PRIMARY KEY,
	id_denuncia BIGINT,
	id_coleta BIGINT,
	tipo_solicitacao BOOLEAN NOT NULL,
	status VARCHAR(20) NOT NULL,
	data_criacao TIMESTAMP WITHOUT TIME ZONE NOT NULL, 
	
	CONSTRAINT fk_denuncia FOREIGN KEY (id_denuncia) REFERENCES solicitacao_denuncia (id_denuncia), 
  CONSTRAINT fk_coleta FOREIGN KEY (id_coleta) references solicitacao_coleta (id_coleta),
	
    
  -- false = é denuncia, logo é preciso do id_denuncia
  -- true = é coleta, logo é preciso do id_coleta
	CONSTRAINT chk_tipo_solicitacao
    CHECK (
        (tipo_solicitacao = FALSE AND id_denuncia IS NOT NULL AND id_coleta IS NULL) OR
        (tipo_solicitacao = TRUE AND id_denuncia IS NULL AND id_coleta IS NOT NULL)
    )
);
```
