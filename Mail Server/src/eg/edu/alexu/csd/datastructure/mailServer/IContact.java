package eg.edu.alexu.csd.datastructure.mailServer;

public interface IContact {
	public void setEmail(String email);
	public void setPhone(String phone);
	public void setPassword(String password);
	public void setUserName(String userName);
	public void setNickName (String nickName);
	public void setAll (String email,String phone,String password,String userName,String nickName);
	public String getEmail();
	public String getPhone();
	public String getPassword();
	public String getUserName();
	public String getNickName ();
}
