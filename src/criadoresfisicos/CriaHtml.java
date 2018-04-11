package criadoresfisicos;

public class CriaHtml extends CriaArquivo {

	@Override
	public String recuperarUrl(String nomeArquivo) {
		return DIRETORIO_ATUAL + BAR + nomeArquivo + BAR + nomeArquivo +".html";
	}
}