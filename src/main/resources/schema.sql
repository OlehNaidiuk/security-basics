CREATE TABLE IF NOT EXISTS usr
(
    user_id  bigint       NOT NULL AUTO_INCREMENT,
    username varchar(50)  NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    PRIMARY KEY (user_id)
);