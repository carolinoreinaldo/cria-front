package geradorconteudo;

import criador.dto.OpcoesDto;

public class GeraJS {

	private OpcoesDto opcoesDto;
	
	public GeraJS(OpcoesDto opcoesDto){
		this.opcoesDto = opcoesDto;
	}
	
	public String gerar(){
		if(opcoesDto.isjQuery()){
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