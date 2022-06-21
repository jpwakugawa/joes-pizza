package Cliente;
import javax.swing.*;
import java.awt.event.*;

// Janela para realizar cadastro de cliente
public class ClienteCreateFrame extends JFrame {
	JLabel nomeLabel, cpfLabel, enderecoLabel, status;
	JTextField nomeText, cpfText, enderecoText;
	JButton submitButton;
	Cliente novoCliente;

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
		
		enderecoLabel = new JLabel("Endereço: ");
		enderecoLabel.setBounds(30, 200, 200, 30);
		enderecoText = new JTextField();
		enderecoText.setBounds(110, 200, 200, 30);
		
		submitButton = new JButton("submit");
		submitButton.setBounds(110, 250, 200, 30);
		submitButton.addActionListener(new ButtonClickListener());
		
		add(nomeLabel);add(cpfLabel);add(enderecoLabel);
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
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  

			if( command.equals( "submit" ) )  {
				novoCliente = new Cliente(nomeText.getText(), enderecoText.getText(), cpfText.getText());
				status.setText("Novo Cliente Criado!");
	            System.out.println(novoCliente.getListaDeClientes());
	         }
	   }	
   }
}