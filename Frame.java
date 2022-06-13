import javax.swing.JFrame;

public class Frame {
	Frame() {
		JFrame janela = new JFrame("Pizzaria Z");
		Menu menu = new Menu();
		janela.setJMenuBar(menu);
		janela.setVisible(true);
		janela.setSize(1000, 1000);
		janela.setLayout(null);
	}
}
