package executadores;

import java.io.IOException;

import criadoresfisicos.CriaCss;
import criadoresfisicos.CriaHtml;
import criadoresfisicos.CriaJS;
import criadoresfisicos.CriaPasta;
import dto.OpcoesDto;
import geradorconteudo.GeraCss;
import geradorconteudo.GeraHtml;
import geradorconteudo.GeraJS;
import view.RecuperarOpcoes;

public class CriaAmbiente {

	public static void main(String[] args) throws IOException {
		OpcoesDto opcoes = new RecuperarOpcoes().recuperar();
		
		final String conteudoHtml = new GeraHtml(opcoes).gerar();
		final String conteudoJS = new GeraJS(opcoes).gerar();
		final String conteudoCss = new GeraCss(opcoes).gerar();
		
		CriaPasta criadorPasta = new CriaPasta();
		criadorPasta.criarPastas(opcoes.getNomeProjeto());
		
		new CriaHtml().gravarEmArquivo(conteudoHtml, opcoes);
		new CriaJS().gravarEmArquivo(conteudoJS, opcoes);
		new CriaCss().gravarEmArquivo(conteudoCss, opcoes);
	}
}