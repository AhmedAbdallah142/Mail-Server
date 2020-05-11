package eg.edu.alexu.csd.datastructure.mailServer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm frame = new loginForm();
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
	public loginForm(App app) {
		super("Mail Server Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 309);
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
		
		JLabel label = new JLabel("Welcome to Our Mail Server \r\nPlease log in or sign up .........");
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 19));
		label.setBounds(65, 10, 536, 37);
		contentPane.add(label);
		
		JButton button = new JButton("Log In");
		button.setBackground(new Color(102, 51, 0));
		button.setForeground(new Color(255, 255, 0));
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
					//c.setEmail(txtMail.getText());
					//c.setPassword(passwordField.getText());
					try {
						if (app.signin(txtMail.getText(),passwordField.getText())) {
							dispose();
							GuiApp a=new GuiApp(app);
							a.setVisible(true);
						}
						else
							JOptionPane.showMessageDialog(null,"Can't Match the Email with an Account Please Enter Correct Email or Sign Up...!");
					}catch(Exception ex){
						passwordField.setText("");
						passwordField.requestFocus();
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}else {
					JOptionPane.showMessageDialog(null,"Empty Fields   '_'   ! ");
				}
			}
		});
		button.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		button.setBounds(224, 161, 179, 21);
		contentPane.add(button);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		txtMail.setColumns(10);
		txtMail.setBounds(197, 69, 283, 19);
		contentPane.add(txtMail);
		
		JLabel label_1 = new JLabel("User Email : ");
		label_1.setForeground(new Color(255, 255, 0));
		label_1.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		label_1.setBounds(65, 70, 122, 16);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		passwordField.setBounds(197, 116, 283, 19);
		contentPane.add(passwordField);
		
		JLabel label_2 = new JLabel("Password : ");
		label_2.setForeground(new Color(255, 255, 0));
		label_2.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		label_2.setBounds(65, 115, 122, 16);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("Sign Up");
		button_1.setBackground(new Color(102, 51, 0));
		button_1.setForeground(new Color(255, 255, 0));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GuiSignUp s = new GuiSignUp(app);
				s.setVisible(true);
			}
		});
		button_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		button_1.setBounds(224, 229, 179, 21);
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel("  Or");
		label_3.setForeground(new Color(255, 255, 0));
		label_3.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 17));
		label_3.setBounds(286, 199, 45, 20);
		contentPane.add(label_3);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setForeground(Color.RED);
		button_2.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		button_2.setBounds(518, 229, 71, 29);
		contentPane.add(button_2);
	}
	@SuppressWarnings("deprecation")
	private boolean checkFields() {
		if (txtMail.getText().isEmpty()) {
			txtMail.requestFocus();
			return false;
		}
		if (passwordField.getText().isEmpty()) {
			passwordField.requestFocus();
			return false;
		}
		return true;
	}
}
