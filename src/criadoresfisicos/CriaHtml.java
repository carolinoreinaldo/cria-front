package criadoresfisicos;

import enums.Extensao;
import static constantes.Constantes.CAMINHO_PROJETO;
import static constantes.Constantes.BAR;

public class CriaHtml extends CriaArquivo {

	@Override
	public String recuperarUrl(String nomeArquivo) {
		return CAMINHO_PROJETO + nomeArquivo + BAR + nomeArquivo + Extensao.HTML;
	}
}