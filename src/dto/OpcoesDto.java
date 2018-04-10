package dto;

public class OpcoesDto {
	
	private String nomeProjeto;
	private boolean jQuery;
	private boolean cancelar;
	
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
	public boolean isCancelar() {
		return cancelar;
	}
	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}
}