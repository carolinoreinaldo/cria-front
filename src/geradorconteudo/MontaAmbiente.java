package geradorconteudo;

import java.io.IOException;

import criadoresfisicos.CopiaJS;
import criadoresfisicos.CopiaProjetos;
import criadoresfisicos.CriaCss;
import criadoresfisicos.CriaHtml;
import criadoresfisicos.CriaJS;
import criadoresfisicos.CriaPasta;
import dto.OpcoesDto;

public class MontaAmbiente {

	private CriaHtml criaHtml = null;
	private CriaJS criaJS = null;
	private CriaCss criaCss = null;
	private OpcoesDto opcoes;
	private GeraHtml geraHtml = null;
	private GeraJS geraJS = null;
	private GeraCss geraCss = null;
	private CopiaProjetos copiaProjetos = null;
	private CriaPasta criaPasta = null;
	
	public MontaAmbiente(OpcoesDto opcoes) {
		this.criaHtml = new CriaHtml();
		this.criaJS = new CriaJS();
		this.criaCss = new CriaCss();
		this.geraHtml = new GeraHtml(opcoes);
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
		
		criaPasta.criarPastas(opcoes.getNomeProjeto());
		
		criaHtml.gravarEmArquivo(geraHtml.gerar(), opcoes);
		criaJS.gravarEmArquivo(geraJS.gerar(), opcoes);
		criaCss.gravarEmArquivo(geraCss.gerar(), opcoes);
		
		new CopiaJS(opcoes).copiar();
		
		return true;
	}
}