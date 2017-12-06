package model;

import java.sql.Date;

public abstract class Pessoa {

	private int id;
	private String cpf;
	private String nome;
	private String dataNascimento;
	//public int estadocivil
	//grauinstrucao
	//private String naturalidade;
	
	public Pessoa() {
	}
	
	public Pessoa(String cpf, String nome, String dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
		
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
	
}
