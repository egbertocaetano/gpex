package gpex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;


public class CreateDB {
	
	public static void main(String[] args) throws Exception {
		// Deleta db 'extensao' se existir
		DeleteDbFiles.execute("~", "extensao", true);
		
		// Abre a conex�o
		Class.forName("org.h2.Driver");
        Connection con = DriverManager.getConnection("jdbc:h2:~/extensao;AUTO_SERVER=TRUE", "sa", "");
        
        // Cria tabelas
        Statement query = con.createStatement();
        
        query.execute("create table Criterio(id int primary key auto_increment, descricao varchar(255) not null, CR varchar(255) not null)");
        query.execute("create table Selecao(id int primary key auto_increment, data datetime not null ) ");
        query.execute("create table Candidato(id int primary key auto_increment, nome varchar(255) not null, matricula varchar(10) not null unique, email varchar(255) not null)");
        query.execute("create table Projeto(id int primary key auto_increment, descricao varchar (255) not null )");
        query.execute("create table Equipe(id int primary key auto_increment, projeto_id int null, constraint FK_Equipe_Projeto_Id FOREIGN KEY (projeto_id) REFERENCES Projeto(id) ) ");
        
        
        query.execute("create table Integrante(id int not null, equipe_id int not null, primary key(id), constraint FK_Candidato_Id FOREIGN KEY (id) REFERENCES Candidato(id), constraint FK_Equipe_Id FOREIGN KEY (equipe_id) REFERENCES Equipe(id) )");

        query.execute("create table Reuniao(id int primary key auto_increment, data date not null, hora time not null, obs varchar (255) not null ) ");
        query.execute("create table Frequencia( integrante_id int not null, reuniao_id int not null, primary key(integrante_id, reuniao_id), constraint FK_Integrante_Id FOREIGN KEY (integrante_id) REFERENCES Integrante(id), constraint FK_Frequencia_Reuniao_Id FOREIGN KEY (reuniao_id) REFERENCES Reuniao(id) )");
            
        query.execute("create table Status_Tarefa(id int primary key auto_increment, descricao varchar(100) not null)");
        query.execute("create table Tarefa (id int primary key auto_increment, descricao varchar(255) not null, status_id int not null, prazo timestamp not null, integrante_id int not null, tarefa_id int not null, projeto_id int not null, constraint FK_Tarefa_Integrante_Id FOREIGN KEY (integrante_id) REFERENCES Integrante(id), constraint FK_Status_Id FOREIGN KEY (status_id) REFERENCES Status_Tarefa(id), constraint FK_Tarefa_Id FOREIGN KEY (tarefa_id) REFERENCES Tarefa(id), constraint FK_Projeto_Id FOREIGN KEY (projeto_id) REFERENCES Projeto(id)  ) "); // id?


        System.out.println("Criado!");
        
        /*
        query.execute("INSERT INTO Candidato (nome, matricula, email) VALUES "
        		+ " ('Jessica', '2011785144', 'jessica_aparecida_2@hotmail.com') "
        		+ ",('Ronaldo Vieira', '2011785145', 'ronaldo@hotmail.com') "
        		+ ",('Rodolpho', '2011785146', 'rodolpho@hotmail.com') "
        		+ ",('Valber Laux', '2011785147', 'valber@hotmail.com') "
        		+ ",('Thiago Damasceno', '2011785148', 'thiago@hotmail.com')"
        		+ ",('Egberto', '2011785149', 'egg@hotmail.com')  ");
        */
        
        query.execute("INSERT INTO Status_Tarefa (descricao) VALUES "
        		+ " ('pendente') "
        		+ ", ('em andamento')"
        		+ ", ('concluido') ");
        
        
        // Fecha a conex�o
        query.close();
        con.close();
	}
}