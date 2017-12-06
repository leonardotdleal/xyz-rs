package model;


public class Candidato extends Pessoa {
	
	private float pretensaoSalarial;
	
	public Candidato() {
	}
	
	public Candidato(String cpf, String nome, String dataNascimento, float pretensaoSalariao) {
		super(cpf, nome, dataNascimento);
		this.pretensaoSalarial = pretensaoSalariao;
	}

	public float getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	public void setPretensaoSalarial(float pretensaoSalariao) {
		this.pretensaoSalarial = pretensaoSalariao;
	}

}
