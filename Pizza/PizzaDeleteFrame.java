package Pizza;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import Principal.Gerenciador;

public class PizzaDeleteFrame extends JFrame {
	JLabel     avisoLabel, precoLabel, status;
	JTextField precoText;
	JButton armazenarButton;
	
	public PizzaDeleteFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Deletar Pizza");
		setSize(500, 500);
		setLayout(null);
		status.setText("Deletando Pizza");
	
	}
	
	private void configComponente() {
		avisoLabel = new JLabel("Insira o ID da Pizza");
		avisoLabel.setBounds(30, 10, 300, 30);
		
		precoLabel = new JLabel("preco: ");
		precoLabel.setBounds(30, 100, 200, 30);
		precoText = new JTextField();
		precoText.setBounds(110, 100, 200, 30);
		
		armazenarButton = new JButton("Deletar");
		armazenarButton.setBounds(110, 150, 200, 30);
		armazenarButton.addActionListener(new ButtonClickListener());
		
		add(avisoLabel);add(precoLabel);
		add(precoText);add(armazenarButton);
		
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
		@SuppressWarnings("unlikely-arg-type")
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			
			if( command.equals( "delete" ) )  {
				try {
					double preco = Double.parseDouble(precoText.getText());
					ArrayList<Pizza>listaDePizza = Gerenciador.getListaDePizza();
					listaDePizza.remove(preco);
					for(Pizza pz : listaDePizza) {
						Pizza novaPizza = pz;
						novaPizza.setPreco(pz.getPreco());
					}
					
					status.setText("Pizza Deletada!");
				}
				catch (Exception exception) {
					status.setText(exception.getMessage());
				}
					
			}
		}
	}	
}
