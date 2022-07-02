package Pizza;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PizzaCreateFrame extends JFrame {
	JTextField PizzaText;
	String  tipoSabor;
	JLabel SaborLabel, status;
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
		
		PizzaText = new JTextField();
		PizzaText.setBounds(110, 100, 200, 30);
		
		armazenarButton = new JButton("armazenar");
		armazenarButton.setBounds(110, 250, 200, 30);
		armazenarButton.addActionListener(new ButtonClickListener());
		
		add(SaborLabel); add(armazenarButton);
		
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
				novaPizza = new Pizza(PizzaText.getText(), tipoSabor);
				status.setText("Nova pizza Cadastrada!");
				System.out.println(novaPizza.getListaDePizza());
				
			}

		}
	}

}
