package Pizza;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import Principal.Gerenciador;

public class PizzaDeleteFrame extends JFrame {
	JLabel     avisoLabel, idLabel, status;
	JTextField idText;
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
		
		idLabel = new JLabel("Id: ");
		idLabel.setBounds(30, 100, 200, 30);
		idText = new JTextField();
		idText.setBounds(110, 100, 200, 30);
		
		armazenarButton = new JButton("Deletar");
		armazenarButton.setBounds(110, 150, 200, 30);
		armazenarButton.addActionListener(new ButtonClickListener());
		
		add(avisoLabel);add(idLabel);
		add(idText);add(armazenarButton);
		
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
			
			if( command.equals( "delete" ) )  {
				int id = Integer.parseInt(idText.getText());
				ArrayList<Pizza>ListaDePizza = Gerenciador.getListaDePizza();
				ListaDePizza.remove(id);
				
				for(int i=0; i<ListaDePizza.size(); i++) {
					Pizza novaPizza = ListaDePizza.get(i);
					novaPizza.setId(i);
				}
				
				status.setText("Pizza Deletada!");
					
			}
		}
	}	
}
