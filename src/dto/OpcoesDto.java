package dto;

public class OpcoesDto {
	
	private String nomeProjeto;
	private boolean jQuery;
	private boolean bootstrap;
	private boolean lodash;
	private boolean projetoProntoSelecionado;
	
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	public boolean isjQuery() {
		return jQuery;
	}
	public void setjQuery(boolean jQuery) {
		this.jQuery = jQuery;
	}
	public boolean isBootstrap() {
		return bootstrap;
	}
	public void setBootstrap(boolean bootstrap) {
		this.bootstrap = bootstrap;
	}
	public boolean isLodash() {
		return lodash;
	}
	public void setLodash(boolean lodash) {
		this.lodash = lodash;
	}
	public boolean isProjetoProntoSelecionado() {
		return projetoProntoSelecionado;
	}
	public void setProjetoProntoSelecionado(boolean projetoProntoSelecionado) {
		this.projetoProntoSelecionado = projetoProntoSelecionado;
	}
}