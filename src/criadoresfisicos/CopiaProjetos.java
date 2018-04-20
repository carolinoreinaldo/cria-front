package criadoresfisicos;

import static enums.Extensao.ZIP;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import Utils.UrlUtils;
import dto.OpcoesDto;

public class CopiaProjetos {

	private StandardCopyOption opcaoDeCopia = StandardCopyOption.REPLACE_EXISTING;
	
	private String caminhoParaSalvarZip = null;
	private String pastaParaDescompactarZip = null;
	private OpcoesDto opcoes = null;
	private UnZip unZip = null;
	
	public CopiaProjetos(OpcoesDto opcoes){
		this.caminhoParaSalvarZip = UrlUtils.CAMINHO_PROJETO + opcoes.getNomeProjeto() + ZIP;
		this.pastaParaDescompactarZip = UrlUtils.CAMINHO_PROJETO + opcoes.getNomeProjeto();
		this.opcoes = opcoes;
		unZip = new UnZip();
	}
	
	public void copiarArquivos() throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(opcoes.getNomeProjeto() +  ZIP);
		Files.copy(is, Paths.get(caminhoParaSalvarZip), opcaoDeCopia);
		unZip.unZipIt(caminhoParaSalvarZip, pastaParaDescompactarZip);
		deletaZip();
	}
	
	private void deletaZip(){
		File zip = new File(caminhoParaSalvarZip);
		zip.delete();
	}
}