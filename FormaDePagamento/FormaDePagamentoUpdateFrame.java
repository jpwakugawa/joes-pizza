package FormaDePagamento;
import javax.swing.*;

import Principal.Gerenciador;

import java.awt.event.*;
import java.util.ArrayList;

public class FormaDePagamentoUpdateFrame extends JFrame {
	JTextField       tipoText, idText;
	JCheckBox        ativoCheckB;
	JButton          editarButton, cancelarButton;
	FormaDePagamento novaFP;
	String           tipoMoeda, ativoTF;
	JLabel           tipoLabel, moedaLabel, idLabel, status;
	JRadioButton     realRadioB, dolarRadioB, guaraniRadioB;
	
	public FormaDePagamentoUpdateFrame(JLabel status) {
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}

	private void configJanela() {
		setTitle("Edição de Formas de Pagamento");
		setSize(500, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		status.setText("Editando Formas de Pagamento");
		
	}

	private void configComponente() {
		setBounds(500, 500, 500, 500);
		idLabel       = new JLabel("ID:");
		idLabel.setBounds(30, 50, 200, 30);
		idText		  = new JTextField();
		idText.setBounds(110, 50, 200, 30);
		tipoLabel     = new JLabel("Descrição:");
		tipoLabel.setBounds(30, 100, 200, 30);
		tipoText      = new JTextField();
		tipoText.setBounds(110, 100, 200, 30);
		
		moedaLabel    = new JLabel("Moeda:");
		moedaLabel.setBounds(30, 150, 200, 30);
		
		realRadioB    = new JRadioButton("REAL");
		realRadioB.setBounds(110, 150, 90, 30);
		dolarRadioB   = new JRadioButton("DOLAR");
		dolarRadioB.setBounds(200, 150, 90, 30);
		guaraniRadioB = new JRadioButton("GUARANI");
		guaraniRadioB.setBounds(290, 150, 90, 30);
		
		ButtonGroup moedas = new ButtonGroup();
		moedas.add(realRadioB);
		moedas.add(dolarRadioB);
		moedas.add(guaraniRadioB);
		
		ativoCheckB   = new JCheckBox("Está ativa? ");
		ativoCheckB.setBounds(110, 200, 200, 30);
		
		editarButton = new JButton("Salvar alterações");
		editarButton.setBounds(110, 250, 200, 30);
		editarButton.addActionListener(new ButtonClickListener());
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(110, 300, 200, 30);
		cancelarButton.addActionListener(new ButtonClickListener());
		
		this.add(idLabel); this.add(idText); this.add(tipoLabel); this.add(tipoText);
		this.add(moedaLabel); this.add(realRadioB); this.add(dolarRadioB); this.add(guaraniRadioB);
		this.add(ativoCheckB); this.add(editarButton); this.add(cancelarButton);
		
	}
	
	private void descricaoButton() {
		if(realRadioB.isSelected()) {
			tipoMoeda = "REAL";
		} else if(dolarRadioB.isSelected()) {
			tipoMoeda = "DOLAR";
		} else {
			tipoMoeda = "GUARANI";
		}
		
		if(ativoCheckB.isSelected()) {
			ativoTF = "SIM";
		} else {
			ativoTF = "NÃO";
		}
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
			
			if( command.equals( "Salvar alterações" ) )  {
				int id = Integer.parseInt(idText.getText());
				descricaoButton();
				novaFP = new FormaDePagamento(id, tipoText.getText(), tipoMoeda, ativoTF);
				ArrayList<FormaDePagamento> listaDeFormasDePagamentos = Gerenciador.getListaDeFormasDePagamentos();
				listaDeFormasDePagamentos.set(id, novaFP);
				status.setText("Forma de Pagamento atualizada!");
	         }
			else if(command.equals( "Cancelar" )) {
				tipoText.setText(""); ativoCheckB.setSelected(false);
				status.setText("Alterações na Forma de Pagamento cancelada!");
			}
	   }	
   }
}
