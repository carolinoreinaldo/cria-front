package geradorconteudo;

import dto.OpcoesDto;

public class GeraJS {

	private OpcoesDto opcoes;
	
	public GeraJS(OpcoesDto opcoes){
		this.opcoes = opcoes;
	}
	
	public String gerar(){
		if(opcoes.isjQuery()){
			return gerarComJQuery();
		} else {
			return gerarJSPuro();
		}
	}
	
	private String gerarComJQuery(){
		return "";
	}
	
	private String gerarJSPuro() {
		final StringBuilder js = new StringBuilder();
		js.append("var message = () => {");
		js.append("\n	alert('Ambiente carregado com sucesso');");
		js.append("\n}");
		js.append("\n");
		js.append("\nmessage()");
		return js.toString();
	}
}