package java_swing_teacher.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java_swing_teacher.chap11.exam.Student;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class ComboxEx extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private DefaultComboBoxModel<String> model;
	private JTextField tfFruit;
	private JLabel lblFruit;
	private JButton btnOk;
	private JComboBox<Student> cmbStudent;
	private JLabel lblStudent;
	private JButton btnConfirm;
	private JPanel pSearch;
	private JLabel lblNum;
	private JTextField tfNum;
	private JButton btnSearch;
	private DefaultComboBoxModel<Student> modelStudent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboxEx frame = new ComboxEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComboxEx() {
		initialize();
	}
	private void initialize() {
		setTitle("콤보박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uC608\uC81C11-12", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		cmbFruit = new JComboBox<>();
		cmbFruit.addItemListener(this);
		cmbFruit.setMaximumRowCount(5);
		pLeft.add(cmbFruit);
		
		tfFruit = new JTextField();
		tfFruit.addActionListener(this);
		pLeft.add(tfFruit);
		tfFruit.setColumns(10);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC608\uC81C11-13", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		cmbStudent = new JComboBox<Student>();
		pRight.add(cmbStudent);
		
		lblStudent = new JLabel("학생정보");
		lblStudent.setForeground(Color.RED);
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblStudent);
		
		btnConfirm = new JButton("학생 확인");
		pRight.add(btnConfirm);
		
		pSearch = new JPanel();
		pRight.add(pSearch);
		pSearch.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		pSearch.add(lblNum);
		
		tfNum = new JTextField();
		pSearch.add(tfNum);
		tfNum.setColumns(10);
		
		btnSearch = new JButton("검색");
		pSearch.add(btnSearch);
		
		cmbFruit.setModel(getFruitModel());
		cmbFruit.setSelectedIndex(-1);
		
		
		cmbStudent.setModel(getStudentModel());
		cmbStudent.setSelectedIndex(-1);
		
		
		lblFruit = new JLabel("과일");
		lblFruit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFruit.setForeground(Color.RED);
		pLeft.add(lblFruit);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pLeft.add(btnOk);
	}

	private ComboBoxModel<Student> getStudentModel() {
		ArrayList<Student> stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		modelStudent = new DefaultComboBoxModel<>();
		for(Student element : stds) {
			modelStudent.addElement(element);
		}
		return modelStudent;
	}

	private ComboBoxModel<String> getFruitModel() {
		model = new DefaultComboBoxModel<String>();
		
		String[] fs = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
		for(String f : fs) {
			model.addElement(f);
		}
		
		return model;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == tfFruit) {
			textFieldActionPerformed(e);
		}
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		if (!tfFruit.getText().equals("")) {
			model.addElement(tfFruit.getText().trim());
			tfFruit.setText("");
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbFruit) {
			cmbFruitItemStateChanged(e);
		}
	}
	protected void cmbFruitItemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			
			lblFruit.setText(model.getSelectedItem().toString());
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		int selIdx = cmbFruit.getSelectedIndex();
		if (selIdx == -1) {
			JOptionPane.showMessageDialog(null, "과일을 선택하세요");
			return;
		}
		String message = String.format("선택한 과일은 ? %s - %s", cmbFruit.getSelectedItem(), model.getSelectedItem());
		JOptionPane.showMessageDialog(null, message);
	}
}
