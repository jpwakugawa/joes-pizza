import javax.swing.*;
import java.awt.event.*;

public class ClienteReadFrame extends JFrame {
	JTextArea area;
	
	ClienteReadFrame(JLabel status) {
		setTitle("Lista de Clientes");
		setSize(500, 500);
		setLayout(null);
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
		
		status.setText("Listando Clientes");
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e){
	            status.setText("Status");
	        }
	    });
	}
}
