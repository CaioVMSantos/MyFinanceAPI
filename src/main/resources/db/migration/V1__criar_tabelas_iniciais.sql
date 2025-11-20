CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE transacao (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    valor NUMERIC(19, 2) NOT NULL,
    data DATE NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    categoria_id BIGINT NOT NULL,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

INSERT INTO categoria (nome) VALUES ('Alimentação');
INSERT INTO categoria (nome) VALUES ('Transporte');
INSERT INTO categoria (nome) VALUES ('Lazer');
INSERT INTO categoria (nome) VALUES ('Saúde');
INSERT INTO categoria (nome) VALUES ('Salário');
