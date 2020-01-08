package java_swing_teacher.chap09.layout.exam;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam8 extends JFrame {

	private JPanel contentPane;
	private Exam8NorthPanel pNorth;
	private Exam8CenterPanel pCenter;
	private Exam8SouthPanel pSouth;

	public Exam8() {
		initialize();
	}
	private void initialize() {
		setTitle("문제 8번");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pNorth = new Exam8NorthPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		pCenter = new Exam8CenterPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		pSouth = new Exam8SouthPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
	}

}
