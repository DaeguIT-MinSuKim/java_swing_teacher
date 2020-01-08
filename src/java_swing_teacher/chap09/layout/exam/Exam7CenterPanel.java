package java_swing_teacher.chap09.layout.exam;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Exam7CenterPanel extends JPanel {

	public Exam7CenterPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 4, 0, 0));
		
		for(int i=0; i<10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			add(btn);
		}
		JButton btnCe = new JButton("CE");
		add(btnCe);
		JButton btnCal = new JButton("계산");
		add(btnCal);
		
		String[] oper = {"+", "-", "x", "/"};
		for(int i=0; i<oper.length; i++) {
			JButton btn = new JButton(oper[i]);
			btn.setBackground(Color.CYAN);
			add(btn);
		}
	}

}
