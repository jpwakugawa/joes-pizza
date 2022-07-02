package FormaDePagamento;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import Principal.Gerenciador;

public class FormaDePagamentoDeleteFrame extends JFrame {
	JTextField idText;
	JLabel     idLabel, avisoLabel, status;
	JButton    deletarButton;
	
	public FormaDePagamentoDeleteFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}

	private void configJanela() {
		setTitle("Deletar Forma de Pagamento");
		setSize(500, 500);
		setLayout(null);
		status.setText("Deletando Forma de Pagamento");
		
	}

	private void configComponente() {
		avisoLabel = new JLabel("Insira o ID do cliente para deletar!");
		avisoLabel.setBounds(30, 10, 300, 30);
		
		idLabel       = new JLabel("ID:");
		idLabel.setBounds(30, 100, 200, 30);
		idText		  = new JTextField();
		idText.setBounds(110, 100, 200, 30);
		
		deletarButton = new JButton("Deletar");
		deletarButton.setBounds(110, 150, 200, 30);
		deletarButton.addActionListener(new ButtonClickListener());
		
		add(avisoLabel); add(idLabel);
		add(idText); add(deletarButton);
		
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

			if( command.equals( "Deletar" ) )  {
				int id = Integer.parseInt(idText.getText());
				ArrayList<FormaDePagamento> listaDeFormasDePagamentos = Gerenciador.getListaDeFormasDePagamentos();
				listaDeFormasDePagamentos.remove(id);
				
				for(FormaDePagamento fp : listaDeFormasDePagamentos) {
					FormaDePagamento novaFP = fp;
					novaFP.setId(fp.getId());
				}
				
				status.setText("Forma de Pagamento Deletada!");
	         }
		}
   }
}
