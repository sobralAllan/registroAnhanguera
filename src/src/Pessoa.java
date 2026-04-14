package src;

import java.time.LocalDate;

public class Pessoa {
	private int codigo;
	private String nome;
	private LocalDate dtNascimento;
	
	public Pessoa() {
		setCodigo(0);
		setNome("");
		setDataNascimento(LocalDate.now());
	}//fim do construtor
	
	public Pessoa(int codigo, String nome, LocalDate dtNascimento) {
		setCodigo(codigo);
		setNome(nome);
		setDataNascimento(dtNascimento);
	}//fim do construtor com parâmetros
	
	//Métodos modificadores
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}//fim do setCodigo
	
	public void setNome(String nome) {
		this.nome = nome;
	}//fim do setNome
	
	public void setDataNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}//fim do setDataNascimento
	
	public int getCodigo() {
		return this.codigo;
	}//fim do getCodigo
	
	public String getNome() {
		return this.nome;
	}//fim do getNome
	
	public LocalDate getDataNascimento() {
		return this.dtNascimento;
	}//fim do getDataNascimento
	
	
	
	
}//fim da classe
