package criadoresfisicos;

import Utils.UrlUtils;
import dto.ArquivoDto;
import dto.OpcoesDto;

public class CriaJS extends CriaArquivo {

	public CriaJS(ArquivoDto arquivo, OpcoesDto opcoes) {
		super(arquivo, opcoes);
	}

	@Override
	public String recuperarUrl() {
		return UrlUtils.urlJs(opcoes, arquivo.getNomeArquivo());
	}
}