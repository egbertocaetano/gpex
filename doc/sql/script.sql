create table Criterio(
	id int primary key auto_increment, 
	descricao varchar(255) not null
);

create table Selecao(
	id int primary key auto_increment, 
	data date not null
);

create table Candidato(
	id int primary key auto_increment, 
	nome varchar(255) not null, 
	matricula varchar(10) not null unique, 
	email varchar(255) not null
);

create table Projeto(
	id int primary key auto_increment, 
	descricao varchar (255) not null
);

create table Equipe(
	id int primary key auto_increment, 
	projetoId int not null, 
	constraint FK_Equipe_Projeto_Id FOREIGN KEY (projetoId) REFERENCES Projeto(id)
);

create table Integrante(
	candidatoId int primary key not null, 
	equipeId int not null, 
	primary key(candidatoId), 
	constraint FK_Candidato_Id FOREIGN KEY (candidatoId) REFERENCES Candidato(id), 
	constraint FK_Equipe_Id FOREIGN KEY (equipeId) REFERENCES Equipe(id)
);

create table Reuniao(
	id int primary key auto_increment, 
	dataHora timestamp not null,
	observacao varchar (255) not null
);

create table Frequencia(
	integranteId int not null, 
	reuniaoId int not null, 
	primary key(integranteId, reuniaoId), 
	constraint FK_Integrante_Id FOREIGN KEY (integranteId) REFERENCES Integrante(candidatoId), 
	constraint FK_Frequencia_Reuniao_Id FOREIGN KEY (reuniaoId) REFERENCES Reuniao(id)
);

create table Tarefa(
	id int primary key auto_increment, 
	nome varchar(80) not null,
	descricao varchar(255) not null, 
	prazo timestamp not null, 
	tarefaPaiId int, 
	integranteId int not null,
	projetoId int not null,  
	constraint FK_Tarefa_Id FOREIGN KEY (tarefaPaiId) REFERENCES Tarefa(id), 
	constraint FK_Projeto_Id FOREIGN KEY (projetoId) REFERENCES Projeto(id),
	constraint FK_Integrante_Tarefa_Id FOREIGN KEY (integranteId) REFERENCES Integrante(candidatoId)
);