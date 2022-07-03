package Pedido;
import javax.swing.*;
import Cliente.Cliente;
import FormaDePagamento.FormaDePagamento;
import Pizza.Pizza;
import Principal.Gerenciador;

import java.awt.event.*;
import java.util.ArrayList;

public class PedidoCreateFrame extends JFrame{
	JLabel FPLabel, clienteLabel, pizzaLabel, status;
	JButton submitButton;
	ArrayList<FormaDePagamento> listaFormasDePagamento = Gerenciador.getListaDeFormasDePagamentos();
	ArrayList<Cliente> listaDeClientes = Gerenciador.getListaDeClientes();
	ArrayList<Pizza> listaDePizzas = Gerenciador.getListaDePizzas();
	JComboBox<String> FPCBox, clientesCBox, pizzaCBox;
	
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
		FPLabel = new JLabel("Selecione a Forma de Pagamento: ");
		FPLabel.setBounds(10, 70, 300, 30);
		FPCBox = new JComboBox<String>();
		FPCBox.setBounds(150, 100, 200, 30);
		
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
		add(FPLabel);add(FPCBox);add(clienteLabel);add(clientesCBox);
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
		
		//Adicionando itens da Forma de Pagamento
		for(FormaDePagamento fp : listaFormasDePagamento) {
			if(fp.getAtivo() != "NÃO") {
				FPCBox.addItem(fp.toStringPedido());
			}
			
		}
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			int fpSelecionada, clienteSelecionado, pizzaSelecionada;
			
			if( command.equals( "submit" ) )  {
				fpSelecionada      = FPCBox.getSelectedIndex();
				clienteSelecionado = clientesCBox.getSelectedIndex();
				pizzaSelecionada   = pizzaCBox.getSelectedIndex();
				
				Pizza            pizzaPedido   = listaDePizzas.get(pizzaSelecionada);
				Cliente          clientePedido = listaDeClientes.get(clienteSelecionado);
				FormaDePagamento FPPedido      = listaFormasDePagamento.get(fpSelecionada);
				
				Pedido novoPedido = new Pedido(pizzaPedido, clientePedido, FPPedido);
				ArrayList<Pedido> listaDePedidos = Gerenciador.getListaDePedidos();
				listaDePedidos.add(novoPedido);
				status.setText("Novo Pedido Criado!");
	         }
	   }
   }
}
