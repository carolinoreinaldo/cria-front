package geradorconteudo;

import java.io.IOException;

import criadoresfisicos.CopiaArquivos;
import criadoresfisicos.CriaCss;
import criadoresfisicos.CriaHtml;
import criadoresfisicos.CriaJS;
import criadoresfisicos.CriaPasta;
import dto.OpcoesDto;

public class MontaAmbiente {

	public boolean montar(OpcoesDto opcoes) throws IOException {
		final String conteudoHtml = new GeraHtml(opcoes).gerar();
		final String conteudoJS = new GeraJS(opcoes).gerar();
		final String conteudoCss = new GeraCss(opcoes).gerar();
		
		CriaPasta criadorPasta = new CriaPasta();
		criadorPasta.criarPastas(opcoes.getNomeProjeto());
		
		new CriaHtml().gravarEmArquivo(conteudoHtml, opcoes);
		new CriaJS().gravarEmArquivo(conteudoJS, opcoes);
		new CriaCss().gravarEmArquivo(conteudoCss, opcoes);
		
		new CopiaArquivos(opcoes).copiarArquivos();
		
		return true;
	}
}