package Telas.Pedido;
import javax.swing.*;
import java.awt.event.*;

public class PedidoCreateFrame extends JFrame{
	JLabel     idPizzaLabel, idClienteLabel, status;
	JTextField idPizzaText, idClienteText;
	JButton    submitButton;
	
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
		idPizzaLabel = new JLabel("IDs das Pizzas: ");
		idPizzaLabel.setBounds(30, 100, 200, 30);
		idPizzaText = new JTextField();
		idPizzaText.setBounds(150, 100, 200, 30);
		
		idClienteLabel = new JLabel("ID Cliente: ");
		idClienteLabel.setBounds(30, 150, 200, 30);
		idClienteText = new JTextField();
		idClienteText.setBounds(150, 150, 200, 30);
		
		submitButton = new JButton("submit");
		submitButton.setBounds(150, 250, 200, 30);
		submitButton.addActionListener(
				(e) -> {
					String command = e.getActionCommand();  

					if( command.equals( "submit" ) )  {
						status.setText("Novo Pedido Criado!");
			         }
				});
		
		add(idPizzaLabel);add(idClienteLabel);
		add(idPizzaText);add(idClienteText);add(submitButton);
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
	
}
