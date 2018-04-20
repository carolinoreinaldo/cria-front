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
	private CopiaJS copiaJS = null;
	
	public MontaAmbiente(OpcoesDto opcoes) {
		this.geraJS = new GeraJS(opcoes);
		this.geraCss = new GeraCss(opcoes);
		this.opcoes = opcoes;
		this.copiaProjetos = new CopiaProjetos(opcoes);
		this.criaPasta = new CriaPasta();
		this.copiaJS = new CopiaJS(opcoes);
	}
	
	public boolean montar() throws IOException {
		if(opcoes.isProjetoProntoSelecionado()){
			copiaProjetos.copiarArquivos();
			return true;
		}
		
		criaPasta.criarPastas(opcoes);
		
		final ArquivoDto[] arquivosJs = prepararArquivosJs();
		criarArquivosJs(arquivosJs);
		
		final ArquivoDto[] arquivosCss = prepararArquivosCss();
		criarArquivosCss(arquivosCss);
		
		
		GeraHtml geraHtml = new GeraHtml(opcoes, arquivosCss, arquivosJs);
		
		final ArquivoDto[] arquivosHtml = prepararArquivosHtml(geraHtml);
		criarArquivosHtml(arquivosHtml);
		
		copiaJS.copiarBibliotecas();
		
		return true;
	}

	private ArquivoDto[] prepararArquivosHtml(GeraHtml geraHtml) {
		final ArquivoDto[] arquivosHtml = {
				new ArquivoDto("index", geraHtml.gerar(), Extensao.HTML)
		};
		return arquivosHtml;
	}

	private ArquivoDto[] prepararArquivosJs() {
		final ArquivoDto[] arquivosJs = {
				new ArquivoDto("index", geraJS.gerar(), Extensao.JS)
		};
		return arquivosJs;
	}

	private ArquivoDto[] prepararArquivosCss() {
		final ArquivoDto[] arquivosCss = {
				new ArquivoDto("index", geraCss.gerarIndex(), Extensao.CSS),
				new ArquivoDto("reset", geraCss.gerarReset(), Extensao.CSS)
		};
		return arquivosCss;
	}
	
	private void criarArquivosHtml(ArquivoDto... arquivos) {
		for (ArquivoDto arquivo : arquivos) {
			final CriaHtml criaHtml = new CriaHtml(arquivo, opcoes);
			criaHtml.gravarEmArquivo();
		}
	}
	
	private void criarArquivosJs(ArquivoDto... arquivos) {
		for (ArquivoDto arquivo : arquivos) {
			final CriaJS criaJs = new CriaJS(arquivo, opcoes);
			criaJs.gravarEmArquivo();
		}
	}
	
	private void criarArquivosCss(ArquivoDto... arquivos) {
		for (ArquivoDto arquivo : arquivos) {
			final CriaCss criaCss = new CriaCss(arquivo, opcoes);
			criaCss.gravarEmArquivo();
		}
	}
}