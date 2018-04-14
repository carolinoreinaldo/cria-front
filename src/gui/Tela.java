package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.OpcoesDto;
import enums.Projetos;
import geradorconteudo.MontaAmbiente;

@SuppressWarnings("unchecked")
public class Tela extends JFrame{

	private static final long serialVersionUID = 1210873978407678165L;
	
	private static final int PANEL_NOME_PROJETO = 0;
	private static final int PANEL_BIBLIOTECAS = 1;
	private static final int PANEL_MESSAGE = 4;
	private static final int PANEL_PROJETOS = 3;
	
	private boolean projetoSelecionado = false;

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
		panel.add(criaJPanelProjetos());
		panel.add(criaJPanelMessage());
		return panel;
	}
	
	private JPanel criaJPanelNomeProjeto(){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Nome do Projeto"));
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
		panel.setBorder(BorderFactory.createTitledBorder("Bibliotecas"));
		panel.setName("PanelBibliotecas");
		
		panel.setToolTipText("Bibliotecas");
		
		JCheckBox jQuery = new JCheckBox("jQuery: ");
		jQuery.setName("jQuery");
		JCheckBox lodash = new JCheckBox("lodash: ");
		lodash.setName("lodash");
		JCheckBox bootstrap = new JCheckBox("bootstrap: ");
		bootstrap.setName("bootstrap");
		bootstrap.setEnabled(false);
		
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
	
	private JPanel criaJPanelProjetos(){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Projetos"));
		panel.setName("PanelProjetos");
		
		Projetos[] projetos = Projetos.values();
		JComboBox<String> comboBox = new JComboBox<>();
		for (Projetos prjojeto : projetos) {
			comboBox.addItem(prjojeto.toString());
		}
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String projetoSelecionado = comboBox.getSelectedItem().toString();
				if(!Projetos.NENHUM_PROJETO.toString().equals(projetoSelecionado)){
					Tela.this.projetoSelecionado = true;
					Tela.this.bloquearPanels(true);
				} else {
					Tela.this.projetoSelecionado = false;
					Tela.this.bloquearPanels(false);
				}
			}
		});
		panel.add(comboBox);
		return panel;
	}
	
	protected void bloquearPanels(boolean bloquear) {
		JPanel pNomeProjeto = recuperarPanel(PANEL_NOME_PROJETO);
		JTextField nomeProjeto = (JTextField) pNomeProjeto.getComponent(1);
		nomeProjeto.setEditable(!bloquear);
		
		JPanel pBibliotecas = recuperarPanel(PANEL_BIBLIOTECAS);
		JCheckBox checkJQuery = (JCheckBox) pBibliotecas.getComponent(0);
		JCheckBox checkLodash = (JCheckBox) pBibliotecas.getComponent(1);
		JCheckBox checkBootStrap = (JCheckBox) pBibliotecas.getComponent(2);
		
		checkJQuery.setEnabled(!bloquear);
		checkLodash.setEnabled(!bloquear);
		checkBootStrap.setEnabled(!bloquear);
	}

	private JPanel criaPanelBotoes(){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Botões"));
		panel.setName("PanelBotoes");
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
		     public void mouseClicked(MouseEvent mouseEvent) {
	           JPanel panelNomeProjeto = recuperarPanel(PANEL_NOME_PROJETO);
	           JPanel panelBibliotecas = recuperarPanel(PANEL_BIBLIOTECAS);
	           JPanel panelProjetos = recuperarPanel(PANEL_PROJETOS);
	           
	           JLabel message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
	           OpcoesDto opcoes = new OpcoesDto();
	           try {
		           if(projetoSelecionado){
		        	   opcoes.setNomeProjeto(recuperarProjetoSelecionado(panelProjetos));
		        	   opcoes.setProjetoProntoSelecionado(true);
		        	   new MontaAmbiente().montar(opcoes);
		           } else {
			           opcoes.setjQuery(checkBoxSelecionado(panelBibliotecas.getComponent(0)));
			           opcoes.setLodash(checkBoxSelecionado(panelBibliotecas.getComponent(1)));
			           opcoes.setBootstrap(checkBoxSelecionado(panelBibliotecas.getComponent(2)));
			           opcoes.setNomeProjeto(recuperarInputTexto(panelNomeProjeto.getComponent(1)));
		           
		        	   boolean ambienteMontado = new MontaAmbiente().montar(opcoes);
		        	   if(ambienteMontado) {
		        		   message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
		        		   message.setText("Ambiente montado com sucesso.");
		        		   message.setForeground(Color.GREEN);
		        	   } else {
		        		   message.setText("Ocorreu um problema ao montar o ambiente.");
		        		   message.setForeground(Color.RED);
		        	   }
		           }
			   } catch (Exception e) {
				   StringWriter sw = new StringWriter();
				   PrintWriter pw = new PrintWriter(sw);
				   e.printStackTrace(pw);
				   String sStackTrace = sw.toString();
				   JOptionPane.showMessageDialog(null, sStackTrace);
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
	
	private String recuperarProjetoSelecionado(JPanel panelProjetos) {
		JComboBox<String> projetosSelecionados = (JComboBox<String>)panelProjetos.getComponent(0);
		return projetosSelecionados.getSelectedItem().toString();
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