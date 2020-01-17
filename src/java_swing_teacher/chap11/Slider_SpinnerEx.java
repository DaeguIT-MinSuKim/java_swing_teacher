package java_swing_teacher.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Slider_SpinnerEx extends JFrame implements ChangeListener, ActionListener {

	private JPanel contentPane;
	private JPanel pSlider1;
	private JPanel pSlider2;
	private JPanel pSpinner1;
	private JPanel pSpinner2;
	private JSlider slider1;
	private JLabel lblValue1;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JLabel lblColor;
	private JPanel panel;
	private JLabel lblRed;
	private JTextField tfRed;
	private JLabel lblGreen;
	private JTextField tfGreen;
	private JLabel lblBlue;
	private JTextField tfBlue;
	private JButton btnColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider_SpinnerEx frame = new Slider_SpinnerEx();
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
	public Slider_SpinnerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JSlider와 JSpinner 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pSlider1 = new JPanel();
		pSlider1.setBorder(new TitledBorder(null, "\uC608\uC81C 11-14", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider1);
		pSlider1.setLayout(new GridLayout(0, 1, 0, 0));
		
		slider1 = new JSlider();
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMinorTickSpacing(10);
		slider1.setMajorTickSpacing(50);
		slider1.setMaximum(200);
		pSlider1.add(slider1);
		
		lblValue1 = new JLabel("0");
		lblValue1.setFont(new Font("굴림", Font.BOLD, 12));
		lblValue1.setForeground(Color.RED);
		lblValue1.setHorizontalAlignment(SwingConstants.CENTER);
		pSlider1.add(lblValue1);
		
		pSlider2 = new JPanel();
		pSlider2.setBorder(new TitledBorder(null, "\uC608\uC81C 11-15", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider2);
		pSlider2.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		pSlider2.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblRed = new JLabel("Red");
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRed);
		
		tfRed = new JTextField();
		panel.add(tfRed);
		tfRed.setColumns(5);
		
		lblGreen = new JLabel("Green");
		lblGreen.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGreen);
		
		tfGreen = new JTextField();
		tfGreen.setColumns(5);
		panel.add(tfGreen);
		
		lblBlue = new JLabel("Blue");
		lblBlue.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBlue);
		
		tfBlue = new JTextField();
		tfBlue.setColumns(5);
		panel.add(tfBlue);
		
		btnColor = new JButton("적용");
		btnColor.addActionListener(this);
		panel.add(btnColor);
		
		sliderRed = new JSlider();
		sliderRed.setForeground(Color.RED);
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		sliderRed.setMinorTickSpacing(10);
		sliderRed.setMaximum(255);
		sliderRed.setMajorTickSpacing(50);
		pSlider2.add(sliderRed);
		
		sliderGreen = new JSlider();
		sliderGreen.setForeground(Color.GREEN);
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		sliderGreen.setMinorTickSpacing(10);
		sliderGreen.setMaximum(255);
		sliderGreen.setMajorTickSpacing(50);
		pSlider2.add(sliderGreen);
		
		sliderBlue = new JSlider();
		sliderBlue.setForeground(Color.BLUE);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		sliderBlue.setMinorTickSpacing(10);
		sliderBlue.setMaximum(255);
		sliderBlue.setMajorTickSpacing(50);
		pSlider2.add(sliderBlue);
		
		lblColor = new JLabel("SLIDER EXAMPLE");
		lblColor.setFont(new Font("굴림", Font.BOLD, 12));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor.setBackground(new Color(255, 255, 0));
		lblColor.setOpaque(true);
		pSlider2.add(lblColor);
		
		pSpinner1 = new JPanel();
		pSpinner1.setBorder(new TitledBorder(null, "JSpinner \uC608\uC81C1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner1);
		
		pSpinner2 = new JPanel();
		pSpinner2.setBorder(new TitledBorder(null, "JSpinner \uC608\uC81C2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner2);
		
		slider1.addChangeListener(this);
		slider1.setValue(100);
		
		sliderRed.addChangeListener(this);
		sliderGreen.addChangeListener(this);
		sliderBlue.addChangeListener(this);
		
		sliderRed.setValue(100);
		sliderBlue.setValue(100);
		sliderGreen.setValue(100);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == sliderBlue || e.getSource() == sliderRed || e.getSource() == sliderGreen) {
			lblColor.setBackground(new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));
			tfRed.setText(sliderRed.getValue()+"");
			tfGreen.setText(sliderGreen.getValue()+"");
			tfBlue.setText(sliderBlue.getValue()+"");
		}
		
		if (e.getSource() == slider1) {
			slider1StateChanged(e);
		}
	}
	
	protected void slider1StateChanged(ChangeEvent e) {
		lblValue1.setText(slider1.getValue()+"");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnColor) {
			btnColorActionPerformed(e);
		}
	}
	protected void btnColorActionPerformed(ActionEvent e) {
		int red = Integer.parseInt(tfRed.getText().trim());
		int green = Integer.parseInt(tfGreen.getText().trim());
		int blue = Integer.parseInt(tfBlue.getText().trim());
		lblColor.setBackground(new Color(red, green, blue));
		sliderRed.setValue(red);
		sliderBlue.setValue(blue);
		sliderGreen.setValue(green);
	}
}