package java_swing_teacher.chap13;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadTimeEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTimer;
	private JPanel panel;
	private JButton btnStart;
	private JButton btnStop;
	private TimerThread th;

	public ThreadTimeEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 80));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTimer, BorderLayout.CENTER);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		panel.add(btnStart);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		panel.add(btnStop);
		
		th = new TimerThread(lblTimer);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			btnStartActionPerformed(e);
		}
		if (e.getSource() == btnStop) {
			btnStopActionPerformed(e);
		}
	}
	
	protected void btnStopActionPerformed(ActionEvent e) {
		System.out.println(th.getState());
		th.interrupt();		
		System.out.println(th.getState());
	}
	
	protected void btnStartActionPerformed(ActionEvent e) {
//		th = new TimerThread(lblTimer);
		System.out.println(th.getState());
		if (th.getState()==Thread.State.TERMINATED) {
			th = new TimerThread(lblTimer);
		}
		th.start();
	}
}
