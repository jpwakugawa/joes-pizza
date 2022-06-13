import javax.swing.*;

public class Menu extends JMenuBar {
	JMenu cliente, pedido, pizza, formaDePagamento;
	JMenuItem create, read, update, delete;
	
	Menu(){
		cliente = new JMenu("Cliente");
		pedido = new JMenu("Pedido");
		pizza = new JMenu("Pizza");
		formaDePagamento = new JMenu("Forma de pagamento");
		
		create = new JMenuItem("Create");
		read = new JMenuItem("Read");
		update = new JMenuItem("Update");
		delete = new JMenuItem("Delete");
		
		cliente.add(create);
		cliente.add(read);
		cliente.add(update);
		cliente.add(delete);
		
		this.add(cliente);
		this.add(pedido);
		this.add(pizza);
		this.add(formaDePagamento);
	}
}
