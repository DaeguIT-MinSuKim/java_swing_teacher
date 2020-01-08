package java_swing_teacher.chap09.layout.exam;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam7SouthPanel extends JPanel {
	private JLabel lblTitle;
	private JTextField textField;

	public Exam7SouthPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.ORANGE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		lblTitle = new JLabel("계산 결과");
		add(lblTitle);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}

}
