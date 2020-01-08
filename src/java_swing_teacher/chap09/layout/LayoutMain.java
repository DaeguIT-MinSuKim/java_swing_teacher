package java_swing_teacher.chap09.layout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java_swing_teacher.chap09.layout.exam.Exam2;
import java_swing_teacher.chap09.layout.openchallange.OpenChallengeEx;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JButton btnFlow;
	private JButton btnBorder;
	private JButton btnGrid;
	private JButton btnAbsolute;
	private JButton OpenChallenge;
	private JPanel pRight;
	private JButton btnExam2;
	private JButton btnExam4;
	private JButton btnExam5;
	private JButton btnExam7;
	private JButton btnExam8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LayoutMain() {
		initialize();
	}

	private void initialize() {
		setTitle("배치레이아웃예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\uC81C9\uC7A5 GUI \uAE30\uCD08", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uB808\uC774\uC544\uC6C3 \uC608\uC81C", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 2, 10, 10));

		btnFlow = new JButton("FlowLayout");
		btnFlow.addActionListener(this);
		pLeft.add(btnFlow);

		btnBorder = new JButton("BorderLayout");
		btnBorder.addActionListener(this);
		pLeft.add(btnBorder);

		btnGrid = new JButton("GridLayout");
		btnGrid.addActionListener(this);
		pLeft.add(btnGrid);

		btnAbsolute = new JButton("AbsoluteLayout");
		btnAbsolute.addActionListener(this);
		pLeft.add(btnAbsolute);

		OpenChallenge = new JButton("OpenChallenge Solv");
		OpenChallenge.addActionListener(this);
		pLeft.add(OpenChallenge);

		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC2E4\uC2B5\uBB38\uC81C \uD480\uC774", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 2, 10, 10));

		btnExam2 = new JButton("Exam2");
		btnExam2.addActionListener(this);
		pRight.add(btnExam2);

		btnExam4 = new JButton("Exam4");
		btnExam4.addActionListener(this);
		pRight.add(btnExam4);

		btnExam5 = new JButton("Exam5");
		btnExam5.addActionListener(this);
		pRight.add(btnExam5);

		btnExam7 = new JButton("Exam7");
		btnExam7.addActionListener(this);
		pRight.add(btnExam7);

		btnExam8 = new JButton("Exam8");
		btnExam8.addActionListener(this);
		pRight.add(btnExam8);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExam7) {
			btnExam7ActionPerformed(e);
		}
		if (e.getSource() == btnExam8) {
			btnExam8ActionPerformed(e);
		}
		if (e.getSource() == OpenChallenge) {
			OpenChallengeActionPerformed(e);
		}
		if (e.getSource() == btnBorder) {
			btnBorderActionPerformed(e);
		}
		if (e.getSource() == btnExam2) {
			btnExam2ActionPerformed(e);
		}
		if (e.getSource() == btnGrid) {
			btnGridActionPerformed(e);
		}
		if (e.getSource() == btnExam4) {
			btnExam4ActionPerformed(e);
		}
		if (e.getSource() == btnExam5) {
			btnExam5ActionPerformed(e);
		}
		if (e.getSource() == btnAbsolute) {
			btnAbsoluteActionPerformed(e);
		}
		if (e.getSource() == btnFlow) {
			btnFlowActionPerformed(e);
		}
	}

	protected void btnFlowActionPerformed(ActionEvent e) {
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);
	}

	protected void btnAbsoluteActionPerformed(ActionEvent e) {
		AbsoluteLayoutEx frame = new AbsoluteLayoutEx();
		frame.setVisible(true);
	}

	protected void btnExam5ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}

	protected void btnExam4ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}

	protected void btnGridActionPerformed(ActionEvent e) {
		GridLayoutEx frame = new GridLayoutEx();
		frame.setVisible(true);
	}

	protected void btnExam2ActionPerformed(ActionEvent e) {
		Exam2 frame = new Exam2();
		frame.setVisible(true);
	}

	protected void btnBorderActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}

	protected void OpenChallengeActionPerformed(ActionEvent e) {
		OpenChallengeEx frame = new OpenChallengeEx();
		frame.setVisible(true);
	}

	protected void btnExam8ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}

	protected void btnExam7ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}
