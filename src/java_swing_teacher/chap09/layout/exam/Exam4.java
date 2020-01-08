package java_swing_teacher.chap09.layout.exam;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam4 extends JFrame {

	private JPanel contentPane;

	public Exam4() {
		initialize();
	}
	private void initialize() {
		setTitle("문제4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		Random rnd = new Random();
		for(int i=0; i<10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			btn.setBackground(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
			contentPane.add(btn);
		}
	}

}
