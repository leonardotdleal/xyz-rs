package model;

public enum EstadoCivil {
	
	SOLTEIRO(1), CASADO(2), DIVORCIADO(3), VI�VO(4);
	
	private int valor;
	
	private EstadoCivil(int valor) {
		this.valor = valor;
	}

	public int estadoCivil() {
		return this.valor;
	}
}
