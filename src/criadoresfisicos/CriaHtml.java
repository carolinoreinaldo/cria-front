package criadoresfisicos;

import Utils.UrlUtils;
import dto.ArquivoDto;
import dto.OpcoesDto;

public class CriaHtml extends CriaArquivo {

	public CriaHtml(ArquivoDto arquivo, OpcoesDto opcoes) {
		super(arquivo, opcoes);
	}

	@Override
	public String recuperarUrl() {
		return UrlUtils.urlHtml(opcoes, arquivo.getNomeArquivo());
	}
}