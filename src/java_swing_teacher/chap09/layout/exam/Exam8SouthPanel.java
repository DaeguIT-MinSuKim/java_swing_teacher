package java_swing_teacher.chap09.layout.exam;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class Exam8SouthPanel extends JPanel {
	private JButton btnWordInput;
	private JTextField textField;

	public Exam8SouthPanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.YELLOW);
		setBorder(new EmptyBorder(5, 0, 5, 5));
		setLayout(new BorderLayout(10, 0));
		
		btnWordInput = new JButton("Word Input");
		add(btnWordInput, BorderLayout.WEST);
		
		textField = new JTextField();
		add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
