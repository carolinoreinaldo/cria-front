package criadoresfisicos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import dto.OpcoesDto;
import enums.Biblioteca;

public class CopiaBibliotecas {

	private static final String BAR = String.valueOf(File.separatorChar);
	
	private OpcoesDto opcoes = null;
	private String pastaJs = null;
	
	public CopiaBibliotecas(OpcoesDto opcoes) {
		this.opcoes = opcoes;
		this.pastaJs = new File("").getAbsolutePath() + BAR + opcoes.getNomeProjeto() + BAR + "js" + BAR;
	}
	
	public void copiar() throws IOException {
		if(opcoes.isjQuery()) {
			InputStream jquery = getClass().getClassLoader().getResourceAsStream(Biblioteca.JQUERY.toString());
			copiar(jquery, pastaJs + Biblioteca.JQUERY.toString());
		}
		
		if(opcoes.isLodash()) {
			InputStream lodash = getClass().getClassLoader().getResourceAsStream(Biblioteca.LODASH.toString());
			copiar(lodash, pastaJs + Biblioteca.LODASH.toString());
		}
	}

	private void copiar(InputStream origem, String destino) throws IOException {
		Files.copy(origem, Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
	}
}