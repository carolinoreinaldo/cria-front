package executadores;

import gui.Tela;

public class MostraTela {

	public void mostra() {
		new Tela().criaTela();
	}
	
	public static void main(String[] args) {
		new MostraTela().mostra();
	}
}