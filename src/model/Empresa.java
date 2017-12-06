package model;

public class Empresa {
	
	private int id;
	private String razaoSocial;
	
	public Empresa() {
		
	}
	
	public Empresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public Empresa(int id, String razaoSocial) {
		this.id = id;
		this.razaoSocial = razaoSocial;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razao_social) {
		this.razaoSocial = razao_social;
	}

}
