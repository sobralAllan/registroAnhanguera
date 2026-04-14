create database registro;

use registro;

create table pessoa(
	codigo int not null auto_increment primary key,
    nome varchar(150) not null,
    dtNascimento date not null
)engine = InnoDB;