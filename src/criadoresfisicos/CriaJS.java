package criadoresfisicos;

public class CriaJS extends CriaArquivo {

	@Override
	public String recuperarUrl(String nomeArquivo) {
		return DIRETORIO_ATUAL + BAR + nomeArquivo + BAR + "js" + BAR + nomeArquivo +".js";
	}
}