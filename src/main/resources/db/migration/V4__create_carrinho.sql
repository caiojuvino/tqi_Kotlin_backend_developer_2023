CREATE TABLE carrinho (
  id BIGINT AUTO_INCREMENT NOT NULL,
   CONSTRAINT pk_carrinho PRIMARY KEY (id)
);

CREATE TABLE carrinho_itens (
  carrinho_id BIGINT NOT NULL,
   itens_id BIGINT NOT NULL
);

ALTER TABLE carrinho_itens ADD CONSTRAINT uc_carrinho_itens_itens UNIQUE (itens_id);

ALTER TABLE carrinho_itens ADD CONSTRAINT fk_carite_on_carrinho FOREIGN KEY (carrinho_id) REFERENCES carrinho (id);

ALTER TABLE carrinho_itens ADD CONSTRAINT fk_carite_on_item FOREIGN KEY (itens_id) REFERENCES item (id);