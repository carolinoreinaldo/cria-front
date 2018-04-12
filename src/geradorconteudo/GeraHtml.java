package geradorconteudo;

import dto.OpcoesDto;
import enums.Biblioteca;

public class GeraHtml {

	private OpcoesDto opcoesDto;
	
	public GeraHtml(OpcoesDto opcoesDto){
		this.opcoesDto = opcoesDto;
	}
	
	public String gerar() {
		final StringBuilder html = new StringBuilder();
		html.append("<!doctype html>");
		html.append("\n<html>");
		html.append("\n  <head>");
		html.append("\n    <meta charset=\"utf-8\">");
		if(opcoesDto.isjQuery()) {
			html.append("\n    <script type=\"text/javascript\" src=\"js/" + Biblioteca.JQUERY + "\"></script>");
		}
		html.append("\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/" + opcoesDto.getNomeProjeto() + ".css\">");
		html.append("\n    <title>" + opcoesDto.getNomeProjeto() + "</title>");
		html.append("\n  </head>");
		html.append("\n  <body>");
		html.append("\n    <div id=\"principal\">primeira div</div>");
		html.append("\n  </body>");
		html.append("\n    <script type=\"text/javascript\" src=\"js/" + opcoesDto.getNomeProjeto() + ".js\"></script>");
		html.append("\n</html>");
		return html.toString();
	}
}