package registro;

import java.time.LocalDate;

public class Pessoa {
	private int codigo;
	private String nome;
	private LocalDate dtNascimento;
	private String cod;
	private String data;
	
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
	
	public Pessoa(int codigo, String nome, String dtNascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.data = dtNascimento;
	}//fim do método
	
	public String getCod() {
		return this.cod;
	}//fim do getCod
	
	public void setCod(String codigo) {
		this.cod = codigo;
	}//fim do set
	
	public String getData() {
		return this.data;
	}//fim do data
	
	public void setData(String data) {
		this.data = data;
	}//fim do setData
	
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
