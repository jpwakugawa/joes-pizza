package FormaDePagamento;
import javax.swing.*;

public class FormaDePagamentoCreateFrame extends JFrame {
	JTextField   tipoText;
	JCheckBox    ativoCheckB;
	JButton      salvarButton;
	JLabel       tipoLabel, moedaLabel, status;
	JRadioButton realRadioB, dolarRadioB, guaraniRadioB;
	
	public FormaDePagamentoCreateFrame(JLabel status){
		setTitle("Cadastro de Forma de Pagamento");
		setSize(500, 500);
		setLayout(null);
		
		this.status = status;
		status.setText("Cadastrando nova Forma de Pagamento");
		
		setBounds(500, 500, 500, 500);
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
		
		this.add(tipoLabel); this.add(tipoText);
		this.add(moedaLabel); this.add(realRadioB); this.add(dolarRadioB); this.add(guaraniRadioB);
		this.add(ativoCheckB); this.add(salvarButton);
		
		setVisible(true);
	}
	

}
