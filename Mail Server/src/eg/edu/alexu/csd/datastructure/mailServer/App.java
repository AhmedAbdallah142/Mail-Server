package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import eg.edu.alexu.csd.datastructure.linkedList.csX22.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.csX22.Single_Linked_list;
import eg.edu.alexu.csd.datastructure.stack.Stack;

public class App implements IApp {

	private Single_Linked_list contacts = new Single_Linked_list();
	public Single_Linked_list mails = new Single_Linked_list();

	public Contact currentUser = new Contact();
	public Folder currentFolder = new Folder();
	public Sort currentSort = new Sort();
	public Filter currentFilter = new Filter();

	public void loadContacts() {
		try {
			File f = new File("Users\\index.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));
			String line;
			while ((line = b.readLine()) != null) {
				Contact c = new Contact();
				if (line.substring(0, 6).equals("Email:")) {
					c.setEmail(line.substring(6));
					line = b.readLine();
				}
				if (line.substring(0, 5).equals("Pass:")) {
					c.setPassword(line.substring(5));
					line = b.readLine();
				}
				if (line.substring(0, 6).equals("UName:")) {
					c.setUserName(line.substring(6));
					line = b.readLine();
				}
				if (line.substring(0, 6).equals("Phone:")) {
					c.setPhone(line.substring(6));
					line = b.readLine();
				}
				if (line.substring(0, 6).equals("NName:")) {
					c.setNickName(line.substring(6));
					line = b.readLine();
				}
				if (line.equals("----------------------------"))
					contacts.add(c);
			}
			b.close();
			loginForm l = new loginForm(this);
			l.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Welcome to our program with your first use");
			// we can add the program information here for the first use
			GuiSignUp s = new GuiSignUp(this);
			s.setVisible(true);
		}
	}

	public void loadmails(String filePath) {
		try {
			File f = new File(filePath + "\\index.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));
			String line;
			mails.clear();
			while ((line = b.readLine()) != null) {
				Mail m = new Mail();
				if (line.substring(0, 5).equals("Subj:")) {
					m.setSubject(line.substring(5));
					line = b.readLine();
				}
				if (line.substring(0, 5).equals("From:")) {
					m.setFrom(line.substring(5));
					line = b.readLine();
				}
				if (line.substring(0, 5).equals("To  :")) {
					m.setTo(line.substring(5));
					line = b.readLine();
				}
				if (line.substring(0, 5).equals("Prio:")) {
					m.setPriority(line.substring(5));
					line = b.readLine();
				}
				if (line.substring(0, 5).equals("Date:")) {
					m.setDate(line.substring(5));
					line = b.readLine();
				}
				if (line.substring(0, 5).equals("Atta:")) {
					if (line.substring(5).equals("false"))
						m.setAttachment(false);
					else
						m.setAttachment(true);
					line = b.readLine();
				}
				if (line.substring(0, 5).equals("Body:")) {
					String temp = line.substring(5);
					while (!(line = b.readLine()).equals("----------------------------"))
						temp += "\n" + line;
					m.setBody(temp);
				}
				if (line.equals("----------------------------"))
					mails.add(m);
			}
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signin(String email, String password) {
		/*
		 * boolean checkMail = false, checkPass = false; try { String path =
		 * Paths.get("").toAbsolutePath().toString()+"\\Users\\"; File f = new
		 * File("Users\\index.txt"); BufferedReader b = new BufferedReader(new
		 * FileReader(f)); String line; while (checkMail == false && (line =
		 * b.readLine()) != null) { if (line.substring(0, 6).equals("Email:") &&
		 * line.substring(6).equals(email)) { checkMail = true; while (checkPass ==
		 * false && !(line = b.readLine()).equals("----------------------------")) { if
		 * (line.substring(0, 5).equals("Pass:") &&
		 * (line.substring(5).equals(password))) { checkPass = true; } } } } b.close();
		 * } catch (Exception e) { return false; } if (!checkPass && checkMail) throw
		 * new RuntimeException("Incorrect Password..! ");
		 */
		Contact c = new Contact();
		for (int i = 0; i < contacts.size(); i++) {
			c = (Contact) contacts.get(i);
			if (email.equals(c.getEmail())) {
				if (password.equals(c.getPassword())) {
					currentUser = c;
					currentFolder.setFolderPath("Users\\" + currentUser.getEmail() + "\\InboxD");
					return true;
				} else {
					throw new RuntimeException("Incorrect Password..! ");
				}
			}
		}
		return false;
	}

	@Override
	public boolean signup(IContact contact) {
		try {
			File f = new File("Users\\" + contact.getEmail()/* +"\\Inbox" */);
			boolean exist = f.exists();
			if (exist)
				return false;
			f.mkdirs();
			FileWriter file = new FileWriter("Users\\index.txt", true);
			PrintWriter w = new PrintWriter(file);
			w.println("Email:" + contact.getEmail() + "\nPass:" + contact.getPassword() + "\nUName:"
					+ contact.getUserName() + "\nPhone:" + contact.getPhone() + "\nNName:" + contact.getNickName()
					+ "\n" + "----------------------------");
			w.close();
			contacts.add(contact);
			currentUser = (Contact) contact;
			currentFolder.setFolderPath("Users\\" + currentUser.getEmail() + "\\InboxD");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return true;
	}

	@Override
	public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
		loadmails(folder.getFolderPath());
		if (filter.getPriority() != null) {
			for (int i = 0; i < mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) mails.get(i);
				if (!m.getPriority().equals(filter.getPriority())) {
					mails.remove(i);
					i--;
				}
			}
		}
		if (filter.getSubject() != null) {
			for (int i = 0; i < mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) mails.get(i);
				if (!m.getSubject().equals(filter.getSubject())) {
					mails.remove(i);
					i--;
				}
			}
		}
		if (filter.getFromMail() != null) {
			for (int i = 0; i < mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) mails.get(i);
				if (!m.getFrom().equals(filter.getFromMail())) {
					mails.remove(i);
					i--;
				}
			}
		}
		if (filter.getToMail() != null) {
			for (int i = 0; i < mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) mails.get(i);
				if (!m.getTo().equals(filter.getToMail())) {
					mails.remove(i);
					i--;
				}
			}
		}
		if (filter.getDate() != null) {
			if (filter.isBefore()) {
				for (int i = 0; i < mails.size(); i++) {
					Mail m = new Mail();
					m = (Mail) mails.get(i);
					if (checkdate(m.getDate().substring(0, 10), filter.getDate()) != -1) {
						mails.remove(i);
						i--;
					}
				}
			}
			if (filter.isAfter()) {
				for (int i = 0; i < mails.size(); i++) {
					Mail m = new Mail();
					m = (Mail) mails.get(i);
					if (checkdate(m.getDate().substring(0, 10), filter.getDate()) != 1) {
						mails.remove(i);
						i--;
					}
				}
			}

			if (filter.isAt()) {
				for (int i = 0; i < mails.size(); i++) {
					Mail m = new Mail();
					m = (Mail) mails.get(i);
					if (checkdate(filter.getDate(), m.getDate().substring(0, 10)) != 0) {
						/*System.out.println(filter.getDate());
						System.out.println(m.getDate().substring(0, 10));*/
						mails.remove(i);
						i--;
					}
				}
			}
		}
		if (sort.isPriority()) {
			PriorityQueue p = new PriorityQueue();
			for (int i = 0; i < mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) mails.get(i);
				p.insert(m, Integer.parseInt(m.getPriority()));
			}
			mails.clear();
			while (!p.isEmpty()) {
				mails.add(p.removeMin());
			}
		}
		if (sort.isAttachment()) {
			// LinkedBasedQueue q = new LinkedBasedQueue();
			Stack s = new Stack();
			for (int i = 0; i < mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) mails.get(i);
				if (m.isAttachment()) {
					s.push(m);
					// q.enqueue(m);
					mails.remove(i);
					i--;
				}
			}
			for (int i = 0; i < mails.size(); i++) {
				s.push(mails.get(i));
			}
			mails.clear();
			while (!s.isEmpty()) {
				mails.add(s.pop());
			}
		}

	}

	public int checkdate(String Date1, String Date2) {
		if (Date1.equals(Date2))
			return 0;
		else if ((Integer.parseInt(Date1.substring(6)) > Integer.parseInt(Date2.substring(6, 10)))
				|| ((Integer.parseInt(Date1.substring(6)) == Integer.parseInt(Date2.substring(6, 10)))
						&& (Integer.parseInt(Date1.substring(3, 5)) > Integer.parseInt(Date2.substring(3, 5))))
				|| ((Integer.parseInt(Date1.substring(6)) == Integer.parseInt(Date2.substring(6, 10)))
						&& (Integer.parseInt(Date1.substring(3, 5)) == Integer.parseInt(Date2.substring(3, 5)))
						&& (Integer.parseInt(Date1.substring(0, 2)) > Integer.parseInt(Date2.substring(0, 2)))))
			return 1;
		else
			return -1;
	}


	@Override
	public IMail[] listEmails(int page) {

		return null;
	}

	@Override
	public void deleteEmails(ILinkedList mails) {
		try {
			Folder f = new Folder();
			f.setFolderPath("Users\\" + currentUser.getEmail() + "\\Trash");
			if (f != currentFolder
					&& !currentFolder.getFolderPath().equals("Users\\" + currentUser.getEmail() + "\\Drafts"))
				moveEmails(mails, f);
			for (int i = 0; i < mails.size(); i++) {
				Mail deleteMail = new Mail();
				deleteMail = (Mail) mails.get(i);
				for (int j = 0; j < this.mails.size(); j++) {
					Mail tempMail = new Mail();
					tempMail = (Mail) this.mails.get(j);
					if (tempMail == deleteMail) {
						this.mails.remove(j);
						break;
					}
				}
			}
			FileWriter file = new FileWriter(currentFolder.getFolderPath() + "\\index.txt");
			PrintWriter w = new PrintWriter(file);
			w.print("");
			for (int i = 0; i < this.mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) this.mails.get(i);
				w.println("Subj:" + m.getSubject() + "\nFrom:" + m.getFrom() + "\nTo  :" + m.getTo() + "\nPrio:"
						+ m.getPriority() + "\nDate:" + m.getDate() + "\nAtta:" + m.isAttachment() + "\nBody:"
						+ m.getBody() + "\n----------------------------");
			}
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void moveEmails(ILinkedList mails, IFolder des) {
		try {
			File f = new File(des.getFolderPath());
			f.mkdirs();
			FileWriter file = new FileWriter(des.getFolderPath() + "\\index.txt", true);
			PrintWriter w = new PrintWriter(file);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy --> HH:mm:ss");
			Date date = new Date();
			for (int i = 0; i < mails.size(); i++) {
				Mail m = new Mail();
				m = (Mail) mails.get(i);
				w.println("Subj:" + m.getSubject() + "\nFrom:" + m.getFrom() + "\nTo  :" + m.getTo() + "\nPrio:"
						+ m.getPriority() + "\nDate:" + formatter.format(date) + "\nAtta:" + m.isAttachment()
						+ "\nBody:" + m.getBody() + "\n----------------------------");
			}
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean compose(IMail email) {
		File f = new File("Users\\" + email.getTo());
		if (!f.exists())
			return false;
		Single_Linked_list mail = new Single_Linked_list();
		mail.add(email);
		Folder folder = new Folder();
		folder.setFolderPath("Users\\" + email.getTo() + "\\InboxD");
		moveEmails(mail, folder);
		folder.setFolderPath("Users\\" + email.getFrom() + "\\SentMails");
		moveEmails(mail, folder);
		return true;
	}

	public void check30day(IFolder folder, Single_Linked_list mails) {
		Single_Linked_list s = new Single_Linked_list();
		Mail m = new Mail();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String currentDate = formatter.format(date);
		for (int i = 0; i < mails.size(); i++) {
			m = (Mail) mails.get(i);
			String mailDate = m.getDate();
			if ((Integer.parseInt(currentDate.substring(6)) - Integer.parseInt(mailDate.substring(6, 10)) >= 1)
					|| (Integer.parseInt(currentDate.substring(3, 5)) - Integer.parseInt(mailDate.substring(3, 5)) >= 2)
					|| (Integer.parseInt(currentDate.substring(0, 2))
							- Integer.parseInt(mailDate.substring(0, 2))) >= 30
					|| ((Integer.parseInt(currentDate.substring(3, 5))
							- Integer.parseInt(mailDate.substring(3, 5)) >= 1)
							&& (Integer.parseInt(currentDate.substring(0, 2)) >= Integer
									.parseInt(mailDate.substring(0, 2)))))
				s.add(m);

		}
		deleteEmails(s);
	}

}
