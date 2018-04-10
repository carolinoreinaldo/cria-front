package geradorconteudo;

import criador.dto.OpcoesDto;

@SuppressWarnings("unused")
public class GeraCss {

	private OpcoesDto opcoesDto;
	
	public GeraCss(OpcoesDto opcoesDto){
		this.opcoesDto = opcoesDto;
	}
	
	public String gerar() {
		final StringBuilder css = new StringBuilder();
		css.append(".*{");
		css.append("\n	margin: 0px;");
		css.append("\n	padding: 0px;");
		css.append("\n}");
		css.append("\n\n#principal{");
		css.append("\n	width: 500px;");
		css.append("\n	height: 500px;");
		css.append("\n	border: 1px solid black;");
		css.append("\n	margin: auto;");
		css.append("\n}");
		return css.toString();
	}
}