package Pedido;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import Cliente.Cliente;
import FormaDePagamento.FormaDePagamento;
import Pizza.Pizza;
import Principal.Gerenciador;

public class PedidoUpdateFrame extends JFrame {
		JLabel     idLabel, avisoLabel, FPLabel, clienteLabel, pizzaLabel, status;
		JTextField idText;
		JComboBox<String> FPCBox, clientesCBox, pizzaCBox;
		JButton    submitButton;
		ArrayList<FormaDePagamento> listaFormasDePagamento = Gerenciador.getListaDeFormasDePagamentos();
		ArrayList<Cliente> listaDeClientes = Gerenciador.getListaDeClientes();
		ArrayList<Pizza> listaDePizzas = Gerenciador.getListaDePizzas();
		
		public PedidoUpdateFrame(JLabel status) {
			this.status = status;
			configJanela();
			configComponente();
			configEvento();
			end();
		}
		
		private void configJanela() {
			setTitle("Edição de Pedidos");
			setSize(500, 500);
			setLayout(null);
			status.setText("Editando Pedidos");
		}
		
		private void configComponente() {
			avisoLabel = new JLabel("Insira o ID correto para editar!");
			avisoLabel.setBounds(30, 10, 300, 30);
			
			idLabel = new JLabel("Id: ");
			idLabel.setBounds(30, 50, 200, 30);
			idText = new JTextField();
			idText.setBounds(110, 50, 200, 30);
			
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
			
			submitButton = new JButton("edit");
			submitButton.setBounds(110, 300, 200, 30);
			submitButton.addActionListener(new ButtonClickListener());
			
			addComboBox();
			
			add(avisoLabel);add(idLabel);
			add(idText);add(submitButton);
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
				if(fp.getAtivo() != "N�O") {
					FPCBox.addItem(fp.toStringPedido());
				}
				
			}
		}
		
		private class ButtonClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();  
				int id         = Integer.parseInt(idText.getText());
				int fpSelecionada, clienteSelecionado, pizzaSelecionada;
				
				if( command.equals( "edit" ) )  {
					fpSelecionada      = FPCBox.getSelectedIndex();
					clienteSelecionado = clientesCBox.getSelectedIndex();
					pizzaSelecionada   = pizzaCBox.getSelectedIndex();
					
					Pizza            pizzaPedido   = listaDePizzas.get(pizzaSelecionada);
					Cliente          clientePedido = listaDeClientes.get(clienteSelecionado);
					FormaDePagamento FPPedido      = listaFormasDePagamento.get(fpSelecionada);
					
					Pedido novoPedido = new Pedido(id, pizzaPedido, clientePedido, FPPedido);
					ArrayList<Pedido> listaDePedidos = Gerenciador.getListaDePedidos();
					listaDePedidos.set(id, novoPedido);
					
					status.setText("Pedido Editado!");
		         }
		   }	
	   }
	}