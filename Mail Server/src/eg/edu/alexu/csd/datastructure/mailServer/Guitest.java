package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Guitest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton buttons[] = new JButton[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guitest frame = new Guitest();
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
	public Guitest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 134, 222, 222);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 210, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1220, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Guitest.class.getResource("/eg/edu/alexu/csd/datastructure/mailServer/interface (1).png")));
		button.setForeground(Color.RED);
		button.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button.setBounds(922, 57, 79, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_1.setBounds(838, 57, 71, 33);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setForeground(Color.RED);
		button_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_2.setBounds(922, 113, 79, 33);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_3.setBounds(838, 113, 71, 33);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setForeground(Color.RED);
		button_4.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_4.setBounds(922, 169, 79, 33);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_5.setBounds(838, 169, 71, 33);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setForeground(Color.RED);
		button_6.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_6.setBounds(922, 225, 79, 33);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_7.setBounds(838, 225, 71, 33);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setForeground(Color.RED);
		button_8.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_8.setBounds(922, 278, 79, 33);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setForeground(Color.BLACK);
		button_9.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_9.setBounds(838, 278, 71, 33);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setForeground(Color.RED);
		button_10.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_10.setBounds(922, 334, 79, 33);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setForeground(Color.BLACK);
		button_11.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_11.setBounds(838, 334, 71, 33);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setForeground(Color.RED);
		button_12.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_12.setBounds(922, 390, 79, 33);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setForeground(Color.BLACK);
		button_13.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_13.setBounds(838, 390, 71, 33);
		contentPane.add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setForeground(Color.RED);
		button_14.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_14.setBounds(922, 446, 79, 33);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("");
		button_15.setForeground(Color.BLACK);
		button_15.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_15.setBounds(838, 446, 71, 33);
		contentPane.add(button_15);
		
		JLabel label = new JLabel(" 1");
		label.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		label.setBounds(908, 504, 22, 28);
		contentPane.add(label);
		
		JButton button_16 = new JButton("");
		button_16.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_16.setBounds(856, 504, 42, 33);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("");
		button_17.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 16));
		button_17.setBounds(940, 504, 42, 33);
		contentPane.add(button_17);
		
		JLabel label_1 = new JLabel("02/05/2020");
		label_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		label_1.setBounds(26, 62, 96, 23);
		contentPane.add(label_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(446, 248, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		

		String names[] = {"Foo", "Bar", "Baz", "Fob", "Bao"};
		int x = 10;
		for (int i = 0; i < buttons.length; ++i)
		{
		    buttons[i] = new JButton(names[i]);
		    buttons[i].addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		Object src = e.getSource();
		    		for (int j=0;j<buttons.length;j++) {
		    			if (src==buttons[j]) {
		    				System.out.println("hello"+j);
			    		}
		    		}
		    		
				}
		    });
		    x=x+50;
		    buttons[i].setBounds(10,x, 172, 21);
		    panel.add(buttons[i]);
		}
	}
}
