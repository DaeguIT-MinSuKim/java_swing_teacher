package java_swing_teacher.chap09.layout.exam;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Exam8CenterPanel extends JPanel {
	private Dimension dim;
	public Exam8CenterPanel() {
		initialize();
	}
	private void initialize() {
		setLayout(null);
		dim = new Dimension(430, 180);
		setMinimumSize(dim);
		setSize(dim);
		Random rnd = new Random();
		
		for(int i=0; i<10; i++) {
			JLabel lbl = new JLabel("*");
			lbl.setOpaque(true);
			lbl.setSize(15, 15);
			lbl.setLocation(rnd.nextInt((int)dim.getWidth())-10, rnd.nextInt((int)dim.getHeight())-10);
			lbl.setForeground(Color.RED);
			add(lbl);
		}
		
		

	}
	
}
