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
	private StandardCopyOption opcaoDeCopia = StandardCopyOption.REPLACE_EXISTING;
	
	private String caminhoParaSalvarZip = null;
	private String pastaParaDescompactarZip = null;
	private OpcoesDto opcoes = null;
	private UnZip unZip = null;
	
	public CopiaProjetos(OpcoesDto opcoes){
		String pastaAtual = new File("").getAbsolutePath() + BAR;
		this.caminhoParaSalvarZip = pastaAtual + opcoes.getNomeProjeto() + ".zip";
		this.pastaParaDescompactarZip = pastaAtual + opcoes.getNomeProjeto();
		this.opcoes = opcoes;
		unZip = new UnZip();
	}
	
	public void copiarArquivos() throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(opcoes.getNomeProjeto() +  ".zip");
		Files.copy(is, Paths.get(caminhoParaSalvarZip), opcaoDeCopia);
		unZip.unZipIt(caminhoParaSalvarZip, pastaParaDescompactarZip);
		deletaZip();
	}
	
	private void deletaZip(){
		File zip = new File(caminhoParaSalvarZip);
		zip.delete();
	}
}