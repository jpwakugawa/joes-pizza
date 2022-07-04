package Cliente;

import javax.swing.*;

import FormaDePagamento.FormaDePagamento;
import Pizza.Pizza;

import java.awt.event.*;
import Principal.Gerenciador;
import java.util.ArrayList;


// Janela para editar clientes
public class ClienteUpdateFrame extends JFrame {
	JLabel     avisoLabel, idLabel, nomeLabel, cpfLabel, enderecoLabel, FPLabel, status;
	JTextField idText, nomeText, cpfText, enderecoText;
	JButton    submitButton, buscarButton;
	JComboBox<String> FPCBox;
	ArrayList<FormaDePagamento> listaFormasDePagamento = Gerenciador.getListaDeFormasDePagamentos();
	
	public ClienteUpdateFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Edição de Clientes");
		setSize(500, 500);
		setLayout(null);
		status.setText("Editando Clientes");
	}
	
	private void configComponente() {
		avisoLabel = new JLabel("Insira o ID correto para editar!");
		avisoLabel.setBounds(30, 10, 300, 30);
		
		idLabel = new JLabel("Id: ");
		idLabel.setBounds(30, 50, 200, 30);
		idText = new JTextField();
		idText.setBounds(110, 50, 200, 30);
		
		nomeLabel = new JLabel("Nome: ");
		nomeLabel.setBounds(30, 100, 200, 30);
		nomeText = new JTextField();
		nomeText.setBounds(110, 100, 200, 30);
		
		cpfLabel = new JLabel("CPF: ");
		cpfLabel.setBounds(30, 150, 200, 30);
		cpfText = new JTextField();
		cpfText.setBounds(110, 150, 200, 30);
		
		enderecoLabel = new JLabel("Endereço: ");
		enderecoLabel.setBounds(30, 200, 200, 30);
		enderecoText = new JTextField();
		enderecoText.setBounds(110, 200, 200, 30);
		
		FPLabel = new JLabel("Selecione a Forma de Pagamento: ");
		FPLabel.setBounds(10, 250, 300, 30);
		FPCBox = new JComboBox<String>();
		FPCBox.setBounds(110, 300, 300, 30);
		
		buscarButton = new JButton(new ImageIcon("./Imagens/icon_search.png"));
		buscarButton.setBounds(320, 50, 30, 30);
		buscarButton.addActionListener(new ButtonClickListener());
		
		submitButton = new JButton("edit");
		submitButton.setBounds(110, 350, 200, 30);
		submitButton.addActionListener(new ButtonClickListener());
		
		addComboBox();
		add(avisoLabel);add(idLabel);add(nomeLabel);add(cpfLabel);add(enderecoLabel);
		add(idText);add(nomeText);add(cpfText);add(enderecoText);add(submitButton);
		add(FPLabel);add(FPCBox);add(buscarButton);
		
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
			if(fp.getAtivo() != "N�O") {
				FPCBox.addItem(fp.toStringPedido());
			}
			
		}
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			int id = Integer.parseInt(idText.getText());
			int fpSelecionada;
			if( command.equals( "edit" ) )  {
				try {
					
					fpSelecionada      = FPCBox.getSelectedIndex();
					String nome = nomeText.getText();
					String endereco = enderecoText.getText();
					String cpf = cpfText.getText();
					
					FormaDePagamento FPPedido      = listaFormasDePagamento.get(fpSelecionada);
					Cliente cliente = new Cliente(id, nome, endereco, cpf, FPPedido);
					ArrayList<Cliente> listaDeClientes = Gerenciador.getListaDeClientes();
					listaDeClientes.set(id, cliente);
					
					status.setText("Cliente Editado!");
				} catch (Exception exception) {
					status.setText(exception.getMessage());
				}

	         }
			if( command.equals("")) {
				ArrayList<Cliente> listaDeClientes = Gerenciador.getListaDeClientes();
				nomeText.setText(listaDeClientes.get(id).getNome());
				cpfText.setText(listaDeClientes.get(id).getCpf());
				enderecoText.setText(listaDeClientes.get(id).getEndereco());
			}
	    }	
   }
}
