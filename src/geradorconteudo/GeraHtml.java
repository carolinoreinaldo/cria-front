package geradorconteudo;

import dto.ArquivoDto;
import dto.OpcoesDto;
import enums.JavaScript;

public class GeraHtml {

	private OpcoesDto opcoesDto;
	private ArquivoDto[] arquivosCss;
	private ArquivoDto[] arquivosJs;
	
	public GeraHtml(OpcoesDto opcoesDto, ArquivoDto[] arquivosCss, ArquivoDto[] arquivosJs){
		this.opcoesDto = opcoesDto;
		this.arquivosCss = arquivosCss;
		this.arquivosJs = arquivosJs;
	}
	
	public String gerar() {
		final StringBuilder html = new StringBuilder();
		html.append("<!doctype html>");
		html.append("\n<html>");
		html.append("\n  <head>");
		html.append("\n    <meta charset=\"utf-8\">");
		if(opcoesDto.isjQuery()) {
			html.append("\n    <script type=\"text/javascript\" src=\"js/" + JavaScript.JQUERY + "\"></script>");
		}
		if(opcoesDto.isLodash()) {
			html.append("\n    <script type=\"text/javascript\" src=\"js/" + JavaScript.LODASH + "\"></script>");
		}
		for (ArquivoDto css : arquivosCss) {
			html.append("\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/" + css.getNomeArquivo() + ".css\">");
		}
		html.append("\n    <title>" + opcoesDto.getNomeProjeto() + "</title>");
		html.append("\n  </head>");
		html.append("\n  <body>");
		html.append("\n    <div id=\"principal\">primeira div</div>");
		html.append("\n  </body>");
		for (ArquivoDto js : arquivosJs) {
			html.append("\n    <script type=\"text/javascript\" src=\"js/" + js.getNomeArquivo() + ".js\"></script>");
		}
		html.append("\n</html>");
		return html.toString();
	}
}