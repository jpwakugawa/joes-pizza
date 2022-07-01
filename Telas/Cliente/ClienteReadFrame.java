package Telas.Cliente;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import Principal.Gerenciador;
import Entidades.*;

// Janela para mostrar lista de clientes
public class ClienteReadFrame extends JFrame {
	JLabel    status;
	JTextArea area;
	
	public ClienteReadFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Lista de Clientes");
		setSize(1000, 800);
		setLayout(null);
		status.setText("Listando Clientes");
	}
	
	private void configComponente() {
		ArrayList<Cliente> listaDeClientes = Gerenciador.getListaDeClientes();
		String lista = "";
		
		for(int i=0; i<listaDeClientes.size(); i++) {
			Cliente clienteAtual = listaDeClientes.get(i);
			lista += clienteAtual.toString() + "\n";
		}
		
		if (lista.equals("") ) {
			area = new JTextArea("Nenhum cliente cadastrado...");
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
