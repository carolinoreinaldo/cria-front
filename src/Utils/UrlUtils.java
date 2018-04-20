package Utils;

import java.io.File;

import dto.OpcoesDto;
import enums.Extensao;

public class UrlUtils {

	public static final String BAR = String.valueOf(File.separatorChar);
	public static final String CAMINHO_PROJETO = new File("").getAbsolutePath() + BAR;
	public static final String CAMINHO_PROJETOS_PRONTOS = new File("").getAbsolutePath() + BAR + "projetos" + BAR;
	
	public static String urlJs(OpcoesDto opcoes, String nomeArquivo) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + "js" + BAR + nomeArquivo + Extensao.JS;
	}
	
	public static String urlJs(OpcoesDto opcoes, String nomeArquivo, Extensao extensao) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + "js" + BAR + nomeArquivo + extensao;
	}
	
	public static String urlCss(OpcoesDto opcoes, String nomeArquivo) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + "css" + BAR + nomeArquivo + Extensao.CSS;
	}
	
	public static String urlCss(OpcoesDto opcoes, String nomeArquivo, Extensao extensao) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + "css" + BAR + nomeArquivo + extensao;
	}
	
	public static String urlHtml(OpcoesDto opcoes, String nomeArquivo) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + nomeArquivo + Extensao.HTML;
	}
	
	public static String urlHtml(OpcoesDto opcoes, String nomeArquivo, Extensao extensao) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + nomeArquivo + extensao;
	}
	
	public static String urlPastaCss(OpcoesDto opcoes) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + "css" + BAR;
	}
	
	public static String urlPastaJs(OpcoesDto opcoes) {
		return CAMINHO_PROJETO + opcoes.getNomeProjeto() + BAR + "js" + BAR;
	}
}