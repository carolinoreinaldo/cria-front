package geradorconteudo;

import java.io.IOException;

import criadoresfisicos.CopiaBibliotecas;
import criadoresfisicos.CopiaProjetos;
import criadoresfisicos.CriaCss;
import criadoresfisicos.CriaHtml;
import criadoresfisicos.CriaJS;
import criadoresfisicos.CriaPasta;
import dto.OpcoesDto;

public class MontaAmbiente {

	public boolean montar(OpcoesDto opcoes) throws IOException {
		if(opcoes.isProjetoProntoSelecionado()){
			new CopiaProjetos(opcoes).copiarArquivos();
			return true;
		}
		
		final String conteudoHtml = new GeraHtml(opcoes).gerar();
		final String conteudoJS = new GeraJS(opcoes).gerar();
		final String conteudoCss = new GeraCss(opcoes).gerar();
		
		CriaPasta criadorPasta = new CriaPasta();
		criadorPasta.criarPastas(opcoes.getNomeProjeto());
		
		new CriaHtml().gravarEmArquivo(conteudoHtml, opcoes);
		new CriaJS().gravarEmArquivo(conteudoJS, opcoes);
		new CriaCss().gravarEmArquivo(conteudoCss, opcoes);
		
		new CopiaBibliotecas(opcoes).copiarArquivos();
		
		return true;
	}
}