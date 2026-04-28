package src;

import java.sql.*;
import java.util.*;

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
	
	public String listar() {
		List<Pessoa> lista = new ArrayList<>();
		String sql = "Select * from pessoa";
		String msg = "";//Guardar TODOS os dados do bd
		
		try(Connection con = Conexao.conectar();
			Statement stmt = con.createStatement();
			ResultSet rs   = stmt.executeQuery(sql)				
		){
			while(rs.next()) {
				Pessoa person = new Pessoa();
				person.setCod(rs.getString("codigo"));
				person.setNome(rs.getString("nome"));
				person.setData(rs.getString("dtNascimento"));
				msg += "\nCódigo: " + person.getCod()  +
					   "\nNome: "   + person.getNome() +
					   "\nData Nascimento: " + person.getData();
				lista.add(person);
			}//fim do while
		}catch(Exception erro) {
			erro.printStackTrace();
		}
		return msg;
	}//fim do método
	
	public String atualizar(Pessoa person) {
		String sql = "Update pessoa set nome = ?, dtNascimento = ? where codigo = ?";
		//Tentar executar o código
		try(Connection con = Conexao.conectar();
			PreparedStatement stmt = con.prepareStatement(sql)
		){
			stmt.setString(1, person.getCod());
			stmt.setString(2, person.getNome());
			stmt.setString(3, person.getData());
			
			stmt.executeUpdate();//Atualiza os dados no banco
			return "Atualizado!";
		}catch(Exception erro) {
			return "Não atualizado\n\n" + erro;
		}	
	}//fim do atualizar
	
	public String excluir(int codigo) {
		String sql = "delete from pessoa where codigo = ?";
		
		try(Connection con = Conexao.conectar();
			PreparedStatement stmt = con.prepareStatement(sql)
		){
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			return "Excluido";
		}catch(Exception erro) {
			return erro + "\n\n Erro!";
		}
	}//fim do método
	
	
}//DATA ACCESS OBJECT
