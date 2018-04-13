package enums;

public enum Projetos {

	NENHUM_PROJETO("Nehum Projeto"),
	CADASTRO_SIMPLES("cadastro-simples");
	
	private String nomeProjeto;
	
	private Projetos(String nomeProjeto){
		this.nomeProjeto = nomeProjeto;
	}
	
	public String toString(){
		return this.nomeProjeto;
	}
}