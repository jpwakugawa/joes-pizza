import javax.swing.*;

public class Menu extends JMenuBar {
	JMenu cliente, pedido, pizza, formaDePagamento;
	
	Menu(){
		cliente = new JMenu("Cliente");
		pedido = new JMenu("Pedido");
		pizza = new JMenu("Pizza");
		formaDePagamento = new JMenu("Forma de pagamento");
		

		this.add(cliente);
		this.add(pedido);
		this.add(pizza);
		this.add(formaDePagamento);
	}
}
