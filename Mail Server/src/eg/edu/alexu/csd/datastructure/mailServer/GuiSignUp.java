package eg.edu.alexu.csd.datastructure.mailServer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GuiSignUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPhone;
	private JTextField txtNick;
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSignUp frame = new GuiSignUp();
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
	public GuiSignUp(App app) {
		super("Mail Server Sign Up");
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 501);
		setLocationRelativeTo(null);
		try {
			Image img = ImageIO.read(getClass().getResource("mail.png"));
			setIconImage(img);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		getContentPane().setLayout(null);
		
		JLabel lblUserinformation = new JLabel("User Information");
		lblUserinformation.setForeground(new Color(255, 255, 0));
		lblUserinformation.setBounds(270, 38, 217, 28);
		lblUserinformation.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		getContentPane().add(lblUserinformation);
		
		JLabel lblName = new JLabel("User Name : ");
		lblName.setForeground(new Color(255, 255, 0));
		lblName.setBounds(56, 124, 136, 16);
		lblName.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		getContentPane().add(lblName);
		
		JLabel lblUserNickname = new JLabel("Nickname : ");
		lblUserNickname.setForeground(new Color(255, 255, 0));
		lblUserNickname.setBounds(56, 169, 131, 16);
		lblUserNickname.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		getContentPane().add(lblUserNickname);
		
		JLabel lblPhone = new JLabel("Phone : ");
		lblPhone.setForeground(new Color(255, 255, 0));
		lblPhone.setBounds(56, 215, 79, 16);
		lblPhone.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		getContentPane().add(lblPhone);
		
		JLabel lblEmails = new JLabel("Emails : ");
		lblEmails.setForeground(new Color(255, 255, 0));
		lblEmails.setBounds(56, 300, 79, 16);
		lblEmails.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		getContentPane().add(lblEmails);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setForeground(new Color(255, 255, 0));
		lblPassword.setBounds(56, 255, 95, 16);
		lblPassword.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		getContentPane().add(lblPassword);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(161, 216, 520, 19);
		txtPhone.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		getContentPane().add(txtPhone);
		
		txtNick = new JTextField();
		txtNick.setBounds(161, 170, 520, 19);
		txtNick.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtNick.setColumns(10);
		getContentPane().add(txtNick);
		
		txtUser = new JTextField();
		txtUser.setBounds(161, 125, 520, 19);
		txtUser.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtUser.setColumns(10);
		getContentPane().add(txtUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 256, 520, 19);
		getContentPane().add(passwordField);
		
		JButton button = new JButton("Sign Up");
		button.setBackground(new Color(102, 51, 0));
		button.setForeground(new Color(255, 255, 0));
		button.setBounds(308, 371, 179, 21);
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
					Contact c = new Contact();
					c.setAll(txtEmail.getText(),txtPhone.getText(),passwordField.getText(),txtUser.getText(),txtNick.getText());
					if (app.signup(c)) {
						dispose();
						GuiApp a = new GuiApp(app);
						a.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"This Email have an account");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Empty Fields   '_'   ! ");
				}
			}
		});
		button.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Exit");
		button_1.setBounds(681, 400, 71, 29);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		getContentPane().add(button_1);
		getContentPane().add(button);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(161, 301, 520, 19);
		getContentPane().add(txtEmail);
		
		JButton btnBack = new JButton("");
		btnBack.setBackground(new Color(102, 51, 0));
		btnBack.setIcon(new ImageIcon(GuiSignUp.class.getResource("/eg/edu/alexu/csd/datastructure/mailServer/back.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginForm l = new loginForm(app);
				l.setVisible(true);
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		btnBack.setBounds(73, 46, 24, 24);
		getContentPane().add(btnBack);
		
	}
	@SuppressWarnings("deprecation")
	private boolean checkFields() {
		if (txtUser.getText().isEmpty()) {
			txtUser.requestFocus();
			return false;
		}
		if (txtNick.getText().isEmpty()) {
			txtNick.requestFocus();
			return false;
		}
		if (txtPhone.getText().isEmpty()) {
			txtPhone.requestFocus();
			return false;
		}
		if (passwordField.getText().isEmpty()) {
			passwordField.requestFocus();
			return false;
		}
		if (txtEmail.getText().isEmpty()) {
			txtEmail.requestFocus();
			return false;
		}
		return true;
	}
}
