package Pedido;

import javax.swing.*;
import java.awt.event.*;
import Principal.Gerenciador;
import java.util.ArrayList;

public class PedidoReadFrame extends JFrame{
	JLabel    status;
	JTextArea area;
	
	public PedidoReadFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Lista de Pedidos");
		setSize(1100, 800);
		setLayout(null);
		status.setText("Listando Pedidos");
	}
	
	private void configComponente() {
		ArrayList<Pedido> listaDeClientes = Gerenciador.getListaDePedidos();
		String lista = "";
		
		for(int i=0; i<listaDeClientes.size(); i++) {
			Pedido pedidoAtual = listaDeClientes.get(i);
			lista += pedidoAtual.toString() + "\n";
		}
		
		if (lista.equals("") ) {
			area = new JTextArea("Nenhum pedido cadastrado...");
		}
		else {
			area = new JTextArea(lista);
		}
		
		area.setBounds(50, 50, 1000, 500);
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