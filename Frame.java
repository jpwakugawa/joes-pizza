import javax.swing.*;
import java.awt.*;

public class Frame {
	Frame() {
		JFrame janela = new JFrame("Pizzaria Z");
		Menu menu = new Menu();
		janela.setJMenuBar(menu);
		janela.setVisible(true);
		janela.setSize(1000, 1000);
		janela.setLayout(new BorderLayout());
		
		JLabel status = new JLabel("Status");
		janela.add(status, BorderLayout.SOUTH);
	}
}
 