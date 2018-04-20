package copiadores;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import Utils.UrlUtils;
import dto.OpcoesDto;
import enums.JavaScript;

public class CopiaJS {
	
	private OpcoesDto opcoes = null;
	
	public CopiaJS(OpcoesDto opcoes) {
		this.opcoes = opcoes;
	}
	
	public void copiar() throws IOException {
		if(opcoes.isjQuery()) {
			InputStream jquery = getClass().getClassLoader().getResourceAsStream(JavaScript.JQUERY.toString());
			copiar(jquery, UrlUtils.urlJs(opcoes, JavaScript.JQUERY.toString()));
		}
		
		if(opcoes.isLodash()) {
			InputStream lodash = getClass().getClassLoader().getResourceAsStream(JavaScript.LODASH.toString());
			copiar(lodash, UrlUtils.urlJs(opcoes, JavaScript.LODASH.toString()));
		}
	}

	private void copiar(InputStream origem, String destino) throws IOException {
		Files.copy(origem, Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
	}
}