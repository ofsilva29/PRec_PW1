package enums;

public enum Situacao {
	VENDIDO(1, "VENDIDO"), DISPONIVEL(1, "DISPONIVEL"), RESERVADO(1, "RESERVADO");

	private final int id;
	private final String nome;

	private Situacao(int id, String nome){
		this.id = id;
		this.nome = nome;
	}

	public int getId(){
		return id;
	}

	public String getNome(){
		return nome;
	}
}
