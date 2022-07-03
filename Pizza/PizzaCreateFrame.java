package Pizza;
import javax.swing.*;

import Principal.Gerenciador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class PizzaCreateFrame extends JFrame {
	JTextField SaborText, precoText;
	JLabel SaborLabel, precoLabel, status;
	String  tipoSabor;
	double preco;
	JButton armazenarButton;
	Pizza novaPizza;
	
	public PizzaCreateFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("cadastro da pizza");
		setSize(500,500);
		setLayout(null);
		status.setText("cadastrando nova Pizza");
	}
	
	private void configComponente() {
		SaborLabel = new JLabel("sabor:");
		SaborLabel.setBounds(30, 100, 200, 30);
		SaborText = new JTextField();
		SaborText.setBounds(110, 100, 200, 30);
		
		precoLabel = new JLabel("preco:");
		precoLabel.setBounds(30, 150, 200, 30);
		precoText = new JTextField();
		precoText.setBounds(110, 150, 200,30);
		
		armazenarButton = new JButton("armazenar");
		armazenarButton.setBounds(110, 250, 200, 30);
		armazenarButton.addActionListener(new ButtonClickListener());
		
		add(SaborLabel); add(precoLabel); 
		add(SaborText); add(precoText); add(armazenarButton);
		
	}
	
	private void configEvento() {
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				status.setText("Status");
			}
		});
	}
	
	private void end() {
		setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			
			if( command.equals( "armazenar" )) {
				try {
					novaPizza = new Pizza(SaborText.getText());
					ArrayList<Pizza> listaDePizza = Gerenciador.getListaDePizza();
					listaDePizza.add(novaPizza);
					status.setText("Nova pizza Cadastrada!");
				}catch(Exception exception) {
					status.setText(exception.getMessage());
				}
			}
		}
	}
}


