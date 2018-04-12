package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TelaAjuda extends JFrame{

	private static final long serialVersionUID = -6594890186448328381L;

	public void criaTela(){
		setTitle("----Ajuda----");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(criaPanelPrincipal());
		setVisible(true);
	}
	
	private JPanel criaPanelPrincipal() {
		JPanel panel = new JPanel();
		panel.add(criaJPanelTextoAjuda());
		panel.add(criaPanelBotoes());
		return panel;
	}
	
	private JPanel criaJPanelTextoAjuda(){
		JPanel panel = new JPanel();
		
		JTextArea texto = new JTextArea(10, 10);
		texto.setText(criaTextoAjuda());
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
	
	private String criaTextoAjuda(){
		StringBuilder ajuda = new StringBuilder();
		ajuda.append("Essa ferramenta cria um ambiente Front-End básico");
		ajuda.append("\nno seguinte formato:");
		ajuda.append("\n");
		ajuda.append("\n");
		return ajuda.toString();
	}
}