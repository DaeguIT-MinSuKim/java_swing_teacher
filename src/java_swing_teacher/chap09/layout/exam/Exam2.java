package java_swing_teacher.chap09.layout.exam;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam2 extends JFrame {

	private JPanel contentPane;
	private JButton btnNorth;
	private JButton btnWest;
	private JButton btnEast;
	private JButton btnSouth;
	private JButton btnCenter;

	public Exam2() {
		initialize();
	}
	private void initialize() {
		setTitle("문제2번");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 7));
		setContentPane(contentPane);
		
		btnNorth = new JButton("North");
		contentPane.add(btnNorth, BorderLayout.NORTH);
		
		btnWest = new JButton("West");
		contentPane.add(btnWest, BorderLayout.WEST);
		
		btnEast = new JButton("East");
		contentPane.add(btnEast, BorderLayout.EAST);
		
		btnSouth = new JButton("South");
		contentPane.add(btnSouth, BorderLayout.SOUTH);
		
		btnCenter = new JButton("Center");
		contentPane.add(btnCenter, BorderLayout.CENTER);
	}

}
