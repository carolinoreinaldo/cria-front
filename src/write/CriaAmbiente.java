package write;

import geradorconteudo.GeraCss;
import geradorconteudo.GeraHtml;
import geradorconteudo.GeraJS;

import java.io.IOException;

import view.RecuperarOpcoes;
import criador.dto.OpcoesDto;

public class CriaAmbiente {

	public static void main(String[] args) throws IOException {
		OpcoesDto opcoes = new RecuperarOpcoes().recuperar();
		
		final String conteudoHtml = new GeraHtml(opcoes).gerar();
		final String conteudoJS = new GeraJS(opcoes).gerar();
		final String conteudoCss = new GeraCss(opcoes).gerar();
		
		CriaArquivo criadorArquivo = new CriaArquivo();
		criadorArquivo.criaDiretorioBase(opcoes.getNomeProjeto());
		criadorArquivo.criaArquivoFisico(opcoes.getNomeProjeto(), conteudoHtml, "html");
		criadorArquivo.criaArquivoFisico(opcoes.getNomeProjeto(), conteudoJS, "js");
		criadorArquivo.criaArquivoFisico(opcoes.getNomeProjeto(), conteudoCss, "css");
	}
}