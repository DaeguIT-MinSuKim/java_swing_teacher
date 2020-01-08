package java_swing_teacher.chap09.layout.exam;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam5 extends JFrame {

	private JPanel contentPane;

	public Exam5() {
		initialize();
	}
	private void initialize() {
		setTitle("문제5");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		Random rnd = new Random();
		for(int i=0; i<16; i++) {
			JLabel lbl = new JLabel(Integer.toString(i));
			lbl.setOpaque(true);
			lbl.setBackground(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
			contentPane.add(lbl);
		}
	}

}
