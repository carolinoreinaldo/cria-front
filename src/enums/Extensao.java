package enums;

public enum Extensao {

	HTML(".html"),
	JS(".js"),
	CSS(".css"),
	ZIP(".zip");
	
	private String extensao;
	
	private Extensao(String extensao) {
		this.extensao = extensao;
	}
	
	public String toString() {
		return this.extensao;
	}
}