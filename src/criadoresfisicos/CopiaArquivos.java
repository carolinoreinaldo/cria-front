package criadoresfisicos;

import java.io.File;
import java.io.IOException;

import dto.OpcoesDto;
import static enums.Biblioteca.JQUERY;

public class CopiaArquivos {

	private static final String BAR = String.valueOf(File.separatorChar);
	private static final String BIBLIOTECAS = BAR + "bibliotecas" + BAR;
	
	private OpcoesDto opcoes = null;
	private Copia copia = null;
	private String caminhoOrigem = null;
	private String caminhoDestino = null;
	
	public CopiaArquivos(OpcoesDto opcoes) {
		this.opcoes = opcoes;
		this.copia = new Copia();
		this.caminhoOrigem = new File("").getAbsolutePath() + BAR; 
		this.caminhoDestino = new File("").getAbsolutePath() + BAR + opcoes.getNomeProjeto() + BAR;
	}
	
	public void copiarArquivos() throws IOException {
		if(opcoes.isjQuery()) {
			caminhoOrigem = caminhoOrigem + BIBLIOTECAS + JQUERY;
			caminhoDestino = caminhoDestino + "js" + BAR + "jquery-3.3.1.min.js";
			copia.copyFile(new File(caminhoOrigem), new File(caminhoDestino));
		}
	}
}
