import javax.swing.*;
import java.awt.event.*;
import Cliente.*;
import FormaDePagamento.*;

public class Menu extends JMenuBar implements ActionListener {
	JLabel    status;
	JMenu     submenuCliente, submenuPedido, submenuPizza, submenuFP;
	JMenuItem createCliente, readCliente, updateCliente, deleteCliente;
	JMenuItem cadastrarFP, visualizarFP, editarFP, deletarFP;
	
	Menu(JLabel status){
		this.status = status;
		submenuCliente();
		submenuPedido();
		submenuPizza();
		submenuFP();
	}
	
	// Acões a serem tomadas quando clicamos nos itens do Menu
	public void actionPerformed(ActionEvent e) {
		// Janelas Cliente
		if(e.getSource()==createCliente) {
			new ClienteCreateFrame(status);
		}
		else if(e.getSource()==readCliente) {
			new ClienteReadFrame(status);
		}
		else if(e.getSource()==updateCliente) {
			new ClienteUpdateFrame(status);
		}
		
		// Janelas Forma de Pagamento
		else if(e.getSource()==cadastrarFP) {
			new FormaDePagamentoCreateFrame(status);
		}
		else if(e.getSource()==visualizarFP) {
			new FormaDePagamentoReadFrame(status);
		}
	}
	
	public void submenuCliente() {
		submenuCliente = new JMenu("Cliente");
		
		createCliente = new JMenuItem("Cadastrar");
		createCliente.addActionListener(this);
		
		readCliente = new JMenuItem("Visualizar");
		readCliente.addActionListener(this);
		
		updateCliente = new JMenuItem("Editar");
		updateCliente.addActionListener(this);
		
		deleteCliente = new JMenuItem("Deletar");
		deleteCliente.addActionListener(this);
		
		submenuCliente.add(createCliente);
		submenuCliente.add(readCliente);
		submenuCliente.add(updateCliente);
		submenuCliente.add(deleteCliente);
		
		this.add(submenuCliente);
	}
	
	public void submenuPedido() {
		submenuPedido = new JMenu("Pedido");
		this.add(submenuPedido);
	}
	
	public void submenuPizza() {
		submenuPizza = new JMenu("Pizza");
		this.add(submenuPizza);
	}
	
	public void submenuFP() {
		submenuFP = new JMenu("Forma de pagamento");
		
		cadastrarFP = new JMenuItem("Cadastrar");
		cadastrarFP.addActionListener(this);
		
		visualizarFP = new JMenuItem("Visualizar");
		visualizarFP.addActionListener(this);
		editarFP = new JMenuItem("Editar");
		deletarFP = new JMenuItem("Deletar");
		
		submenuFP.add(cadastrarFP);
		submenuFP.add(visualizarFP);
		submenuFP.add(editarFP);
		submenuFP.add(deletarFP);
		
		this.add(submenuFP);
	}
}
