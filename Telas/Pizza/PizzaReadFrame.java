package Telas.Pizza;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import Principal.Gerenciador;
import Entidades.*;

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
		ArrayList<Pizza> listaDePizza = Gerenciador.getListaDePizzas();
		String lista = "";
		
		for(int i=0; i<listaDePizza.size(); i++) {
			Pizza PizzaAtual = listaDePizza.get(i);
			lista += PizzaAtual.toString() + "\n";
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
