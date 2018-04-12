package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.OpcoesDto;
import geradorconteudo.MontaAmbiente;

public class Tela extends JFrame{

	private static final long serialVersionUID = 1210873978407678165L;
	
	private static final int PANEL_NOME_PROJETO = 0;
	private static final int PANEL_BIBLIOTECAS = 1;
	private static final int PANEL_MESSAGE = 3;

	public void criaTela(){
		setTitle("Construção do Ambiente Front-End");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(criaPanelPrincipal());
		setVisible(true);
	}
	
	private JPanel criaPanelPrincipal() {
		JPanel panel = new JPanel();
		panel.setName("PanelPrincipal");
		panel.add(criaJPanelNomeProjeto());
		panel.add(criaJPanelBibliotecas());
		panel.add(criaPanelBotoes());
		panel.add(criaJPanelMessage());
		return panel;
	}
	
	private JPanel criaJPanelNomeProjeto(){
		JPanel panel = new JPanel();
		panel.setName("PanelNomeProjeto");
		JLabel label = new JLabel();
		label.setText("Nome Projeto: ");
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(200, 24));
		panel.add(label);
		panel.add(text);
		
		return panel;
	}
	
	private JPanel criaJPanelBibliotecas(){
		JPanel panel = new JPanel();
		panel.setName("PanelBibliotecas");
		
		panel.setToolTipText("Bibliotecas");
		
		JCheckBox jQuery = new JCheckBox("jQuery: ");
		jQuery.setName("jQuery");
		JCheckBox lodash = new JCheckBox("lodash: ");
		jQuery.setName("lodash");
		JCheckBox bootstrap = new JCheckBox("bootstrap: ");
		jQuery.setName("bootstrap");
		
		panel.add(jQuery);
		panel.add(lodash);
		panel.add(bootstrap);
		
		return panel;
	}
	
	private JPanel criaJPanelMessage(){
		JPanel panel = new JPanel();
		panel.setName("PanelMessage");
		
		JLabel labelMessage = new JLabel();
		
		panel.add(labelMessage);
		return panel;
	}
	
	private JPanel criaPanelBotoes(){
		JPanel panel = new JPanel();
		panel.setName("PanelBotoes");
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
		     public void mouseClicked(MouseEvent mouseEvent) {
	           JPanel panelNomeProjeto = recuperarPanel(PANEL_NOME_PROJETO);
	           JPanel panelBibliotecas = recuperarPanel(PANEL_BIBLIOTECAS);
	           
	           OpcoesDto opcoes = new OpcoesDto();
	           opcoes.setjQuery(checkBoxSelecionado(panelBibliotecas.getComponent(0)));
	           opcoes.setLodash(checkBoxSelecionado(panelBibliotecas.getComponent(1)));
	           opcoes.setBootstrap(checkBoxSelecionado(panelBibliotecas.getComponent(2)));
	           opcoes.setNomeProjeto(recuperarInputTexto(panelNomeProjeto.getComponent(1)));
	           
	           JLabel message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
	           try {
	        	   boolean ambienteMontado = new MontaAmbiente().montar(opcoes);
	        	   if(ambienteMontado) {
	        		   message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
	        		   message.setText("Ambiente montado com sucesso.");
	        		   message.setForeground(Color.GREEN);
	        	   } else {
	        		   message.setText("Ocorreu um problema ao montar o ambiente.");
	        		   message.setForeground(Color.RED);
	        	   }
			   } catch (IOException e) {
				   message.setText("Ocorreu um problema ao montar o ambiente.");
				   message.setForeground(Color.RED);
				   e.printStackTrace();
			   }
		     }
		});
		
		JButton btnCancelar = new JButton("Fechar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnInfo = new JButton("Ajuda");
		btnInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MostraTelaAjuda().mostra();
				
			}
		});
		
		panel.add(btnCriar);
		panel.add(btnCancelar);
		panel.add(btnInfo);
		
		return panel;
	}
	
	private boolean checkBoxSelecionado(Component component){
		JCheckBox checkbox = (JCheckBox) component;
        return checkbox.isSelected();
	}
	
	private String recuperarInputTexto(Component component){
		JTextField texto = (JTextField) component;
		return texto.getText();
	}
	
	private JPanel recuperarPanel(int panel) {
		JPanel panelPrincipal = (JPanel) getContentPane().getComponent(0);
		return (JPanel) panelPrincipal.getComponent(panel);
	}
}