package model;

public class Candidato extends Pessoa {
	
	private float pretensaoSalariao;
	
	public Candidato(float pretensaoSalariao) {
		super();
		this.pretensaoSalariao = pretensaoSalariao;
	}

	public float getPretensaoSalariao() {
		return pretensaoSalariao;
	}

	public void setPretensaoSalariao(float pretensaoSalariao) {
		this.pretensaoSalariao = pretensaoSalariao;
	}

}
