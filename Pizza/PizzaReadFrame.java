package Pizza;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

import Pedido.Pedido;
import Principal.Gerenciador;

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
		ArrayList<Pizza> listaDePizza = Gerenciador.getListaDePizza();
		String lista = "";
		
		for(Pizza pz : listaDePizza) {
			Pizza PzAtual = pz;
			lista += PzAtual.toString() + "\n";
		}
		
		if (lista.equals("") ) {
			area = new JTextArea("Nenhuma Pizza cadastrada...");
		}
		else {
			area = new JTextArea(lista);
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
