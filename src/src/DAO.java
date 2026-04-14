package src;

import java.sql.Connection;
import java.sql.*;

public class DAO {
	
	public String inserir(Pessoa person) {
		String sql = "Insert into pessoa(codigo, nome, dtNascimento) values(?,?,?)";
		try(Connection conn = Conexao.conectar();PreparedStatement stmt = conn.prepareStatement(sql)){
			
			//Inserir os dados no banco
			stmt.setInt(1, person.getCodigo());
			stmt.setString(2, person.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(person.getDataNascimento()));
			stmt.executeUpdate();//CTRL+ENTER -> INSERINDO NO BANCO DE DADOS			
			
			return "Inserido com sucesso!";
		}catch(Exception erro) {
			return erro + "\n\nERRO!!!!!";
		}//fim do try_CATCH
	}//fim do inserir
	
	
}//DATA ACCESS OBJECT
