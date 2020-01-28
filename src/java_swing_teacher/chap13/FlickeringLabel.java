package java_swing_teacher.chap13;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlickeringLabel extends JLabel implements Runnable{
	private long delay; 
	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true);
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		int n=0;
		while(true) {
			setBackground(n%2==0?Color.YELLOW:Color.GREEN);
			n++;
			try {
				Thread.sleep(delay); 
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}

}
