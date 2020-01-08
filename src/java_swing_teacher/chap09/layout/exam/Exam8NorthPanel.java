package java_swing_teacher.chap09.layout.exam;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam8NorthPanel extends JPanel {
	private JButton btnOpen;
	private JButton btnClose;
	private JButton btnOut;

	public Exam8NorthPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(5, 40, 5, 40));
		setLayout(new GridLayout(0, 3, 10, 0));
		
		btnOpen = new JButton("열기");
		add(btnOpen);
		
		btnClose = new JButton("닫기");
		add(btnClose);
		
		btnOut = new JButton("나가기");
		add(btnOut);
	}

}
