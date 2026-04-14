package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControlPessoa {
	//Variável Global
	Scanner entrada;
	Pessoa person;
	
	public ControlPessoa() {
		this.entrada = new Scanner(System.in);
		this.person  = new Pessoa();
	}//fim do método construtor	
	
	public String entradaCodigo() {
		//Variável Local
		String codigo = JOptionPane.showInputDialog(null, "Informe o código: ", "Código", 
				                                    JOptionPane.QUESTION_MESSAGE);
		return codigo;
	}//fim do entrada codigo
	
	public String entradaNome() {
		String nome   = JOptionPane.showInputDialog(null, "Informe o nome: ", "Nome",
													JOptionPane.QUESTION_MESSAGE);
		return nome;
	}//fim do entrada nome
		
	public String entradaData() {
		String data   = JOptionPane.showInputDialog(null, "Informe a data de nascimento: ", "Data",
													JOptionPane.QUESTION_MESSAGE);
		return data;
	}//fim do entrada de data
	
	public void cadastrar() {
		int codigo  = Integer.parseInt(entradaCodigo());
		String nome = entradaNome();
		String data = entradaData();
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dtNascimento    = LocalDate.parse(data, formato);
			
			//Método para inserir o dado no banco de dados
			this.person = new Pessoa(codigo, nome, dtNascimento);
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Resultado", JOptionPane.ERROR_MESSAGE);
		}//fim do catch
		
	}//fim do cadastrar
	
	
	
	
	
	
}//fim da control Pessoa
