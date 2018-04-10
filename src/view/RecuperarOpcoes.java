package view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import criador.dto.OpcoesDto;

public class RecuperarOpcoes {

	private static final int CANCELAR = 2;
	
	public static void main(String[] args) {
		new RecuperarOpcoes().recuperar();
	}
	
	public OpcoesDto recuperar() {
		OpcoesDto opcoes = null;
		boolean continuaPerguntando = true;
		
		while(continuaPerguntando){
			JTextField nomeProjeto = new JTextField(20);
	
			JPanel panel = new JPanel();
			Border border = BorderFactory.createTitledBorder("Projeto");
			panel.setBorder(border);
			
			panel.add(new JLabel("Nome do Projeto:"));
			panel.add(nomeProjeto);
			panel.add(Box.createHorizontalStrut(15));
			
			JCheckBox jQuery = new JCheckBox("jQuery");
			panel.add(jQuery);
			
			int okCancelar = JOptionPane.showConfirmDialog(null,  panel, "texto", JOptionPane.OK_CANCEL_OPTION);
			
			if(CANCELAR == okCancelar){
				break;
			}
			
			if(nomeProjeto.getText() == null || nomeProjeto.getText().trim().isEmpty()){
				continuaPerguntando = true;
			} else {
				opcoes = new OpcoesDto();
				opcoes.setNomeProjeto(nomeProjeto.getText());
				opcoes.setjQuery(jQuery.isSelected());
				continuaPerguntando = false;
			}
		}
		return opcoes;
	}
}