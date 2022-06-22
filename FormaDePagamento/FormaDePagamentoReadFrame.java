package FormaDePagamento;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

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
		FormaDePagamento FP = new FormaDePagamento();
		String lista = FP.getListaFP();
		
		if (lista.equals("") ) {
			area = new JTextArea("Nenhum cliente cadastrado...");
		}
		else {
			area = new JTextArea(FP.getListaFP());
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
