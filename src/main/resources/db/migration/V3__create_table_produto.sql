CREATE TABLE produto (
  id BIGINT AUTO_INCREMENT NOT NULL,
   id_categoria BIGINT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   unidade_de_medida VARCHAR(255) NULL,
   preco DECIMAL NOT NULL,
   CONSTRAINT pk_produto PRIMARY KEY (id)
);

ALTER TABLE produto ADD CONSTRAINT uc_produto_nome UNIQUE (nome);

ALTER TABLE produto ADD CONSTRAINT FK_PRODUTO_ON_ID_CATEGORIA FOREIGN KEY (id_categoria) REFERENCES categoria (id);