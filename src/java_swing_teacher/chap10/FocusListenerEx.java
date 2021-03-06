package java_swing_teacher.chap10;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FocusListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblNo;
	private JTextField tfNo;
	private JLabel lblDept;
	private JTextField tfDept;
	private JLabel lblSubj;
	private JTextField tfSubj;
	private JLabel lblRes;
	private JPasswordField pw1;
	private JPasswordField pw2;
	private JLabel lblConfirm;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnSet;
 
	public FocusListenerEx() {
		initialize();
	}
	
	private void initialize() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(329, 264);
		setLocation(100, 100);
//		setBounds(100, 100, 329, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				msg();
			}
			
			public void msg() {
				lblRes.setText(String.format("%s 길이 : %d", tfName.getText(), tfName.getText().length()));
			}
			
		});
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		lblNo = new JLabel("학번");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (tfName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "tfNo 이름을 입력하세요");
				}
			}
		}); 
		tfNo.setColumns(10);
		contentPane.add(tfNo);
		
		lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		contentPane.add(tfDept);
		
		lblSubj = new JLabel("과목");
		lblSubj.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubj);
		
		tfSubj = new JTextField();
		tfSubj.setColumns(10);
		contentPane.add(tfSubj);
		
		tfSubj.setRequestFocusEnabled(true);
		
		lblRes = new JLabel("이름필드 글자수");
		contentPane.add(lblRes);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 20));
		lblConfirm.setForeground(Color.RED);
		contentPane.add(lblConfirm);
		
		pw1 = new JPasswordField();
		pw1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(pw1);
		
		pw2 = new JPasswordField();
		pw2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();				
			}
			
			public void isEqualPw() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				
				System.out.printf("pw1 : %s pw2 : %s%n", pass1, pass2);
				
				if (pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				}else {
					lblConfirm.setText("일치하지 않음");
				}
			}
		});
		contentPane.add(pw2);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		contentPane.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		btnSet = new JButton("수정");
		btnSet.addActionListener(this);
		contentPane.add(btnSet);
	}
	
	public JTextField getTfSubj() {
		return tfSubj;
	}
	
	public static void main(String[] args) {
		FocusListenerEx frame = new FocusListenerEx();
		frame.setVisible(true);
		
		frame.getTfSubj().requestFocus();	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSet) {
			btnSetActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		Student student = getStudent();
		JOptionPane.showMessageDialog(null, student);
	}

	public Student getStudent() {
		String name = tfName.getText().trim();
		int stdNo = Integer.parseInt(tfNo.getText().trim());
		String dept = tfDept.getText().trim();
		String subj = tfSubj.getText().trim();
		Student student = new Student(name, stdNo, dept, subj);
		return student;
	}
	
	public void clearTf() {
		tfName.setText("");
		tfNo.setText("");
		tfDept.setText("");
		tfSubj.setText("");
	}
	
	public void setStudent(Student std) {
		tfName.setText(std.getName());
		tfNo.setText(std.getStdNo()+"");
		tfDept.setText(std.getDept());
		tfSubj.setText(std.getSubj());
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		clearTf();
	}
	protected void btnSetActionPerformed(ActionEvent e) {
		Student newStudent = new Student("이상원", 1, "컴퓨터관광", "자바");
		setStudent(newStudent);
	}
}














