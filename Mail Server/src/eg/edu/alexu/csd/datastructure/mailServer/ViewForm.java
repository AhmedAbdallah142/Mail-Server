package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.linkedList.csX22.Single_Linked_list;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ViewForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTo;
	private JTextField txtSub;
	private JTextField txtFrom;
	private boolean Attach = false;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewForm frame = new ViewForm();
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
	public ViewForm(Mail mail,App app) {
		super("Mail Server View form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 751, 706);
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
		
		JLabel lblTofrom = new JLabel("To:");
		lblTofrom.setForeground(new Color(255, 255, 0));
		lblTofrom.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lblTofrom.setBounds(10, 77, 136, 16);
		contentPane.add(lblTofrom);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Attach =true;
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showDialog(button, "Choose File");
				textArea.setText(textArea.getText() + "\nAttachment --> " + fileChooser.getSelectedFile().toString() + "\n");
			}
		});
		button.setIcon(new ImageIcon(
				composeForm.class.getResource("/eg/edu/alexu/csd/datastructure/mailServer/multimedia-option.png")));
		button.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		button.setBounds(227, 613, 36, 21);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("Subject:");
		label_1.setForeground(new Color(255, 255, 0));
		label_1.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		label_1.setBounds(10, 113, 136, 16);
		contentPane.add(label_1);
		
		txtTo = new JTextField(mail.getTo());
		txtTo.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtTo.setColumns(10);
		txtTo.setBounds(92, 77, 557, 19);
		contentPane.add(txtTo);
		
		txtSub = new JTextField(mail.getSubject());
		txtSub.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtSub.setColumns(10);
		txtSub.setBounds(92, 112, 557, 19);
		contentPane.add(txtSub);
		
		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		button_1.setBounds(650, 624, 70, 35);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 180, 700, 419);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea(mail.getBody());
		textArea.setFont(new Font("Courier New", Font.BOLD, 16));
		scrollPane.setViewportView(textArea);
		
		JLabel label_2 = new JLabel("Priority:");
		label_2.setForeground(new Color(255, 255, 0));
		label_2.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		label_2.setBounds(10, 149, 136, 16);
		contentPane.add(label_2);
		
		JRadioButton radio1 = new JRadioButton("4 (Least)");
		radio1.setForeground(new Color(255, 255, 0));
		radio1.setBackground(new Color(0, 0, 0));
		radio1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio1.setBounds(546, 151, 103, 21);
		contentPane.add(radio1);
		
		JRadioButton radio2 = new JRadioButton("3");
		radio2.setForeground(new Color(255, 255, 0));
		radio2.setBackground(new Color(0, 0, 0));
		radio2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio2.setBounds(400, 151, 103, 21);
		contentPane.add(radio2);
		
		JRadioButton radio3 = new JRadioButton("2");
		radio3.setForeground(new Color(255, 255, 0));
		radio3.setBackground(new Color(0, 0, 0));
		radio3.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio3.setBounds(240, 151, 103, 21);
		contentPane.add(radio3);
		
		JRadioButton radio4 = new JRadioButton("1 (Most)");
		radio4.setForeground(new Color(255, 255, 0));
		radio4.setBackground(new Color(0, 0, 0));
		radio4.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio4.setBounds(92, 151, 111, 21);
		contentPane.add(radio4);
		ButtonGroup group = new ButtonGroup();
		group.add(radio4);
		group.add(radio3);
		group.add(radio2);
		group.add(radio1);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(255, 255, 0));
		lblFrom.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lblFrom.setBounds(10, 41, 136, 16);
		contentPane.add(lblFrom);
		
		txtFrom = new JTextField(mail.getFrom());
		txtFrom.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtFrom.setColumns(10);
		txtFrom.setBounds(92, 40, 557, 19);
		contentPane.add(txtFrom);
		
		JLabel lblDate = new JLabel(mail.getDate());
		lblDate.setForeground(new Color(255, 255, 0));
		lblDate.setFont(new Font("Snap ITC", Font.PLAIN, 13));
		lblDate.setBounds(438, 10, 211, 16);
		contentPane.add(lblDate);
		
		JRadioButton rdbtnAttachment = new JRadioButton("Attachment");
		rdbtnAttachment.setForeground(Color.YELLOW);
		rdbtnAttachment.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		rdbtnAttachment.setBackground(Color.BLACK);
		rdbtnAttachment.setBounds(10, 10, 121, 21);
		if (mail.isAttachment())rdbtnAttachment.setSelected(true);
		rdbtnAttachment.setEnabled(false);
		contentPane.add(rdbtnAttachment);
		
		JButton btnResend = new JButton("Resend");
		btnResend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mail.setAttachment(Attach);
				mail.setSubject(txtSub.getText());
				mail.setTo(txtTo.getText());
				mail.setBody(textArea.getText());
				if (radio1.isSelected())
					mail.setPriority("1");
				if (radio2.isSelected())
					mail.setPriority("2");
				if (radio3.isSelected())
					mail.setPriority("3");
				if (radio4.isSelected())
					mail.setPriority("4");
				if (app.compose(mail)) {
					dispose();
					JOptionPane.showMessageDialog(null, "Sent Succesfully........");
					if (app.currentFolder.getFolderPath().equals("Users\\"+app.currentUser.getEmail()+"\\Drafts")) {
						Single_Linked_list m = new Single_Linked_list();
						m.add(mail);
						app.deleteEmails(m);
					}
				} else
					JOptionPane.showMessageDialog(null, "Non-existing Reciever email");
			}
		});
		btnResend.setForeground(Color.YELLOW);
		btnResend.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		btnResend.setBackground(new Color(102, 51, 0));
		if (!app.currentFolder.getFolderPath().equals("Users\\"+app.currentUser.getEmail()+"\\Drafts"))
			btnResend.setEnabled(false);
		btnResend.setBounds(273, 613, 179, 21);
		contentPane.add(btnResend);
		
		
		if (mail.getPriority().equals("1")) radio1.setSelected(true);
		if (mail.getPriority().equals("2")) radio2.setSelected(true);
		if (mail.getPriority().equals("3")) radio3.setSelected(true);
		if (mail.getPriority().equals("4")) radio4.setSelected(true);
			
	}
	
}
