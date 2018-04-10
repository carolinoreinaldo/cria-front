package view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dto.OpcoesDto;

public class RecuperarOpcoes {

	private static final int CANCELAR = 2;
	
	public static void main(String[] args) {
		new RecuperarOpcoes().recuperar();
	}
	
	public OpcoesDto recuperar() {
		boolean continuaPerguntando = true;
		OpcoesDto opcoes = null;
		
		while(continuaPerguntando){
			opcoes = perguntaParaoUsuario(opcoes);
			
			if(opcoes.isCancelar()){
				System.exit(1);
			}
			
			if(opcoes.getNomeProjeto() == null || opcoes.getNomeProjeto() .trim().isEmpty()){
				continuaPerguntando = true;
			}
		}
		return opcoes;
	}
	
	private OpcoesDto perguntaParaoUsuario(OpcoesDto opcoes){
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
		
		opcoes = new OpcoesDto();
		opcoes.setNomeProjeto(nomeProjeto.getText());
		opcoes.setjQuery(jQuery.isSelected());
		opcoes.setCancelar(okCancelar == CANCELAR ? true : false);
		return opcoes;
		
	}
}