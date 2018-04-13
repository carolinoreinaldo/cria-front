package criadoresfisicos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import dto.OpcoesDto;

public class CopiaProjetos {

	private static final String BAR = String.valueOf(File.separatorChar);
	
	private String caminhoParaSalvarZip = null;
	private String pastaParaDescompactarZip = null;
	private OpcoesDto opcoes;
	
	public CopiaProjetos(OpcoesDto opcoes){
		this.caminhoParaSalvarZip = new File("").getAbsolutePath() + BAR + opcoes.getNomeProjeto() + ".zip";
		this.pastaParaDescompactarZip = new File("").getAbsolutePath() + BAR + opcoes.getNomeProjeto();
		this.opcoes = opcoes;
	}
	
	public void copiarArquivos() throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(opcoes.getNomeProjeto() +  ".zip");
		Files.copy(is, Paths.get(caminhoParaSalvarZip), StandardCopyOption.REPLACE_EXISTING);
		new UnZip().unZipIt(caminhoParaSalvarZip, pastaParaDescompactarZip);
		deletaZip();
	}
	
	private void deletaZip(){
		File zip = new File(caminhoParaSalvarZip);
		zip.delete();
	}
}