package criadoresfisicos;

import java.io.File;
import java.io.IOException;

import dto.OpcoesDto;

public class CopiaProjetos {

	private static final String BAR = String.valueOf(File.separatorChar);
	private static final String PROJETOS = BAR + "projetos" + BAR;
	
	private CopiaPasta copia = null;
	private String caminhoOrigem = null;
	private String caminhoDestino = null;
	
	public CopiaProjetos(OpcoesDto opcoes){
		this.copia = new CopiaPasta();
		this.caminhoOrigem = new File("").getAbsolutePath() + BAR + PROJETOS + BAR + opcoes.getNomeProjeto(); 
		this.caminhoDestino = new File("").getAbsolutePath() + BAR + opcoes.getNomeProjeto() + BAR;
	}
	
	public void copiarArquivos() throws IOException {
		copia.copiaPasta(new File(caminhoOrigem), new File(caminhoDestino));
	}
}
