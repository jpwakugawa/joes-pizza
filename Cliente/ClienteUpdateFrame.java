package Cliente;
import java.awt.event.*;
import javax.swing.*;

// Janela para editar clientes
public class ClienteUpdateFrame extends JFrame {
	JLabel     avisoLabel, idLabel, nomeLabel, cpfLabel, enderecoLabel, status;
	JTextField idText, nomeText, cpfText, enderecoText;
	JButton    submitButton;
	Cliente    cliente;
	
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
		
		submitButton = new JButton("edit");
		submitButton.setBounds(110, 250, 200, 30);
		submitButton.addActionListener(new ButtonClickListener());
		
		add(avisoLabel);add(idLabel);add(nomeLabel);add(cpfLabel);add(enderecoLabel);
		add(idText);add(nomeText);add(cpfText);add(enderecoText);add(submitButton);
		
		
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
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  

			if( command.equals( "edit" ) )  {
				/*
				cliente = new Cliente();
				
				int id = Integer.parseInt(idText.getText());
				String nome = nomeText.getText();
				String endereco = enderecoText.getText();
				String cpf = cpfText.getText();
				cliente.updateLista(id, nome, endereco, cpf);
				
				status.setText("Cliente Editado!");
	            System.out.println(cliente.getListaDeClientes());
	         	*/
	         }
	   }	
   }
}
