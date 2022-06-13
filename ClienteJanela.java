import javax.swing.*;
import java.awt.*;

public class ClienteJanela extends JFrame {
	ClienteJanela() {
		prepararJanela();
		organizarComponentes();
		setVisible(true);
	}
	
	public void prepararJanela() {
		setSize(500, 500);
		setLayout(null);
	}
	
	public void organizarComponentes() {
		JTextField nome, cpf, endereco;
		
		nome = new JTextField("Nome: ");
		nome.setBounds(50, 100, 200, 30);
		
		cpf = new JTextField("CPF: ");
		cpf.setBounds(50, 150, 200, 30);
		
		endereco = new JTextField("Endereço: ");
		endereco.setBounds(50, 200, 200, 30);
		
		add(nome);add(cpf);add(endereco);
	}
	
	
}
