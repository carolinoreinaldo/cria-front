package enums;

public enum Projetos {

	NENHUM_PROJETO("Nehum Projeto", ""),
	CADASTRO_SIMPLES("cadastro-simples","[Html+js+css]");
	
	private String nomeProjeto;
	private String linguagem;
	
	private Projetos(String nomeProjeto, String linguagem){
		this.nomeProjeto = nomeProjeto;
		this.linguagem = linguagem;
	}
	
	public String nomeParaExibicao(){
		return this.nomeProjeto + this.linguagem; 
	}
	public String linguagem() {
		return this.linguagem;
	}
	
	public String toString(){
		return this.nomeProjeto;
	}

	public static String recuperarPeloNomeDeExibicao(String nomeExibicao) {
		for (Projetos projeto : Projetos.values()) {
			if(projeto.nomeParaExibicao().equals(nomeExibicao)){
				return projeto.toString();
			}
		}
		return null;
	}
}