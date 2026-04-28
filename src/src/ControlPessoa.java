package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControlPessoa {
	//Variável Global
	Scanner entrada;
	Pessoa person;
	DAO dao;//Métodos de acesso ao bd
	
	public ControlPessoa() {
		this.entrada = new Scanner(System.in);
		this.person  = new Pessoa();
		this.dao     = new DAO(); 
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
	
	public void cadastrarTela() {
		String codigo = JOptionPane.showInputDialog(null, "Informe o código: ", "Código", 
				        JOptionPane.INFORMATION_MESSAGE);
		String nome   = JOptionPane.showInputDialog(null, "Informe o nome: ", "Nome", 
				        JOptionPane.INFORMATION_MESSAGE);
		String dtNascimento = JOptionPane.showInputDialog(null,"Informa a data de nascimento: ", 
				         "Data Nascimento", JOptionPane.INFORMATION_MESSAGE);
		//Chamei o construtor da classe Pessoa
		this.person = new Pessoa(codigo, nome, dtNascimento);
		//Chamando o método para cadastrar no banco
		String msg = this.dao.inserir(this.person);
		JOptionPane.showMessageDialog(null, msg, "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		//Tentar a confirmação do cadastro
		try {
			String mensagem = "" + JOptionPane.showConfirmDialog(null,"Confirma o cadastro?",
					               "Não", JOptionPane.NO_OPTION);
			//Validação da mensagem
			if(mensagem.equals("0")) {
				JOptionPane.showMessageDialog(null, "Código: " + codigo + " Cadastrado com sucesso!",
						                      "Confirmação Cadastro", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Não Cadastrado", "ERRO", JOptionPane.WARNING_MESSAGE);
			}
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
		}//fim do catch
	}//fim do cadastrarTela
	
	public void ConsultarBanco() {
		JOptionPane.showMessageDialog(null, this.dao.listar(), "Consultar", 
				                      JOptionPane.INFORMATION_MESSAGE);
	}//fim do consultarBanco
	
	public void AtualizarBanco(String codigo, String nome, String dtNascimento) {
		this.person = new Pessoa(codigo, nome, dtNascimento);
		JOptionPane.showMessageDialog(null, this.dao.atualizar(this.person), "Atualizar", 
									JOptionPane.INFORMATION_MESSAGE);
	}//fim do atualizarBanco
	
	public void ExcluirBanco(int codigo) {
		JOptionPane.showMessageDialog(null, this.dao.excluir(codigo), "Excluir", 
				                    JOptionPane.INFORMATION_MESSAGE);
	}//fim do excluir
	
	
	
	
	
}//fim da control Pessoa
