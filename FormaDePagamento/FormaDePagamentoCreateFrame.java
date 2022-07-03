package FormaDePagamento;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import Principal.Gerenciador;

public class FormaDePagamentoCreateFrame extends JFrame {
	JTextField       tipoText;
	JCheckBox        ativoCheckB;
	JButton          salvarButton;
	FormaDePagamento novaFP;
	String           tipoMoeda, ativoTF;
	JLabel           tipoLabel, moedaLabel, status;
	JRadioButton     realRadioB, dolarRadioB, guaraniRadioB;
	
	public FormaDePagamentoCreateFrame(JLabel status){
		this.status = status;
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Cadastro de Forma de Pagamento");
		setSize(500, 500);
		setLayout(null);
		status.setText("Cadastrando nova Forma de Pagamento");
	}
	
	private void configComponente() {
		tipoLabel     = new JLabel("Descrição:");
		tipoLabel.setBounds(30, 100, 200, 30);
		tipoText      = new JTextField();
		tipoText.setBounds(110, 100, 200, 30);
		
		moedaLabel    = new JLabel("Moeda:");
		moedaLabel.setBounds(30, 150, 200, 30);
		
		realRadioB    = new JRadioButton("REAL");
		realRadioB.setBounds(110, 150, 90, 30);
		realRadioB.setSelected(true);
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
		ativoCheckB.setSelected(true);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setBounds(110, 250, 200, 30);
		salvarButton.addActionListener(new ButtonClickListener());
		
		this.add(tipoLabel); this.add(tipoText);
		this.add(moedaLabel); this.add(realRadioB); this.add(dolarRadioB); this.add(guaraniRadioB);
		this.add(ativoCheckB); this.add(salvarButton);
	}
	
	private void configEvento() {
		addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e){
	            status.setText("Status");
	        }
	    });
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
	
	private void end() {
		setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			
			if( command.equals( "Salvar" ) )  {
				try {
					descricaoButton();
					novaFP = new FormaDePagamento(tipoText.getText(), tipoMoeda, ativoTF);
					ArrayList<FormaDePagamento> listaDeFormasDePagamentos = Gerenciador.getListaDeFormasDePagamentos();
					listaDeFormasDePagamentos.add(novaFP);
					status.setText("Nova Forma de Pagamento Cadastrada!");
					tipoText.setText("");
				}
				catch (Exception exception) {
					status.setText(exception.getMessage());
				}
	   
	         }
	   }	
   }
	

}
