import javax.swing.*;
import java.awt.event.*;

public class Menu extends JMenuBar implements ActionListener {
	JMenu cliente, pedido, pizza, formaDePagamento;
	JMenuItem create, read, update, delete, cadastrarFP, visualizarFP, editarFP, deletarFP;
	JLabel status;
	
	Menu(JLabel status){
		this.status = status;
		
		cliente = new JMenu("Cliente");
		pedido = new JMenu("Pedido");
		pizza = new JMenu("Pizza");
		formaDePagamento = new JMenu("Forma de pagamento");
		
		create = new JMenuItem("Create");
		create.addActionListener(this);
		read = new JMenuItem("Read");
		update = new JMenuItem("Update");
		delete = new JMenuItem("Delete");
		
		cliente.add(create);
		cliente.add(read);
		cliente.add(update);
		cliente.add(delete);
		
		cadastrarFP = new JMenuItem("Cadastrar");
		visualizarFP = new JMenuItem("Visualizar");
		editarFP = new JMenuItem("Editar");
		deletarFP = new JMenuItem("Deletar");
		
		formaDePagamento.add(cadastrarFP);
		formaDePagamento.add(visualizarFP);
		formaDePagamento.add(editarFP);
		formaDePagamento.add(deletarFP);
		
		this.add(cliente);
		this.add(pedido);
		this.add(pizza);
		this.add(formaDePagamento);
	}
	
	public void actionPerformed(ActionEvent e) {    
		if(e.getSource()==create) {
			new ClienteCreateFrame(status);
		}
	}   
}
