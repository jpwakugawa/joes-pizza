package Principal;

import javax.swing.*;
import java.awt.event.*;
import Cliente.*;
import Pedido.*;
import Pizza.*;
import FormaDePagamento.*;

public class Menu extends JMenuBar implements ActionListener {
	JLabel    status;
	JMenu     submenuCliente, submenuPedido, submenuPizza, submenuFP;
	JMenuItem createCliente, readCliente, updateCliente, deleteCliente;
	JMenuItem createPedido, readPedido, updatePedido, deletePedido;
	JMenuItem createPizza, readPizza, updatePizza, deletePizza;
	JMenuItem cadastrarFP, visualizarFP, editarFP, deletarFP;
	JMenuItem cadastrarPizza, visualizarPizza, editarPizza, deletarPizza;
	
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
		else if(e.getSource()==deleteCliente) {
			new ClienteDeleteFrame(status);
		}
		
		// Janelas Pedido
		if(e.getSource()==createPedido) {
			new PedidoCreateFrame(status);
		}
		else if(e.getSource()==readPedido) {
			new PedidoReadFrame(status);
		}
		else if(e.getSource()==updatePedido) {
			new PedidoUpdateFrame(status);
		}
		else if(e.getSource()==deletePedido) {
			new PedidoDeleteFrame(status);
		}
		
		// Janelas Pizza
		if(e.getSource()==createPizza) {
			new PizzaCreateFrame(status);
		}
		else if(e.getSource()==readPizza) {
			new PizzaReadFrame(status);
		}
		else if(e.getSource()==updatePizza) {
			new PizzaUpdateFrame(status);
		}
		else if(e.getSource()==deletePizza) {
			new PizzaDeleteFrame(status);
		}
		
		// Janelas Forma de Pagamento
		else if(e.getSource()==cadastrarFP) {
			new FormaDePagamentoCreateFrame(status);
		}
		else if(e.getSource()==visualizarFP) {
			new FormaDePagamentoReadFrame(status);
		}
		else if(e.getSource()==editarFP) {
			new FormaDePagamentoUpdateFrame(status);
		}
		else if(e.getSource()==deletarFP) {
			new FormaDePagamentoDeleteFrame(status);
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
		createPedido = new JMenuItem("Cadastrar");
		createPedido.addActionListener(this);
		
		readPedido = new JMenuItem("Visualizar");
		readPedido.addActionListener(this);
		
		updatePedido = new JMenuItem("Editar");
		updatePedido.addActionListener(this);
		
		deletePedido = new JMenuItem("Deletar");
		deletePedido.addActionListener(this);
		
		submenuPedido.add(createPedido);
		submenuPedido.add(readPedido);
		submenuPedido.add(updatePedido);
		submenuPedido.add(deletePedido);
		
		this.add(submenuPedido);
	}
	
	public void submenuPizza() {
		submenuPizza = new JMenu("Pizza");
		createPizza = new JMenuItem("Cadastrar");
		createPizza.addActionListener(this);
		
		readPizza = new JMenuItem("Visualizar");
		readPizza.addActionListener(this);

		updatePizza = new JMenuItem("Editar");
		updatePizza.addActionListener(this);
		
		deletePizza = new JMenuItem("Deletar");
		deletePizza.addActionListener(this);
		
		submenuPizza.add(createPizza);
		submenuPizza.add(readPizza);
		submenuPizza.add(updatePizza);
		submenuPizza.add(deletePizza);

		this.add(submenuPizza);
	}
	
	public void submenuFP() {
		submenuFP = new JMenu("Forma de pagamento");
		
		cadastrarFP = new JMenuItem("Cadastrar");
		cadastrarFP.addActionListener(this);
		
		visualizarFP = new JMenuItem("Visualizar");
		visualizarFP.addActionListener(this);
		
		editarFP = new JMenuItem("Editar");
		editarFP.addActionListener(this);
		
		deletarFP = new JMenuItem("Deletar");
		deletarFP.addActionListener(this);
		
		submenuFP.add(cadastrarFP);
		submenuFP.add(visualizarFP);
		submenuFP.add(editarFP);
		submenuFP.add(deletarFP);
		
		this.add(submenuFP);
	}
}
