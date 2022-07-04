package Pedido;
import javax.swing.*;
import Cliente.Cliente;
import FormaDePagamento.FormaDePagamento;
import Pizza.Pizza;
import Principal.Gerenciador;

import java.awt.event.*;
import java.util.ArrayList;

public class PedidoCreateFrame extends JFrame{
	JLabel clienteLabel, pizzaLabel, status;
	JButton submitButton;
	ArrayList<Cliente> listaDeClientes = Gerenciador.getListaDeClientes();
	ArrayList<Pizza> listaDePizzas = Gerenciador.getListaDePizzas();
	JComboBox<String> clientesCBox, pizzaCBox;
	
	public PedidoCreateFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Cadastro de Pedido");
		setSize(500, 500);
		setLayout(null);
		status.setText("Cadastrando novo pedido");
	}
	
	private void configComponente() {
		clienteLabel = new JLabel("Selecione o Cliente: ");
		clienteLabel.setBounds(10, 120, 200, 30);
		clientesCBox = new JComboBox<String>();
		clientesCBox.setBounds(150, 150, 200, 30);
		
		pizzaLabel = new JLabel("Selecione a Pizza: ");
		pizzaLabel.setBounds(10, 170, 200, 30);
		pizzaCBox = new JComboBox<>();
		pizzaCBox.setBounds(150, 200, 200, 30);
		
		
		
		submitButton = new JButton("submit");
		submitButton.setBounds(150, 300, 200, 30);
		submitButton.addActionListener(new ButtonClickListener());
		
		addComboBox();
		add(clienteLabel);add(clientesCBox);
		add(pizzaLabel);add(pizzaCBox);add(submitButton);
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
	
	private void addComboBox() {
		//Adicionando itens do Cliente
		for(Cliente cliente : listaDeClientes) {
			clientesCBox.addItem(cliente.toStringPedido());
		}
		
		//Adicionando sabores da Pizza
		for(Pizza pizza : listaDePizzas) {
			pizzaCBox.addItem(pizza.toStringPedido());
		}

	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			int clienteSelecionado, pizzaSelecionada;
			
			if( command.equals( "submit" ) )  {
				clienteSelecionado = clientesCBox.getSelectedIndex();
				pizzaSelecionada   = pizzaCBox.getSelectedIndex();
				
				Pizza            pizzaPedido   = listaDePizzas.get(pizzaSelecionada);
				Cliente          clientePedido = listaDeClientes.get(clienteSelecionado);
				
				Pedido novoPedido = new Pedido(pizzaPedido, clientePedido);
				ArrayList<Pedido> listaDePedidos = Gerenciador.getListaDePedidos();
				listaDePedidos.add(novoPedido);
				status.setText("Novo Pedido Criado!");
	         }
	   }
   }
}
