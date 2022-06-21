import javax.swing.*;
import java.awt.event.*;

// Janela para mostrar lista de clientes
public class ClienteReadFrame extends JFrame {
	JTextArea area;
	JLabel status;
	
	ClienteReadFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Lista de Clientes");
		setSize(500, 500);
		setLayout(null);
		status.setText("Listando Clientes");
	}
	
	private void configComponente() {
		Cliente cliente = new Cliente();
		String lista = cliente.getListaDeClientes();
		
		if (lista.equals("") ) {
			area = new JTextArea("Nenhum cliente cadastrado...");
		}
		else {
			area = new JTextArea(cliente.getListaDeClientes());
		}
		
		area.setBounds(50, 50, 300, 300);
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
