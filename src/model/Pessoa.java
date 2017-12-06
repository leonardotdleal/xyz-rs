package model;

import java.sql.Date;

public abstract class Pessoa {

	private int id;
	private int cpf;
	private String nome;
	private Date dataNascimento;
	//public int estadocivil
	//grauinstrucao
	//private String naturalidade;
	
	public Pessoa() {
	}
	
	public Pessoa(int id, int cpf, String nome, Date dataNascimento) {
		this.id = id;
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
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
	
}
