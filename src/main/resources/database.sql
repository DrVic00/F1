CREATE TABLE users
(
    id_user  int not null PRIMARY KEY AUTO_INCREMENT,
    nick     varchar(35),
    password varchar(64),
    mail     varchar(64)
);