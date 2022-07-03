package Pedido;
import javax.swing.*;

import Cliente.Cliente;
import FormaDePagamento.FormaDePagamento;
import Principal.Gerenciador;

import java.awt.event.*;
import java.util.ArrayList;

public class PedidoCreateFrame extends JFrame{
	JLabel idPizzaLabel, idClienteLabel, status;
	JTextField idPizzaText, idClienteText;
	JButton submitButton;
	ArrayList<FormaDePagamento> listaFormasDePagamento = Gerenciador.getListaDeFormasDePagamentos();
	ArrayList<Cliente> listaDeClientes = Gerenciador.getListaDeClientes();
	JComboBox<String> FPCBox, clientesCBox;
	
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
		idPizzaLabel = new JLabel("Selecione a Forma de Pagamento: ");
		idPizzaLabel.setBounds(10, 70, 300, 30);
		FPCBox = new JComboBox<String>();
		FPCBox.setBounds(150, 100, 200, 30);
		//idPizzaText = new JTextField();
		//idPizzaText.setBounds(150, 100, 200, 30);
		
		idClienteLabel = new JLabel("ID Cliente: ");
		idClienteLabel.setBounds(30, 150, 200, 30);
		clientesCBox = new JComboBox<String>();
		clientesCBox.setBounds(150, 150, 200, 30);
		//idClienteText = new JTextField();
		//idClienteText.setBounds(150, 150, 200, 30);
		
		submitButton = new JButton("submit");
		submitButton.setBounds(150, 250, 200, 30);
		submitButton.addActionListener(new ButtonClickListener());
		
		addComboBox();
		add(idPizzaLabel);add(idClienteLabel);
		//add(idPizzaText);add(idClienteText);
		add(submitButton);add(FPCBox);add(clientesCBox);
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
			clientesCBox.addItem(cliente.getNome() + " | " + cliente.getEndereco());
		}
		
		//Adicionando itens da Forma de Pagamento
		for(FormaDePagamento fp : listaFormasDePagamento) {
			if(fp.getAtivo() != "NÃO") {
				FPCBox.addItem(fp.getId() + " | " + fp.getTipo() +" | " + fp.getMoeda());
			}
			
		}
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			int fpSelecionada, clienteSelecionado;
			
			if( command.equals( "submit" ) )  {
				fpSelecionada = FPCBox.getSelectedIndex();
				clienteSelecionado = clientesCBox.getSelectedIndex();
				FormaDePagamento FPPedido = listaFormasDePagamento.get(fpSelecionada);
				Cliente          clientePedido = listaDeClientes.get(clienteSelecionado);
				
				Pedido p = new Pedido(null, clientePedido, FPPedido);
				status.setText("Novo Pedido Criado!");
	         }
	   }
   }
}
