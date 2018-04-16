package enums;

public enum JavaScript {

	JQUERY("jquery-3.3.1.min.js"),
	LODASH("lodash.js");
	
	private String nome;
	
	private JavaScript(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return this.nome;
	}
}