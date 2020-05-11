package eg.edu.alexu.csd.datastructure.mailServer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.linkedList.csX22.Single_Linked_list;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;

public class GuiApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int y = 10;
	private JCheckBox fromCheck[];
	private JButton btnDeleteSelected;
	private JCheckBox selectAll;
	boolean temp=false;
	private JRadioButton rdbtnAttachment;
	private JRadioButton rdbtnImportance;
	private JRadioButton rdbtnDate;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GuiApp frame = new GuiApp();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public GuiApp(App app) {
		super("Mail Server App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 740);
		setLocationRelativeTo(null);
		//app.loadmails(app.currentFolder.getFolderPath());
		app.setViewingOptions(app.currentFolder,app.currentFilter,app.currentSort);
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

		JButton btnCompose = new JButton("Compose");
		btnCompose.setBackground(new Color(102, 51, 0));
		btnCompose.setForeground(new Color(255, 255, 0));
		btnCompose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				composeForm co = new composeForm(app);
				co.setVisible(true);
			}
		});
		btnCompose.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		btnCompose.setBounds(42, 125, 127, 33);
		contentPane.add(btnCompose);

		JLabel label = new JLabel("MailServer App");
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(502, 32, 217, 28);
		contentPane.add(label);

		JButton button_1 = new JButton("Settings");
		button_1.setBackground(new Color(102, 51, 0));
		button_1.setForeground(new Color(255, 255, 0));
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_1.setBounds(946, 33, 122, 44);
		contentPane.add(button_1);

		JButton button_2 = new JButton("Inbox");
		button_2.setBackground(new Color(102, 51, 0));
		button_2.setForeground(new Color(255, 255, 0));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.currentSort=new Sort();
				app.currentFilter=new Filter();
				app.currentFolder.setFolderPath("Users\\"+app.currentUser.getEmail()+"\\InboxD");
				app.setViewingOptions(app.currentFolder,app.currentFilter,app.currentSort);
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		button_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_2.setBounds(42, 179, 127, 33);
		contentPane.add(button_2);

		JButton button_3 = new JButton("SentMails");
		button_3.setBackground(new Color(102, 51, 0));
		button_3.setForeground(new Color(255, 255, 0));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.currentSort=new Sort();
				app.currentFilter=new Filter();
				app.currentFolder.setFolderPath("Users\\" + app.currentUser.getEmail() + "\\SentMails");
				app.setViewingOptions(app.currentFolder,app.currentFilter,app.currentSort);
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		button_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_3.setBounds(42, 239, 127, 33);
		contentPane.add(button_3);

		JButton button_4 = new JButton("Trash");
		button_4.setBackground(new Color(102, 51, 0));
		button_4.setForeground(new Color(255, 255, 0));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.currentSort=new Sort();
				app.currentFilter=new Filter();
				app.currentFolder.setFolderPath("Users\\"+app.currentUser.getEmail()+"\\Trash");
				app.setViewingOptions(app.currentFolder,app.currentFilter,app.currentSort);
				app.check30day(app.currentFolder,app.mails);
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		button_4.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_4.setBounds(42, 298, 127, 33);
		contentPane.add(button_4);

		JButton button_5 = new JButton("Drafts");
		button_5.setBackground(new Color(102, 51, 0));
		button_5.setForeground(new Color(255, 255, 0));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.currentSort=new Sort();
				app.currentFilter=new Filter();
				app.currentFolder.setFolderPath("Users\\"+app.currentUser.getEmail()+"\\Drafts");
				app.setViewingOptions(app.currentFolder,app.currentFilter,app.currentSort);
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		button_5.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_5.setBounds(42, 356, 127, 33);
		contentPane.add(button_5);

		JButton button_6 = new JButton("Filter");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FilterForm(app).setVisible(true);
			}
		});
		button_6.setBackground(new Color(102, 51, 0));
		button_6.setForeground(new Color(255, 255, 0));
		button_6.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 14));
		button_6.setBounds(42, 413, 71, 33);
		contentPane.add(button_6);

		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp=!temp;
				rdbtnAttachment.setEnabled(temp);
				rdbtnDate.setEnabled(temp);
				rdbtnImportance.setEnabled(temp);
			}
		});
		btnSort.setBackground(new Color(102, 51, 0));
		btnSort.setForeground(new Color(255, 255, 0));
		btnSort.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		btnSort.setBounds(42, 468, 127, 33);
		contentPane.add(btnSort);

		JButton button_8 = new JButton("LogOut");
		button_8.setBackground(new Color(102, 51, 0));
		button_8.setForeground(new Color(255, 255, 0));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginForm l = new loginForm(app);
				l.setVisible(true);
			}
		});
		button_8.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_8.setBounds(42, 641, 115, 33);
		contentPane.add(button_8);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		btnExit.setBounds(1081, 33, 76, 44);
		contentPane.add(btnExit);

		JLabel label_1 = new JLabel(app.currentUser.getUserName() + "(" + app.currentUser.getNickName() + ")");
		label_1.setForeground(new Color(255, 255, 0));
		label_1.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		label_1.setBounds(946, 87, 211, 28);
		contentPane.add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(196, 125, 900, 500);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		scrollPane.setViewportView(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 875, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 20 + 50 * app.mails.size(), Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		
		selectAll = new JCheckBox("Select All ..");
		selectAll.setBackground(new Color(0,0,0));
		selectAll.setForeground(new Color(255, 255, 0));
		selectAll.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		selectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < fromCheck.length; i++) {
					if (selectAll.isSelected()) {
						fromCheck[i].setSelected(true);
					}
					else {
						fromCheck[i].setSelected(false);
					}
				}
			}
		});
		selectAll.setBounds(307, 631 ,122,25);
		contentPane.add(selectAll);
		
		Single_Linked_list selectedMails = new Single_Linked_list();
		
		btnDeleteSelected = new JButton("Delete Selected");
		btnDeleteSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0 ; i<fromCheck.length ; i++) {
					if (fromCheck[i].isSelected())selectedMails.add(app.mails.get(i));
				}
				app.deleteEmails(selectedMails);
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		btnDeleteSelected.setIcon(new ImageIcon(GuiApp.class.getResource("/eg/edu/alexu/csd/datastructure/mailServer/interface (1).png")));
		btnDeleteSelected.setForeground(Color.RED);
		btnDeleteSelected.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		btnDeleteSelected.setBounds(447, 631, 176, 25);
		contentPane.add(btnDeleteSelected);
		
		rdbtnDate = new JRadioButton("Date");
		rdbtnDate.setForeground(Color.YELLOW);
		rdbtnDate.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 13));
		rdbtnDate.setBackground(Color.BLACK);
		rdbtnDate.setSelected(true);
		rdbtnDate.setEnabled(false);
		rdbtnDate.setBounds(42, 507, 115, 21);
		rdbtnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.currentSort.setDate();
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		contentPane.add(rdbtnDate);
		
		rdbtnImportance = new JRadioButton("Importance");
		rdbtnImportance.setForeground(Color.YELLOW);
		rdbtnImportance.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 13));
		rdbtnImportance.setBackground(Color.BLACK);
		rdbtnImportance.setEnabled(false);
		rdbtnImportance.setBounds(42, 530, 115, 21);
		rdbtnImportance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.currentSort.setImportance();
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		contentPane.add(rdbtnImportance);
		
		rdbtnAttachment = new JRadioButton("Attachment");
		rdbtnAttachment.setForeground(Color.YELLOW);
		rdbtnAttachment.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 13));
		rdbtnAttachment.setBackground(Color.BLACK);
		rdbtnAttachment.setEnabled(false);
		rdbtnAttachment.setBounds(42, 553, 115, 21);
		rdbtnAttachment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.currentSort.setAttachment();
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		contentPane.add(rdbtnAttachment);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAttachment);
		group.add(rdbtnImportance);
		group.add(rdbtnDate);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(GuiApp.class.getResource("/eg/edu/alexu/csd/datastructure/mailServer/arrows (1).png")));
		button.setForeground(Color.YELLOW);
		button.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button.setBackground(new Color(0, 0, 0));
		button.setBounds(196, 82, 57, 33);
		contentPane.add(button);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GuiApp(app).setVisible(true);
				dispose();
			}
		});
		btnOk.setForeground(Color.YELLOW);
		btnOk.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 14));
		btnOk.setBackground(new Color(102, 51, 0));
		btnOk.setBounds(112, 413, 57, 33);
		contentPane.add(btnOk);
		
		if (app.mails.isEmpty()) {
			selectAll.setEnabled(false);
			btnDeleteSelected.setEnabled(false);
		}
		
		JButton subButtons[] = new JButton[app.mails.size()];
		JButton deleteButtons[] = new JButton[app.mails.size()];
		JLabel dateLabel[] = new JLabel[app.mails.size()];
		fromCheck = new JCheckBox[app.mails.size()];
		for (int i = subButtons.length-1; i >= 0 ; i--) {
			dateLabel[i] = new JLabel(((Mail) app.mails.get(i)).getDate());
			dateLabel[i].setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 13));
			dateLabel[i].setBackground(new Color(102, 51, 0));
			dateLabel[i].setForeground(new Color(255, 255, 0));
			fromCheck[i] = new JCheckBox(((Mail) app.mails.get(i)).getSubject()+".....................");
			fromCheck[i].setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
			fromCheck[i].setBackground(new Color(0,0,0));
			fromCheck[i].setForeground(new Color(255, 255, 0));
			subButtons[i] = new JButton("   "+((Mail) app.mails.get(i)).getBody());
			subButtons[i].setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
			subButtons[i].setForeground(new Color(255, 255, 0));
			subButtons[i].setBackground(new Color(0,0,0));
			subButtons[i].setIcon(new ImageIcon(Guitest.class.getResource("/eg/edu/alexu/csd/datastructure/mailServer/bubble-speech.png")));
			subButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object src = e.getSource();
					for (int j = 0; j < subButtons.length; j++) {
						if (src == subButtons[j]) {
							new ViewForm((Mail) app.mails.get(j),app).setVisible(true);
						}
					}
				}
			});
			deleteButtons[i] = new JButton("");
			deleteButtons[i].setIcon(new ImageIcon(Guitest.class.getResource("/eg/edu/alexu/csd/datastructure/mailServer/interface (1).png")));
			deleteButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object src = e.getSource();
					for (int j = 0; j < deleteButtons.length; j++) {
						if (src == deleteButtons[j]) {
							Single_Linked_list temp = new Single_Linked_list();
							temp.add((Mail)app.mails.get(j));
							app.deleteEmails(temp);
							new GuiApp(app).setVisible(true);
							dispose();
						}
					}
				}
			});
			dateLabel[i].setBounds(10, y+12 ,100,25);
			fromCheck[i].setBounds(110, y+12 ,120,25);
			subButtons[i].setBounds(230, y, 600, 50);
			deleteButtons[i].setBounds(830,y,50,50);
			y = y + 50;
			panel.add(dateLabel[i]);
			panel.add(subButtons[i]);
			panel.add(deleteButtons[i]);
			panel.add(fromCheck[i]);
		}
	}
}
