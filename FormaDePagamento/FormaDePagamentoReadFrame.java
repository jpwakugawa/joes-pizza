package FormaDePagamento;

import javax.swing.*;
import Principal.Gerenciador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
