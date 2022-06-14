import javax.swing.*;
import java.awt.*;

// Janela para realizar READ do Cliente
public class ClienteJanela extends JFrame {
	ClienteJanela() {
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setSize(500, 500);
		setLayout(null);
	}
	
	private void configComponente() {
		JLabel nomeLabel, cpfLabel, enderecoLabel;
		JTextField nomeText, cpfText, enderecoText;
		JButton submitButton;
		
		nomeLabel = new JLabel("Nome: ");
		nomeLabel.setBounds(30, 100, 200, 30);
		nomeText = new JTextField();
		nomeText.setBounds(110, 100, 200, 30);
		
		cpfLabel = new JLabel("CPF: ");
		cpfLabel.setBounds(30, 150, 200, 30);
		cpfText = new JTextField();
		cpfText.setBounds(110, 150, 200, 30);
		
		enderecoLabel = new JLabel("Endereço: ");
		enderecoLabel.setBounds(30, 200, 200, 30);
		enderecoText = new JTextField();
		enderecoText.setBounds(110, 200, 200, 30);
		
		submitButton = new JButton("submit");
		submitButton.setBounds(110, 250, 200, 30);
		
		add(nomeLabel);add(cpfLabel);add(enderecoLabel);
		add(nomeText);add(cpfText);add(enderecoText);add(submitButton);
	}
	
	private void configEvento() {
		
	}
	
	private void end() {
		setVisible(true);
	}
	
}
