package Cliente;

import javax.swing.*;

import FormaDePagamento.FormaDePagamento;
import Pizza.Pizza;

import java.awt.event.*;
import Principal.Gerenciador;
import java.util.ArrayList;

// Janela para realizar cadastro de cliente
public class ClienteCreateFrame extends JFrame {
	JLabel nomeLabel, cpfLabel, enderecoLabel, FPLabel, status;
	JTextField nomeText, cpfText, enderecoText;
	JButton submitButton;
	JComboBox<String> FPCBox;
	ArrayList<FormaDePagamento> listaFormasDePagamento = Gerenciador.getListaDeFormasDePagamentos();

	public ClienteCreateFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Cadastro de Cliente");
		setSize(500, 500);
		setLayout(null);
		status.setText("Cadastrando novo cliente");
	}
	
	private void configComponente() {
		nomeLabel = new JLabel("Nome: ");
		nomeLabel.setBounds(30, 100, 200, 30);
		nomeText = new JTextField();
		nomeText.setBounds(110, 100, 200, 30);
		
		cpfLabel = new JLabel("CPF: ");
		cpfLabel.setBounds(30, 150, 200, 30);
		cpfText = new JTextField();
		cpfText.setBounds(110, 150, 200, 30);
		
		enderecoLabel = new JLabel("Endere√ßo: ");
		enderecoLabel.setBounds(30, 200, 200, 30);
		enderecoText = new JTextField();
		enderecoText.setBounds(110, 200, 200, 30);
		
		FPLabel = new JLabel("Selecione a Forma de Pagamento: ");
		FPLabel.setBounds(10, 250, 300, 30);
		FPCBox = new JComboBox<String>();
		FPCBox.setBounds(110, 280, 300, 30);
		
		submitButton = new JButton("submit");
		submitButton.setBounds(110, 350, 200, 30);
		submitButton.addActionListener(new ButtonClickListener());
		
		addComboBox();
		add(nomeLabel);add(cpfLabel);add(enderecoLabel);add(FPLabel);add(FPCBox);
		add(nomeText);add(cpfText);add(enderecoText);add(submitButton);
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
		//Adicionando itens da Forma de Pagamento
		for(FormaDePagamento fp : listaFormasDePagamento) {
			if(fp.getAtivo() != "N√O") {
				FPCBox.addItem(fp.toStringPedido());
			}
			
		}
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			int fpSelecionada = FPCBox.getSelectedIndex();
			if( command.equals( "submit" ) )  {
				try {
					FormaDePagamento FPPedido      = listaFormasDePagamento.get(fpSelecionada);
					Cliente novoCliente = new Cliente(nomeText.getText(), enderecoText.getText(), cpfText.getText(), FPPedido);
					ArrayList<Cliente> listaDePedidos = Gerenciador.getListaDeClientes();
					listaDePedidos.add(novoCliente);
					status.setText("Novo Cliente Criado!");	
				} catch (Exception exception) {
					status.setText(exception.getMessage());
				}

	         }
	   }
   }
}