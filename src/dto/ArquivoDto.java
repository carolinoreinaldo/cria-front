package dto;

import enums.Extensao;

public class ArquivoDto {

	private String nomeArquivo;
	private String conteudoArquivo;
	private Extensao extensao;
	
	public ArquivoDto(String nomeArquivo, String conteudoArquivo, Extensao extensao) {
		this.nomeArquivo = nomeArquivo;
		this.conteudoArquivo = conteudoArquivo;
		this.extensao = extensao;
	}

	public ArquivoDto(){}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public String getConteudoArquivo() {
		return conteudoArquivo;
	}
	public void setConteudoArquivo(String conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}
	public Extensao getExtensao() {
		return extensao;
	}
	public void setExtensao(Extensao extensao) {
		this.extensao = extensao;
	}
}