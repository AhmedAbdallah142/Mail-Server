package eg.edu.alexu.csd.datastructure.mailServer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.linkedList.csX22.Single_Linked_list;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class composeForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTo;
	private JTextField txtSub;
	private JTextArea textArea;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JRadioButton radio4;
	private boolean Attach = false;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { composeForm frame = new composeForm();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public composeForm(App app) {
		super("Mail Server Compose form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (!checkDraft()) {
					exitOperation(app.currentUser.getEmail());
					JOptionPane.showMessageDialog(null,"Saved To Draft....");
				}
			}
		});

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

		JLabel lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(255, 255, 0));
		lblTo.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lblTo.setBounds(10, 25, 136, 16);
		contentPane.add(lblTo);

		JLabel lblSub = new JLabel("Subject:");
		lblSub.setForeground(new Color(255, 255, 0));
		lblSub.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lblSub.setBounds(10, 66, 136, 16);
		contentPane.add(lblSub);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mail m = new Mail();
				saveData(app.currentUser.getEmail(), m);
				if (app.compose(m)) {
					dispose();
					JOptionPane.showMessageDialog(null, "Sent Succesfully........");
				} else
					JOptionPane.showMessageDialog(null, "Non-existing Reciever email");
			}
		});
		btnSend.setBackground(new Color(102, 51, 0));
		btnSend.setForeground(new Color(255, 255, 0));
		btnSend.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		btnSend.setBounds(282, 594, 179, 21);
		contentPane.add(btnSend);

		txtTo = new JTextField();
		txtTo.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtTo.setColumns(10);
		txtTo.setBounds(92, 24, 557, 19);
		contentPane.add(txtTo);

		txtSub = new JTextField();
		txtSub.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtSub.setColumns(10);
		txtSub.setBounds(92, 65, 557, 19);
		contentPane.add(txtSub);

		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkDraft()) {
					exitOperation(app.currentUser.getEmail());
					JOptionPane.showMessageDialog(null,"Saved To Draft....");
				}
				dispose();
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		button_1.setBounds(631, 610, 71, 29);
		contentPane.add(button_1);

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
		button.setBounds(236, 594, 36, 21);
		contentPane.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 153, 700, 419);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.BOLD, 16));
		scrollPane.setViewportView(textArea);

		JLabel lblPriority = new JLabel("Priority:");
		lblPriority.setForeground(new Color(255, 255, 0));
		lblPriority.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lblPriority.setBounds(10, 108, 136, 16);
		contentPane.add(lblPriority);

		radio1 = new JRadioButton("4  (Least)");
		radio1.setBackground(new Color(0, 0, 0));
		radio1.setForeground(new Color(255, 255, 0));
		radio1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio1.setBounds(544, 110, 105, 21);
		contentPane.add(radio1);

		radio2 = new JRadioButton("3");
		radio2.setBackground(new Color(0, 0, 0));
		radio2.setForeground(new Color(255, 255, 0));
		radio2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio2.setBounds(386, 110, 103, 21);
		contentPane.add(radio2);

		radio3 = new JRadioButton("2");
		radio3.setBackground(new Color(0, 0, 0));
		radio3.setForeground(new Color(255, 255, 0));
		radio3.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio3.setBounds(243, 110, 103, 21);
		contentPane.add(radio3);

		radio4 = new JRadioButton("1  (Most)");
		radio4.setBackground(new Color(0, 0, 0));
		radio4.setForeground(new Color(255, 255, 0));
		radio4.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		radio4.setBounds(92, 110, 103, 21);
		contentPane.add(radio4);

		ButtonGroup group = new ButtonGroup();
		group.add(radio4);
		group.add(radio3);
		group.add(radio2);
		group.add(radio1);

	}

	public void saveData(String CurrentUserMail, Mail m) {
		/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy --> HH:mm:ss");
		Date date = new Date();
		m.setDate(formatter.format(date));*/
		m.setBody(textArea.getText());
		m.setFrom(CurrentUserMail);
		m.setSubject(txtSub.getText());
		m.setTo(txtTo.getText());
		m.setAttachment(Attach);
		if (radio1.isSelected())
			m.setPriority("1");
		if (radio2.isSelected())
			m.setPriority("2");
		if (radio3.isSelected())
			m.setPriority("3");
		if (radio4.isSelected())
			m.setPriority("4");
	}

	private void exitOperation(String CurrentUserMail) {
		App app = new App();
		Mail m = new Mail();
		saveData(CurrentUserMail, m);
		Single_Linked_list mail = new Single_Linked_list();
		mail.add(m);
		Folder folder = new Folder();
		folder.setFolderPath("Users\\" + CurrentUserMail + "\\Drafts");
		app.moveEmails(mail, folder);
	}

	private boolean checkDraft() {
		if (txtTo.getText().isEmpty() && txtSub.getText().isEmpty() && textArea.getText().isEmpty())
			return true;
		return false;
	}
}
