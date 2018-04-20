package geradorconteudo;

import java.io.IOException;

import copiadores.CopiaJS;
import copiadores.CopiaProjetos;
import criadoresfisicos.CriaCss;
import criadoresfisicos.CriaHtml;
import criadoresfisicos.CriaJS;
import criadoresfisicos.CriaPasta;
import dto.ArquivoDto;
import dto.OpcoesDto;
import enums.Extensao;

public class MontaAmbiente {

	private OpcoesDto opcoes;
	private GeraJS geraJS = null;
	private GeraCss geraCss = null;
	private CopiaProjetos copiaProjetos = null;
	private CriaPasta criaPasta = null;
	
	public MontaAmbiente(OpcoesDto opcoes) {
		this.geraJS = new GeraJS(opcoes);
		this.geraCss = new GeraCss(opcoes);
		this.opcoes = opcoes;
		this.copiaProjetos = new CopiaProjetos(opcoes);
		this.criaPasta = new CriaPasta();
	}
	
	public boolean montar() throws IOException {
		if(opcoes.isProjetoProntoSelecionado()){
			copiaProjetos.copiarArquivos();
			return true;
		}
		
		criaPasta.criarPastas(opcoes);
		
		final ArquivoDto[] arquivosJs = {
				new ArquivoDto("index", geraJS.gerar(), Extensao.JS)
		};
		
		criaJs(arquivosJs);
		
		final ArquivoDto[] arquivosCss = {
				new ArquivoDto("index", geraCss.gerarIndex(), Extensao.CSS),
				new ArquivoDto("reset", geraCss.gerarReset(), Extensao.CSS)
		};
		
		criaCss(arquivosCss);
		
		new CopiaJS(opcoes).copiar();
		
		GeraHtml geraHtml = new GeraHtml(opcoes, arquivosCss, arquivosJs);
		
		final ArquivoDto[] arquivosHtml = {
				new ArquivoDto("index", geraHtml.gerar(), Extensao.HTML)
		};
		
		criaHtml(arquivosHtml);
		
		return true;
	}
	
	private void criaHtml(ArquivoDto... arquivos) {
		for (ArquivoDto arquivo : arquivos) {
			final CriaHtml criaHtml = new CriaHtml(arquivo, opcoes);
			criaHtml.gravarEmArquivo();
		}
	}
	
	private void criaJs(ArquivoDto... arquivos) {
		for (ArquivoDto arquivo : arquivos) {
			final CriaJS criaJs = new CriaJS(arquivo, opcoes);
			criaJs.gravarEmArquivo();
		}
	}
	
	private void criaCss(ArquivoDto... arquivos) {
		for (ArquivoDto arquivo : arquivos) {
			final CriaCss criaCss = new CriaCss(arquivo, opcoes);
			criaCss.gravarEmArquivo();
		}
	}
}