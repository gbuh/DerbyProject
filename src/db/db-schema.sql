DROP table userm IF EXISTS;

CREATE table userm (
user_id BIGINT NOT NULL PRIMARY KEY,
user_name VARCHAR(50),
user_email VARCHAR(50),
user_password VARCHAR(50),
user_role VARCHAR(50)
);