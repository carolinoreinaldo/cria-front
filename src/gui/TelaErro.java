package gui;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TelaErro extends Mensagem {

	private String mensagemErro;
	
	public TelaErro(Exception e) {
	   StringWriter sw = new StringWriter();
	   PrintWriter pw = new PrintWriter(sw);
	   e.printStackTrace(pw);
	   this.mensagemErro = sw.toString();
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	protected String recuperarTitulo() {
		return "ERRO";
	}

	@Override
	public String recuperarMensagem() {
		return this.mensagemErro;
	}
}