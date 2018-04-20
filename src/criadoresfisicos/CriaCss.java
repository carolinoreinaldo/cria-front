package criadoresfisicos;

import Utils.UrlUtils;
import dto.ArquivoDto;
import dto.OpcoesDto;

public class CriaCss extends CriaArquivo {

	public CriaCss(ArquivoDto arquivo, OpcoesDto opcoes) {
		super(arquivo, opcoes);
	}

	@Override
	public String recuperarUrl() {
		return UrlUtils.urlCss(opcoes, arquivo.getNomeArquivo());
	}
}