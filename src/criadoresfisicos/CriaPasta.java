package criadoresfisicos;

import java.io.File;

public class CriaPasta {

	final private static String DIRETORIO_ATUAL = new File("").getAbsolutePath();
	final private static String BAR = String.valueOf(File.separatorChar);
	
	public void criarPastas(String nomeProjeto) {
		criarPasta(DIRETORIO_ATUAL + BAR + nomeProjeto);
		criarPasta(DIRETORIO_ATUAL + BAR + nomeProjeto + BAR + "js");
		criarPasta(DIRETORIO_ATUAL + BAR + nomeProjeto + BAR + "css");
	}
	
	public void criarPasta(String caminhoPasta){
		final File pasta = new File(caminhoPasta);
		if(!pasta.exists()) {
			pasta.mkdir();
		}
	}
}