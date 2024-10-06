--Recomendo fazer isso antes de criar, para verificar a existência:
drop sequence SEQ_FILMES_ID;
drop Trigger TRG_FILMES_ID;
drop table T_FILMES;

-- Criação da tabela T_FILMES
CREATE TABLE T_FILMES (
    ID_FILME NUMBER(10) PRIMARY KEY,   -- Identificador único
    TITLE VARCHAR2(255),               -- Título do filme
    YEAR VARCHAR2(4),                  -- Ano de lançamento
    RATED VARCHAR2(10),                -- Classificação indicativa
    RELEASED VARCHAR2(15),             -- Data de lançamento
    RUNTIME VARCHAR2(50),              -- Duração do filme
    GENRE VARCHAR2(100),               -- Gênero(s) do filme
    DIRECTOR VARCHAR2(100),            -- Diretor
    WRITER VARCHAR2(255),              -- Roteirista(s)
    ACTORS VARCHAR2(255),              -- Atores principais
    PLOT VARCHAR2(1000),               -- Sinopse
    LANGUAGE VARCHAR2(100),            -- Idioma(s)
    COUNTRY VARCHAR2(100),             -- País de origem
    AWARDS VARCHAR2(255),              -- Prêmios recebidos
    POSTER VARCHAR2(500),              -- URL do poster
    METASCORE NUMBER,                  -- Pontuação do Metacritic
    IMDB_RATING VARCHAR2(10),          -- Classificação no IMDb
    IMDB_VOTES VARCHAR2(20),           -- Número de votos no IMDb
    IMDB_ID VARCHAR2(20),              -- ID do IMDb
    TYPE VARCHAR2(50),                 -- Tipo (ex: filme, série)
    DVD VARCHAR2(50),                  -- Data de lançamento em DVD
    BOXOFFICE VARCHAR2(50),            -- Receita de bilheteria
    PRODUCTION VARCHAR2(100),          -- Produtora
    WEBSITE VARCHAR2(255),             -- URL do site oficial
    RESPONSE VARCHAR2(10)              -- Resposta de sucesso ou falha
);

-- Criação da sequência SEQ_FILMES_ID para autoincremento
CREATE SEQUENCE SEQ_FILMES_ID
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação do trigger TRG_FILMES_ID para atribuir automaticamente o ID_FILME
CREATE OR REPLACE TRIGGER TRG_FILMES_ID
BEFORE INSERT ON T_FILMES
FOR EACH ROW
BEGIN
    :NEW.ID_FILME := SEQ_FILMES_ID.NEXTVAL;
END;
/

-- Visualizar melhor se caso o id estiver em ordem DESC:
SELECT * FROM T_FILMES ORDER BY ID_FILME ASC;

