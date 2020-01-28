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
import java.awt.GridLayout;

public class ThreadTimeEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTimer;
	private JPanel pBtns;
	private JButton btnStart;
	private JButton btnStop;
	private TimerThread th;
	private GugudanThread guTh;
	private JPanel pLbls;
	private JLabel lblRunnableTimer;
	private Thread th2;

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
		
		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		pBtns.add(btnStart);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		pBtns.add(btnStop);
		

		
		pLbls = new JPanel();
		contentPane.add(pLbls, BorderLayout.CENTER);
		pLbls.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 80));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		pLbls.add(lblTimer);
		
		lblRunnableTimer = new JLabel("");
		lblRunnableTimer.setOpaque(true);
		lblRunnableTimer.setFont(new Font("굴림", Font.BOLD, 80));
		lblRunnableTimer.setHorizontalAlignment(SwingConstants.CENTER);
		pLbls.add(lblRunnableTimer);
		
		
		
		th = new TimerThread(lblTimer);
		guTh = new GugudanThread();
		TimerRunnable tr = new TimerRunnable(lblRunnableTimer);
		th2 = new Thread(tr);
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
		guTh.interrupt();
		th2.interrupt();
		System.out.println(th.getState());
	}
	
	protected void btnStartActionPerformed(ActionEvent e) {
//		th = new TimerThread(lblTimer);
		System.out.println(th.getState());
		if (th.getState()==Thread.State.TERMINATED) {
			th = new TimerThread(lblTimer);
		}
		if (guTh.getState()==Thread.State.TERMINATED) {
			guTh = new GugudanThread();
		}
		if (th2.getState() == Thread.State.TERMINATED) {
			th2 = new Thread(new TimerRunnable(lblRunnableTimer));
		}
		
		guTh.start();
		th.start();
		th2.start();
	}
}
