package eg.edu.alexu.csd.datastructure.mailServer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FilterForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterForm frame = new FilterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public FilterForm(App app) {
		super ("Filter Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 503);
		setLocationRelativeTo(null);
		try {
			Image img = ImageIO.read(getClass().getResource("mail.png"));
			setIconImage(img);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxPriority = new JCheckBox("Priority:");
		chckbxPriority.setForeground(Color.YELLOW);
		chckbxPriority.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		chckbxPriority.setBackground(Color.BLACK);
		chckbxPriority.setBounds(21, 51, 122, 25);
		contentPane.add(chckbxPriority);
		
		JRadioButton radio1 = new JRadioButton("4 (Least)");
		radio1.setForeground(Color.YELLOW);
		radio1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio1.setBackground(Color.BLACK);
		radio1.setEnabled(false);
		radio1.setBounds(586, 53, 103, 21);
		radio1.setSelected(true);
		contentPane.add(radio1);
		
		JRadioButton radio2 = new JRadioButton("3");
		radio2.setForeground(Color.YELLOW);
		radio2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio2.setBackground(Color.BLACK);
		radio2.setEnabled(false);
		radio2.setBounds(439, 53, 103, 21);
		contentPane.add(radio2);
		
		JRadioButton radio3 = new JRadioButton("2");
		radio3.setForeground(Color.YELLOW);
		radio3.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio3.setBackground(Color.BLACK);
		radio3.setBounds(288, 53, 103, 21);
		radio3.setEnabled(false);
		contentPane.add(radio3);
		
		JRadioButton radio4 = new JRadioButton("1  (Most)");
		radio4.setForeground(Color.YELLOW);
		radio4.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio4.setBackground(Color.BLACK);
		radio4.setBounds(145, 53, 111, 21);
		radio4.setEnabled(false);
		contentPane.add(radio4);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		group.add(radio4);
		
		chckbxPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxPriority.isSelected()) {
					radio1.setEnabled(true);
					radio2.setEnabled(true);
					radio3.setEnabled(true);
					radio4.setEnabled(true);
				}else {
					radio1.setEnabled(false);
					radio2.setEnabled(false);
					radio3.setEnabled(false);
					radio4.setEnabled(false);
				}
			}
		});
		
		
		JCheckBox chckbxDate = new JCheckBox("Date:");
		chckbxDate.setForeground(Color.YELLOW);
		chckbxDate.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		chckbxDate.setBackground(Color.BLACK);
		chckbxDate.setBounds(21, 130, 122, 25);
		contentPane.add(chckbxDate);
		
		JRadioButton rdbtnBefore = new JRadioButton("Before:");
		rdbtnBefore.setForeground(Color.YELLOW);
		rdbtnBefore.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		rdbtnBefore.setBackground(Color.BLACK);
		rdbtnBefore.setBounds(145, 132, 103, 21);
		rdbtnBefore.setEnabled(false);
		rdbtnBefore.setSelected(true);
		contentPane.add(rdbtnBefore);
		
		JRadioButton rdbtnAfter = new JRadioButton("After:");
		rdbtnAfter.setForeground(Color.YELLOW);
		rdbtnAfter.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		rdbtnAfter.setBackground(Color.BLACK);
		rdbtnAfter.setEnabled(false);
		rdbtnAfter.setBounds(288, 130, 103, 21);
		contentPane.add(rdbtnAfter);
		
	
		JCheckBox chckbxFromMail = new JCheckBox("FromMail:");
		chckbxFromMail.setForeground(Color.YELLOW);
		chckbxFromMail.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		chckbxFromMail.setBackground(Color.BLACK);
		chckbxFromMail.setBounds(21, 206, 122, 25);
		contentPane.add(chckbxFromMail);
		
		JCheckBox chckbxToMail = new JCheckBox("ToMail:");
		chckbxToMail.setForeground(Color.YELLOW);
		chckbxToMail.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		chckbxToMail.setBackground(Color.BLACK);
		chckbxToMail.setBounds(21, 273, 122, 25);
		contentPane.add(chckbxToMail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(145, 207, 557, 19);
		textField_1.setEnabled(false);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(145, 274, 557, 19);
		textField_2.setEnabled(false);
		contentPane.add(textField_2);
		
		JCheckBox chckbxSubject = new JCheckBox("Subject:");
		chckbxSubject.setForeground(Color.YELLOW);
		chckbxSubject.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		chckbxSubject.setBackground(Color.BLACK);
		chckbxSubject.setBounds(21, 349, 122, 25);
		contentPane.add(chckbxSubject);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(145, 350, 557, 19);
		textField_3.setEnabled(false);
		contentPane.add(textField_3);
		
		JRadioButton rdbtnAt = new JRadioButton("At:");
		rdbtnAt.setForeground(Color.YELLOW);
		rdbtnAt.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		rdbtnAt.setBackground(Color.BLACK);
		rdbtnAt.setBounds(439, 130, 103, 21);
		rdbtnAt.setEnabled(false);
		contentPane.add(rdbtnAt);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rdbtnAfter);
		group1.add(rdbtnBefore);
		group1.add(rdbtnAt);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxPriority.isSelected()) {
					if (radio1.isSelected())app.currentFilter.setPriority("1");
					else if (radio2.isSelected())app.currentFilter.setPriority("2");
					else if (radio3.isSelected())app.currentFilter.setPriority("3");
					else if (radio4.isSelected())app.currentFilter.setPriority("4");
					else app.currentFilter.setPriority(null);
				}
				if (chckbxDate.isSelected()) {
					if (rdbtnAt.isSelected())app.currentFilter.setAt(true);
					else app.currentFilter.setAt(false);
					if (rdbtnAfter.isSelected())app.currentFilter.setAfter(true);
					else app.currentFilter.setAfter(false);
					if (rdbtnBefore.isSelected())app.currentFilter.setBefore(true);
					else app.currentFilter.setBefore(false);
					String Temp="";
					if ((Integer)spinner.getValue()<10) Temp += "0"+spinner.getValue()+"/";
					else Temp += spinner.getValue()+"/";
					if ((Integer)spinner_1.getValue()<10) Temp += "0"+spinner_1.getValue()+"/";
					else Temp += spinner_1.getValue()+"/";
					Temp+=spinner_2.getValue();
					app.currentFilter.setDate(Temp);
				}
				if (chckbxFromMail.isSelected())app.currentFilter.setFromMail(textField_1.getText());
				if (chckbxToMail.isSelected())app.currentFilter.setToMail(textField_2.getText());
				if (chckbxSubject.isSelected())app.currentFilter.setSubject(textField_3.getText());
				dispose();
			}
		});
		btnSave.setForeground(Color.YELLOW);
		btnSave.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		btnSave.setBackground(new Color(102, 51, 0));
		btnSave.setBounds(280, 404, 179, 21);
		contentPane.add(btnSave);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setForeground(new Color(255, 255, 0));
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(551, 131, 41, 24);
		spinner.setEnabled(false);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_1.setForeground(Color.YELLOW);
		spinner_1.setBounds(591, 131, 41, 24);
		spinner_1.setEnabled(false);
		contentPane.add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_2.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2000), null, new Integer(1)));
		spinner_2.setForeground(Color.YELLOW);
		spinner_2.setBounds(631, 131, 58, 24);
		spinner_2.setEnabled(false);
		contentPane.add(spinner_2);
		
		chckbxDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxDate.isSelected()) {
					rdbtnAt.setEnabled(true);
					rdbtnBefore.setEnabled(true);
					rdbtnAfter.setEnabled(true);
					spinner.setEnabled(true);
					spinner_1.setEnabled(true);
					spinner_2.setEnabled(true);
				}else {
					rdbtnAt.setEnabled(false);
					rdbtnAfter.setEnabled(false);
					rdbtnBefore.setEnabled(false);
					spinner.setEnabled(false);
					spinner_1.setEnabled(false);
					spinner_2.setEnabled(false);
				}
			}
		});
		
		chckbxFromMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxFromMail.isSelected()) {
					textField_1.setEnabled(true);
				}else {
					textField_1.setEnabled(false);
				}
			}
		});
		
		chckbxToMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxToMail.isSelected()) {
					textField_2.setEnabled(true);
				}else {
					textField_2.setEnabled(false);
				}
			}
		});
		chckbxSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxSubject.isSelected()) {
					textField_3.setEnabled(true);
				}else {
					textField_3.setEnabled(false);
				}
			}
		});
	}
}
