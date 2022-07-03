package Pedido;

import javax.swing.*;
import java.awt.event.*;
import Principal.Gerenciador;
import java.util.ArrayList;

public class PedidoUpdateFrame extends JFrame {
		JLabel     avisoLabel, idLabel, nomeLabel, cpfLabel, enderecoLabel, status;
		JTextField idText, nomeText, cpfText, enderecoText;
		JButton    submitButton;
		
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
			
			submitButton = new JButton("edit");
			submitButton.setBounds(110, 250, 200, 30);
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

				if( command.equals( "edit" ) )  {
					int id = Integer.parseInt(idText.getText());
					String nome = nomeText.getText();
					String endereco = enderecoText.getText();
					String cpf = cpfText.getText();
					
					//Pedido pedido = new Pedido();
					//ArrayList<Pedido> listaDePedidos = Gerenciador.getListaDePedidos();
					//listaDePedidos.set(id, pedido);
					
					status.setText("Pedido Editado!");
		         }
		   }	
	   }
	}