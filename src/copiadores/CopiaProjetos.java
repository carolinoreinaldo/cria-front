package copiadores;

import static enums.Extensao.ZIP;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import Utils.UrlUtils;
import dto.OpcoesDto;
import enums.Projetos;
import zip.UnZip;

public class CopiaProjetos {

	private StandardCopyOption opcaoDeCopia = StandardCopyOption.REPLACE_EXISTING;
	
	private String caminhoParaSalvarZip = null;
	private UnZip unZip = null;
	private String nomeArquivoZip = null;
	
	public CopiaProjetos(OpcoesDto opcoes){
		this.nomeArquivoZip = recuperarNomeProjetoPeloNomedeExibicao(opcoes.getNomeProjeto()) + ZIP;
		this.caminhoParaSalvarZip = UrlUtils.CAMINHO_PROJETO + nomeArquivoZip;
		unZip = new UnZip();
	}
	
	public void copiarArquivos() throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(nomeArquivoZip);
		Files.copy(is, Paths.get(caminhoParaSalvarZip), opcaoDeCopia);
		unZip.unZipIt(caminhoParaSalvarZip);
		deletaZip();
	}
	
	private void deletaZip(){
		File zip = new File(caminhoParaSalvarZip);
		zip.delete();
	}
	
	private String recuperarNomeProjetoPeloNomedeExibicao(String nomeExibicao){
		return Projetos.recuperarPeloNomeDeExibicao(nomeExibicao);
	}
}