package java_swing_teacher.chap09.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BorderLayoutEx extends JFrame {

	private JPanel contentPane;
	private JButton btnCenter;
	private JButton btnNorth;
	private JButton btnSouth;
	private JButton btnWest;
	private JButton btnEast;

	public BorderLayoutEx() {
		initialize();
	}
	private void initialize() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(30, 20));
		setContentPane(contentPane);
		
		btnCenter = new JButton("Calculate");
		contentPane.add(btnCenter, BorderLayout.CENTER);
		
		btnNorth = new JButton("Add");
		contentPane.add(btnNorth, BorderLayout.NORTH);
		
		btnSouth = new JButton("Sub");
		contentPane.add(btnSouth, BorderLayout.SOUTH);
		
		btnWest = new JButton("Div");
		contentPane.add(btnWest, BorderLayout.WEST);
		
		btnEast = new JButton("Mul");
		contentPane.add(btnEast, BorderLayout.EAST);
	}

}
