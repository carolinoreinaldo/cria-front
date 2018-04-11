package criadoresfisicos;

public class CriaCss extends CriaArquivo{

	@Override
	public String recuperarUrl(String nomeArquivo) {
		return DIRETORIO_ATUAL + BAR + nomeArquivo + BAR + "css" + BAR + nomeArquivo +".css";
	}
}