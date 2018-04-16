package gui;

public class TelaAjuda extends Mensagem {

	private static final long serialVersionUID = 1L;

	@Override
	protected String recuperarTitulo() {
		return "----Ajuda----";
	}

	@Override
	public String recuperarMensagem() {
		StringBuilder ajuda = new StringBuilder();
		ajuda.append("");
		ajuda.append("  Essa ferramenta cria um ambiente Front-End básico");
		ajuda.append("\n  no seguinte formato:");
		ajuda.append("\n");
		ajuda.append("\n  projeto");
		ajuda.append("\n  -projeto.html");
		ajuda.append("\n  -css/projeto.css");
		ajuda.append("\n  -js/projeto.js");
		ajuda.append("\n");
		ajuda.append("\n  PROJETOS PRONTOS");
		ajuda.append("\n  Você também pode gerar projetos prontos ");
		ajuda.append("\n  escolhendo projetos no combo 'Projetos Prontos'");
		ajuda.append("\n  e clicando clicando no botão 'criar'");
		return ajuda.toString();
	}
}