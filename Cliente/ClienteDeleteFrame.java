package Cliente;
import java.awt.event.*;
import javax.swing.*;

public class ClienteDeleteFrame extends JFrame {
	JLabel     avisoLabel, idLabel, status;
	JTextField idText;
	JButton    submitButton;
	Cliente    cliente;
	
	public ClienteDeleteFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Deleção de Clientes");
		setSize(500, 500);
		setLayout(null);
		status.setText("Deletando Clientes");
	}
	
	private void configComponente() {
		avisoLabel = new JLabel("Insira o ID do cliente para deletar!");
		avisoLabel.setBounds(30, 10, 300, 30);
		
		idLabel = new JLabel("Id: ");
		idLabel.setBounds(30, 100, 200, 30);
		idText = new JTextField();
		idText.setBounds(110, 100, 200, 30);
		
		
		submitButton = new JButton("delete");
		submitButton.setBounds(110, 150, 200, 30);
		submitButton.addActionListener(new ButtonClickListener());
		
		add(avisoLabel);add(idLabel);
		add(idText);add(submitButton);
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

			if( command.equals( "delete" ) )  {
				cliente = new Cliente();
				
				int id = Integer.parseInt(idText.getText());
				status.setText("Cliente Deletado!");
	            System.out.println(cliente.getListaDeClientes());
	         }
		}
   }

}
