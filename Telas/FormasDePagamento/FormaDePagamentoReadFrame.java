package Telas.FormasDePagamento;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import Principal.Gerenciador;
import Entidades.*;

public class FormaDePagamentoReadFrame extends JFrame{
	JLabel    status;
	JTextArea area;
	
	public FormaDePagamentoReadFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}

	private void configJanela() {
		setTitle("Lista de Formas de Pagamento");
		setSize(1000, 800);
		setLayout(null);
		status.setText("Listando Formas de Pagamento");
		
	}

	private void configComponente() {
		ArrayList<FormaDePagamento> listaDeFormasDePagamento = Gerenciador.getListaDeFormasDePagamentos();
		String lista = "";
		
		for(FormaDePagamento fp : listaDeFormasDePagamento) {
			FormaDePagamento fpAtual = fp;
			lista += fpAtual.toString() + "\n";
		}
		
		if (lista.equals("") ) {
			area = new JTextArea("Nenhuma forma de pagamento cadastrada...");
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
