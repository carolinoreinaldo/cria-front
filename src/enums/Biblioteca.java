package enums;

public enum Biblioteca {

	JQUERY("jquery-3.3.1.min.js"),
	LODASH("lodash.js");
	
	private String nome;
	
	private Biblioteca(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return this.nome;
	}
}