package Pedido;

import javax.swing.*;
import java.awt.event.*;
import Principal.Gerenciador;
import java.util.ArrayList;

// Janela para realizar deleção de pedido
public class PedidoDeleteFrame extends JFrame {
	JLabel     avisoLabel, idLabel, status;
	JTextField idText;
	JButton    submitButton;
	
	public PedidoDeleteFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Deleção de Pedidos");
		setSize(500, 500);
		setLayout(null);
		status.setText("Deletando Pedidos");
	}
	
	private void configComponente() {
		avisoLabel = new JLabel("Insira o ID do pedido para deletar!");
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
			int id = Integer.parseInt(idText.getText());
			ArrayList<Pedido> listaDePedidos = Gerenciador.getListaDePedidos();
			listaDePedidos.remove(id);
			
			for(Pedido pedidos : listaDePedidos) {
				Pedido novosPedidos = pedidos;
				novosPedidos.setId(novosPedidos.getId());
			}
				status.setText("Pedido Deletado!");
	    }
   }

}