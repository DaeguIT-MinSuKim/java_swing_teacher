package java_swing_teacher.chap09.layout.exam;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam7 extends JFrame {

	private JPanel contentPane;
	private Exam7NorthPanel pNorth;
	private Exam7CenterPanel pCenter;
	private Exam7SouthPanel pSouth;

	public Exam7() {
		initialize();
	}
	private void initialize() {
		setTitle("문제7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pNorth = new Exam7NorthPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		pCenter = new Exam7CenterPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		pSouth = new Exam7SouthPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
	}

}
