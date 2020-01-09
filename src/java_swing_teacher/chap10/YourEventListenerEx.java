package java_swing_teacher.chap10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class YourEventListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btn01;
	private JButton btn02;
	private JButton btn03;
	private JButton btn04;
	private JButton btn02_02;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourEventListenerEx frame = new YourEventListenerEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public YourEventListenerEx() {
		initialize();
	}

	private void initialize() {
		setTitle("리스너작성실습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 20, 10, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC708\uB3C4\uC6B0\uBE4C\uB354\uC81C\uACF5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		btn01 = new JButton("배경색 변경");
		btn01.addActionListener(this);
		panel.add(btn01, BorderLayout.CENTER);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uB3C5\uB9BD\uD074\uB798\uC2A4", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel_1);

		btn02 = new JButton("배경색 변경");
		btn02.addActionListener(new MyAction3Listener(contentPane));
		panel_1.setLayout(new GridLayout(1, 1, 10, 0));
		panel_1.add(btn02);
		
		btn02_02 = new JButton("배경색변경2");
		btn02_02.addActionListener(new MyAction3Listener2());
		panel_1.add(btn02_02);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uB0B4\uBD80\uD074\uB798\uC2A4", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		btn03 = new JButton("배경색 변경");
		btn03.addActionListener(new MyAction4Listener());
		panel_2.add(btn03);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uC775\uBA85\uD074\uB798\uC2A4", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		btn04 = new JButton("배경색 변경");
		btn04.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contentPane.getBackground() == Color.YELLOW) {
					contentPane.setBackground(Color.RED);
				} else {
					contentPane.setBackground(Color.YELLOW);
				}
			}
		});
		panel_3.add(btn04);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			btn01ActionPerformed(e);
		}
	}

	protected void btn01ActionPerformed(ActionEvent e) {
		System.out.println(contentPane.getBackground());
		if (contentPane.getBackground() == Color.YELLOW) {
			contentPane.setBackground(Color.RED);
		} else {
			contentPane.setBackground(Color.YELLOW);
		}
	}

	private class MyAction4Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (contentPane.getBackground() == Color.YELLOW) {
				contentPane.setBackground(Color.RED);
			} else {
				contentPane.setBackground(Color.YELLOW);
			}
		}

	}
}
