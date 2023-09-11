CREATE TABLE timezone
(
    id       BIGINT PRIMARY KEY NOT NULL,
    key      TEXT UNIQUE        NOT NULL,
    "offset" INT                NOT NULL
);


COPY timezone (id, key, "offset")
--     абсолютный путь к файлу
    FROM 'db/migration/data/timezone.csv'
    WITH CSV DELIMITER ';';