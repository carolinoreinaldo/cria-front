package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private static final int PANEL_BOTOES = 2;
	private static final int PANEL_MESSAGE = 4;
	private static Dimension panelDimensaoPadrao = null;
	
	public Tela() {
		panelDimensaoPadrao = new Dimension(400, 80);
	}
	
	public void criaTela(){
		setTitle("Construção do Ambiente Front-End");
		setSize(550, 500);
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

	private JPanel criarPanelDefault(String nomePanel, String nomeLegenda) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(panelDimensaoPadrao);
		panel.setBorder(BorderFactory.createTitledBorder(nomeLegenda));
		panel.setName(nomePanel);
		return panel;
	}
	
	private JPanel criaJPanelNomeProjeto(){
		JPanel panel = criarPanelDefault("PanelNomeProjeto", "Nome do Projeto");
		JLabel label = new JLabel();
		label.setText("Nome Projeto: ");
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(200, 24));
		panel.add(label);
		panel.add(text);
		
		return panel;
	}

	private JPanel criaJPanelBibliotecas(){
		JPanel panel = criarPanelDefault("PanelBibliotecas", "Adicionar Bibliotecas?");
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
	
	
	
	protected void bloquearPanels(boolean bloquear) {
		JPanel pNomeProjeto = recuperarPanel(PANEL_NOME_PROJETO);
		pNomeProjeto.setEnabled(!bloquear);
		JLabel lblNomeProjeto = (JLabel) pNomeProjeto.getComponent(0);
		lblNomeProjeto.setEnabled(!bloquear);
		JTextField nomeProjeto = (JTextField) pNomeProjeto.getComponent(1);
		nomeProjeto.setEditable(!bloquear);
		
		JPanel pBibliotecas = recuperarPanel(PANEL_BIBLIOTECAS);
		pBibliotecas.setEnabled(!bloquear);
		JCheckBox checkJQuery = (JCheckBox) pBibliotecas.getComponent(0);
		JCheckBox checkLodash = (JCheckBox) pBibliotecas.getComponent(1);
		JCheckBox checkBootStrap = (JCheckBox) pBibliotecas.getComponent(2);
		
		JPanel pBotoes = recuperarPanel(PANEL_BOTOES);
		JButton btnCriar = (JButton) pBotoes.getComponent(0);
		btnCriar.setEnabled(!bloquear);
		
		checkJQuery.setEnabled(!bloquear);
		checkLodash.setEnabled(!bloquear);
		checkBootStrap.setEnabled(!bloquear);
	}

	private JPanel criaPanelBotoes(){
		JPanel panel = criarPanelDefault("PanelBotoes", "Ações");
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
		     public void mouseClicked(MouseEvent mouseEvent) {
	           JPanel panelNomeProjeto = recuperarPanel(PANEL_NOME_PROJETO);
	           JPanel panelBibliotecas = recuperarPanel(PANEL_BIBLIOTECAS);
	           
	           
	           JLabel message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
	           OpcoesDto opcoes = new OpcoesDto();
	           try {
		           opcoes.setjQuery(checkBoxSelecionado(panelBibliotecas.getComponent(0)));
		           opcoes.setLodash(checkBoxSelecionado(panelBibliotecas.getComponent(1)));
		           opcoes.setBootstrap(checkBoxSelecionado(panelBibliotecas.getComponent(2)));
		           opcoes.setNomeProjeto(recuperarInputTexto(panelNomeProjeto.getComponent(1)));
	           
	        	   boolean ambienteMontado = new MontaAmbiente(opcoes).montar();
	        	   if(ambienteMontado) {
	        		   message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
	        		   message.setText("Ambiente montado com sucesso.");
	        		   message.setForeground(Color.BLUE);
	        	   } else {
	        		   message.setText("Ocorreu um problema ao montar o ambiente.");
	        		   message.setForeground(Color.RED);
	        	   }
			   } catch (Exception e) {
				   new TelaErro(e).criaTela();
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

	private JPanel criaJPanelProjetos(){
		JPanel panel = criarPanelDefault("PanelProjetos", "Projetos Prontos");
		JButton btnGerarProjeto = new JButton("Gerar Projeto Pronto");
		
		Projetos[] projetos = Projetos.values();
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setPreferredSize(new Dimension(500, 30));
		
		for (Projetos prjojeto : projetos) {
			comboBox.addItem(prjojeto.nomeParaExibicao());
		}
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String projetoSelecionado = comboBox.getSelectedItem().toString();
				if(Projetos.NENHUM_PROJETO.toString().equals(projetoSelecionado.trim())){
					Tela.this.bloquearPanels(false);
					btnGerarProjeto.setEnabled(false);
				} else {
					Tela.this.bloquearPanels(true);
					btnGerarProjeto.setEnabled(true);
				}
			}
		});
		panel.add(comboBox);
		
		btnGerarProjeto.addMouseListener(new MouseAdapter() {
			@Override
		     public void mouseClicked(MouseEvent mouseEvent) {
				OpcoesDto opcoes = new OpcoesDto();
				opcoes.setNomeProjeto(recuperarProjetoSelecionado(panel));
		       	opcoes.setProjetoProntoSelecionado(true);
		       	try {
					new MontaAmbiente(opcoes).montar();
		            JLabel message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
					message = (JLabel)recuperarPanel(PANEL_MESSAGE).getComponent(0);
            		message.setText("Projeto pronto criado com sucesso.");
	        		message.setForeground(Color.BLUE);
				} catch (Exception e) {
					new TelaErro(e).criaTela();
				}
			}
		});
		panel.add(btnGerarProjeto);
		return panel;
	}
	private JPanel criaJPanelMessage(){
		JPanel panel = criarPanelDefault("PanelMensagem", "Status do Processo");
		
		JLabel labelMessage = new JLabel();
		
		panel.add(labelMessage);
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