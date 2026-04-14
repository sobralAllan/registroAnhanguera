package src;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static final String url="jdbc:mysql://localhost:3306/registro";
	private static final String USER = "root";
	private static final String password = "aluno";
	
	public static Connection conectar() {
		try {
			return DriverManager.getConnection(url, USER, password);
		}catch(Exception erro) {
			return null;
		}
	}//fim do conectar
}//fim da classe Conexao
