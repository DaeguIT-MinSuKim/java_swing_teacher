package java_swing_teacher.chap13;

import java.awt.Color;

import javax.swing.JLabel;

public class TimerRunnable implements Runnable {
	private JLabel leftLabel;

	public TimerRunnable(JLabel leftLable) {
		this.leftLabel = leftLable;
	}

	@Override
	public void run() {
		int n=100;
		while(true) {
			leftLabel.setText(Integer.toString(n));
			leftLabel.setBackground(n%2==0?Color.RED:Color.CYAN);
			n--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				leftLabel.setText("Stop");
				return;
			}
			
		}
	}

}
