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
	
	public void copiarArquivos() throws IOException {
		if(opcoes.isjQuery()) {
			InputStream is = getClass().getClassLoader().getResourceAsStream(Biblioteca.JQUERY.toString());
			Files.copy(is, Paths.get(pastaJs + Biblioteca.JQUERY.toString()), StandardCopyOption.REPLACE_EXISTING);
		}
		
		if(opcoes.isLodash()) {
			InputStream isLodash = getClass().getClassLoader().getResourceAsStream(Biblioteca.LODASH.toString());
			Files.copy(isLodash, Paths.get(pastaJs + Biblioteca.LODASH.toString()), StandardCopyOption.REPLACE_EXISTING);
		}
	}
}