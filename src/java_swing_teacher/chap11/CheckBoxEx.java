package java_swing_teacher.chap11;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class CheckBoxEx extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JLabel lblTitle;
	private JPanel pCheckBox;
	private JLabel lblSum;
	private JCheckBox chkApple;
	private JCheckBox chkPear;
	private JCheckBox chkCherry;
	private int sum;
	private String sumStr = "현재 %d 원 입니다.";
	private JButton btnApple;
	private JButton btnPear;
	private JButton btnAll;
	private JButton btnOk;
	private JButton btnCherry;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxEx frame = new CheckBoxEx();
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
	public CheckBoxEx() {
		initialize();
	}
	
	private void initialize() {
		setTitle("체크박스예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uC608\uC81C11-4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblTitle = new JLabel("사과 100원, 배 500원, 체리 20000원");
		pLeft.add(lblTitle);
		
		pCheckBox = new JPanel();
		pCheckBox.setBorder(new EmptyBorder(0, 10, 0, 10));
		pLeft.add(pCheckBox);
		pCheckBox.setLayout(new GridLayout(0, 3, 0, 0));
		
		chkApple = new JCheckBox("사과");
		chkApple.setBorderPainted(true);
		chkApple.addItemListener(this);
		pCheckBox.add(chkApple);
		
		chkPear = new JCheckBox("배");
		chkPear.setBorderPainted(true);
		chkPear.addItemListener(this);
		pCheckBox.add(chkPear);
		
		chkCherry = new JCheckBox("체리");
		chkCherry.setBorderPainted(true);
		chkCherry.addItemListener(this);
		pCheckBox.add(chkCherry);
		
		lblSum = new JLabel(String.format(sumStr, sum));
		lblSum.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblSum);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "selected&deselected", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnApple = new JButton("사과 선택");
		btnApple.addActionListener(this);
		pRight.add(btnApple);
		
		btnPear = new JButton("배 선택");
		btnPear.addActionListener(this);
		pRight.add(btnPear);
		
		btnAll = new JButton("모든 과일 선택");
		btnAll.addActionListener(this);
		
		btnCherry = new JButton("체리 선택");
		btnCherry.addActionListener(this);
		pRight.add(btnCherry);
		pRight.add(btnAll);
		
		btnOk = new JButton("선택한 과일 확인");
		btnOk.addActionListener(this);
		pRight.add(btnOk);
	}

	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getSource());
		if (e.getSource() == chkCherry) {
			chkCherryItemStateChanged(e);
		}
		if (e.getSource() == chkPear) {
			chdPearItemStateChanged(e);
		}
		if (e.getSource() == chkApple) {
			chkAppleItemStateChanged(e);
		}
		lblSum.setText(String.format(sumStr, sum));
	}
	
	protected void chkAppleItemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			sum += 100;
		}else {
			sum -= 100;
		}
	}
	
	protected void chdPearItemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			sum += 500;
		}else {
			sum -= 500;
		}
	}
	
	protected void chkCherryItemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			sum += 20000;
		}else {
			sum -= 20000;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCherry) {
			chkSetSelected(chkCherry, btnCherry);
//			btnCherryActionPerformed(e);
		}
		if (e.getSource() == btnAll) {
			btnAllActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			
			btnOkActionPerformed(e);
		}
		if (e.getSource() == btnPear) {
			chkSetSelected(chkPear, btnPear);
//			btnApplePearActionPerformed(e);
		}
		if (e.getSource() == btnApple) {
			chkSetSelected(chkApple, btnApple);
			
//			btnAppleActionPerformed(e);
		}
	}
	
	private void chkSetSelected(JCheckBox ch, JButton btn) {
		if (ch.isSelected()) {
			ch.setSelected(false);
			btn.setText(ch.getText() + " 선택");
		}else {
			ch.setSelected(true);
			btn.setText(ch.getText() + " 취소");
		}
	}
	
	protected void btnAppleActionPerformed(ActionEvent e) {
		/*
		if (chkApple.isSelected()) {
			chkApple.setSelected(false);
			btnApple.setText("사과 선택");
		}else {
			chkApple.setSelected(true);
			btnApple.setText("사과 취소");
		}
		*/
	}
	protected void btnApplePearActionPerformed(ActionEvent e) {
		/*
		if (chkPear.isSelected()) {
			chkPear.setSelected(false);
			btnPear.setText("배 선택");
		}else {
			chkPear.setSelected(true);
			btnPear.setText("배 취소");
		}
		*/
	}
	protected void btnCherryActionPerformed(ActionEvent e) {
		/*
		if (chkCherry.isSelected()) {
			chkCherry.setSelected(false);
			btnCherry.setText("체리 선택");
		}else {
			chkCherry.setSelected(true);
			btnCherry.setText("체리 취소");
		}
		*/
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		StringBuilder sb = new StringBuilder();
		for(Component c : pCheckBox.getComponents()) {
			if (c instanceof JCheckBox) {
				JCheckBox chk = (JCheckBox)c;
				if (chk.isSelected()) {
					sb.append(chk.getText() + ", ");
				}
			}
		}
		String text = sb.length()==0?"없음":sb.substring(0, sb.length()-2);
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + text);
	}
	
	protected void btnAllActionPerformed(ActionEvent e) {
		if (chkApple.isSelected() && chkPear.isSelected() && chkCherry.isSelected()) {
			chkApple.setSelected(false);
			chkPear.setSelected(false);
			chkCherry.setSelected(false);
			btnAll.setText("모든 과일 선택");
		}else {
			for(Component c : pCheckBox.getComponents()) {
				if (c instanceof JCheckBox) {
					((JCheckBox)c).setSelected(true);
				}
			}
			btnAll.setText("모든 과일 취소");
		}
	}

}
