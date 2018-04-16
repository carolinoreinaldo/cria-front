package criadoresfisicos;

import java.io.File;
import static constantes.Constantes.CAMINHO_PROJETO;
import static constantes.Constantes.BAR;

public class CriaPasta {

	public void criarPastas(String nomeProjeto) {
		criarPasta(CAMINHO_PROJETO + nomeProjeto);
		criarPasta(CAMINHO_PROJETO + nomeProjeto + BAR + "js");
		criarPasta(CAMINHO_PROJETO + nomeProjeto + BAR + "css");
	}
	
	public void criarPasta(String caminhoPasta){
		final File pasta = new File(caminhoPasta);
		if(!pasta.exists()) {
			pasta.mkdir();
		}
	}
}