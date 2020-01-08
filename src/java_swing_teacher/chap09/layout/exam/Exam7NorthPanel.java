package java_swing_teacher.chap09.layout.exam;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Exam7NorthPanel extends JPanel {
	private JLabel lblTitle;
	private JTextField textField;

	public Exam7NorthPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(20, 0));
		
		lblTitle = new JLabel("수식입력");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setPreferredSize(new Dimension(100, 15));
		add(lblTitle, BorderLayout.WEST);
		
		textField = new JTextField();
		add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
