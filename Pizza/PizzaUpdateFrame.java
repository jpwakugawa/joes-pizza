package Pizza;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import Principal.Gerenciador;

public class PizzaUpdateFrame extends JFrame{
	JLabel avisoLabel, SaborLabel, precoLabel, status;
	JTextField SaborText, precoText;
	JButton armazenarButton;
	Pizza novaPizza;
	
	public PizzaUpdateFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	public void configJanela() {
	setTitle("Edição de Pizza");
	setSize(500, 500);
	setLayout(null);
	status.setText("Editando Pizza");
	
	}
	private void configComponente() {
		avisoLabel = new JLabel("Insira o ID da Pizza para editar!");
		avisoLabel.setBounds(30, 10, 300, 30);
		
		SaborLabel = new JLabel("Sabor: ");
		SaborLabel.setBounds(30, 100, 200, 30);
		SaborText = new JTextField();
		SaborText.setBounds(110, 100, 200, 30);
		
		precoLabel = new JLabel("preco: ");
		precoLabel.setBounds(30, 150, 200, 30);
		precoText = new JTextField();
		precoText.setBounds(110, 150, 200, 30);
		
		armazenarButton = new JButton("Edit");
		armazenarButton.setBounds(110, 250, 200, 30);
		armazenarButton.addActionListener(new ButtonClickListener());
		
		add(avisoLabel);  add(SaborLabel); add(precoLabel);
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
			
			if( command.equals( "edit" ) )  {
				try {
					double preco = Double.parseDouble(precoText.getText());
					String Sabor = SaborText.getText();
					
					novaPizza = new Pizza(preco, Sabor);
					ArrayList<Pizza> ListaDePizza = Gerenciador.getListaDePizza();
					ListaDePizza.set((int) preco, novaPizza);
					
					status.setText("Pizza Editada!");
				}catch (Exception exception) {
					status.setText(exception.getMessage());
				}
					
			}
		}
	}
}	
	
	
	
	
	


