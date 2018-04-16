import java.io.IOException;

import criadoresfisicos.CopiaProjetos;
import dto.OpcoesDto;

public class CopiaProjetosTeste {

	public static void main(String[] args) throws IOException {
		new CopiaProjetosTeste().teste();
	}
	
	public void teste() throws IOException {
		OpcoesDto opcoes = new OpcoesDto();
		opcoes.setNomeProjeto("cadastro-simples");
		new CopiaProjetos(opcoes).copiarArquivos();
	}
}