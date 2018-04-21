package gui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class Mensagem extends JFrame {

		private static final long serialVersionUID = -6594890186448328381L;

		public void criaTela(){
			setTitle(recuperarTitulo());
			setSize(new Dimension(500, 500));
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			add(criaPanelPrincipal());
			setVisible(true);
		}
		
		protected abstract String recuperarTitulo();

		private JPanel criaPanelPrincipal() {
			JPanel panel = new JPanel();
			panel.add(criaJPanelTextoAjuda());
			panel.add(criaPanelBotoes());
			return panel;
		}
		
		private JPanel criaJPanelTextoAjuda(){
			JPanel panel = new JPanel();
			
			JTextArea texto = new JTextArea(10, 10);
			texto.setText(recuperarMensagem());
			texto.setAutoscrolls(true);
			
			JScrollPane scroll = new JScrollPane (texto, 
					   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			add(scroll);
			panel.add(texto);
			
			return panel;
		}
		
		private JPanel criaPanelBotoes(){
			JPanel panel = new JPanel();
			
			JButton btnFechar = new JButton("Fechar");
			btnFechar.addMouseListener(new MouseAdapter() {
				@Override
			     public void mouseClicked(MouseEvent mouseEvent) {
					setVisible(false);
					dispose();
				}
			});
			
			panel.add(btnFechar);
			
			return panel;
		}
		
		public abstract String recuperarMensagem();
}