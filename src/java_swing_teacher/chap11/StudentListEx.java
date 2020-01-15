package java_swing_teacher.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java_swing_teacher.chap11.exam.Student;
import java_swing_teacher.chap11.exam.StudentPanel;

@SuppressWarnings("serial")
public class StudentListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private JPanel pList;
	private JPanel pBtns;
	private JScrollPane scrollPane;
	private JList<Student> list;
	private ArrayList<Student> stds;
	private JButton btnAdd;
	private JButton btnCancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListEx frame = new StudentListEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentListEx() {
		stds = new ArrayList<Student>();
		initialize();
	}

	private void initialize() {
		setTitle("학생 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pStudent = new StudentPanel();
		contentPane.add(pStudent, BorderLayout.NORTH);

		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);

		list = new JList<>();
		scrollPane.setViewportView(list);

		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		Student student = pStudent.getItem();
		stds.add(student);
		list.setListData(new Vector<Student>(stds));
		pStudent.clearTf();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}
