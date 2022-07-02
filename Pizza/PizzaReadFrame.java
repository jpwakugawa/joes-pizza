package Pizza;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class PizzaReadFrame extends JFrame {
	JLabel status;
	JTextArea area;
	
	public PizzaReadFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Lista de Pizzas");
		setSize(1000, 800);
		setLayout(null);
		status.setText("Listando Pizzas");
	
	}
	
	private void configComponente() {
		Pizza Pizza = new Pizza();
		String lista = Pizza.getListaDePizza();
		
		if (lista.equals("") ) {
			area = new JTextArea("Nenhuma Pizza cadastrada...");
		}
		else {
			area = new JTextArea(Pizza.getListaDePizza());
		}
		
		area.setBounds(50, 50, 900, 500);
		add(area);
	
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

}
