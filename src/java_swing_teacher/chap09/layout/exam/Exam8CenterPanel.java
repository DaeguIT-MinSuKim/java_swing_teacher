package java_swing_teacher.chap09.layout.exam;

import java.awt.Color;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Exam8CenterPanel extends JPanel {

	public Exam8CenterPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		Random rnd = new Random();
		
		for(int i=0; i<10; i++) {
			JLabel lbl = new JLabel("*");
			lbl.setOpaque(true);
			lbl.setBounds(rnd.nextInt(430), rnd.nextInt(180), 15, 15);
			lbl.setForeground(Color.RED);
			add(lbl);
		}

	}

}
