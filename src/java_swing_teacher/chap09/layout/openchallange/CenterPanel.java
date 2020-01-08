package java_swing_teacher.chap09.layout.openchallange;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	private JLabel lblHello;
	private JLabel lblJava;
	private JLabel lblLove;

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		lblHello = new JLabel("Hello");
		lblHello.setBounds(125, 39, 57, 15);
		add(lblHello);
		
		lblJava = new JLabel("Java");
		lblJava.setBounds(48, 200, 57, 15);
		add(lblJava);
		
		lblLove = new JLabel("Love");
		lblLove.setBounds(347, 200, 57, 15);
		add(lblLove);
	}

}
