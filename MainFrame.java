import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
	MainFrame() {
		configJanela();
		configComponente();
		configEvento();
		end();
	}
	
	private void configJanela() {
		setTitle("Pizzaria Z");
		setSize(1000, 1000);
		setLayout(new BorderLayout());
	}
	
	private void configComponente() {		
		JLabel status = new JLabel("Status");
		add(status, BorderLayout.SOUTH);
		
		Menu menu = new Menu(status);
		setJMenuBar(menu);
	}
	
	private void configEvento() {
		
	}
	
	private void end() {
		setVisible(true);
	}
}
 