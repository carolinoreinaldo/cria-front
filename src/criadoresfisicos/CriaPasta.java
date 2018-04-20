package criadoresfisicos;

import java.io.File;

import Utils.UrlUtils;
import dto.OpcoesDto;

public class CriaPasta {

	public void criarPastas(OpcoesDto opcoes) {
		criarPasta(UrlUtils.CAMINHO_PROJETO + opcoes.getNomeProjeto());
		criarPasta(UrlUtils.urlPastaJs(opcoes));
		criarPasta(UrlUtils.urlPastaCss(opcoes));
	}
	
	public void criarPasta(String caminhoPasta){
		final File pasta = new File(caminhoPasta);
		if(!pasta.exists()) {
			pasta.mkdir();
		}
	}
}