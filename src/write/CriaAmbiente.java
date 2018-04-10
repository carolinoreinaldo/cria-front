package write;

import java.io.IOException;

import javax.swing.JOptionPane;

public class CriaAmbiente {

	public static void main(String[] args) throws IOException {
		final String nomeProjeto = extrairNomeProjeto();
		final String conteudoHtml = criarConteudoHtml(nomeProjeto);
		final String conteudoJS = criarConteudoJS();
		final String conteudoCss = criarConteudoCss();
		
		CriaArquivo criadorArquivo = new CriaArquivo();
		criadorArquivo.criaDiretorioBase(nomeProjeto);
		criadorArquivo.criaArquivoFisico(nomeProjeto, conteudoHtml, "html");
		criadorArquivo.criaArquivoFisico(nomeProjeto, conteudoJS, "js");
		criadorArquivo.criaArquivoFisico(nomeProjeto, conteudoCss, "css");
	}

	private static String extrairNomeProjeto() {
		final String nomeProjeto = JOptionPane.showInputDialog("Digite o nome do projeto");
		return nomeProjeto;
	}

	private static String criarConteudoHtml(final String nomeArquivo) {
		final StringBuilder html = new StringBuilder();
		html.append("<!doctype html>");
		html.append("\n<html>");
		html.append("\n  <head>");
		html.append("\n    <meta charset=\"utf-8\">");
		html.append("\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"" + nomeArquivo + ".css\">");
		html.append("\n    <script type=\"text/javascript\" src=\"" + nomeArquivo + ".js\"></script>");
		html.append("\n    <title>" + nomeArquivo + "</title>");
		html.append("\n  </head>");
		html.append("\n  <body>");
		html.append("\n    <div id=\"principal\">primeira div</div>");
		html.append("\n  </body>");
		html.append("\n</html>");
		return html.toString();
	}

	private static String criarConteudoJS() {
		final StringBuilder js = new StringBuilder();
		js.append("var message = () => {");
		js.append("\n	alert('Ambiente carregado com sucesso');");
		js.append("\n}");
		js.append("\n");
		js.append("\nmessage()");
		return js.toString();
	}

	private static String criarConteudoCss() {
		final StringBuilder css = new StringBuilder();
		css.append(".*{");
		css.append("\n	margin: 0px;");
		css.append("\n  padding: 0px;");
		css.append("\n}");
		css.append("\n\n#principal{");
		css.append("\n	width: 500px;");
		css.append("\n  height: 500px;");
		css.append("\n  border: 1px solid black;");
		css.append("\n  margin: auto;");
		css.append("\n}");
		return css.toString();
	}
}