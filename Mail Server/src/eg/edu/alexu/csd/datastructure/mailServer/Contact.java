package eg.edu.alexu.csd.datastructure.mailServer;

public class Contact implements IContact{
	
	private String email,phone,userName,password,nickName;
	
	public Contact() {
		this.email=null;
		this.phone=null;
		this.userName=null;
		this.password=null;
	}
	
	
	@Override
	public void setEmail(String email) {
		this.email=email;
	}
	@Override
	public void setPhone(String phone) {
		this.phone=phone;
	}
	@Override
	public void setPassword(String password) {
		this.password=password;
	}
	@Override
	public void setUserName(String userName) {
		this.userName=userName;
	}
	@Override
	public void setNickName (String nickName) {
		this.nickName=nickName;
	}
	@Override
	public void setAll (String email,String phone,String password,String userName,String nickName) {
		this.email=email;
		this.phone=phone;
		this.password=password;
		this.userName=userName;
		this.nickName=nickName;
	}
	@Override
	public String getEmail() {
		return this.email;
	}
	@Override
	public String getPhone() {
		return this.phone;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUserName() {
		return this.userName;
	}
	@Override
	public String getNickName () {
		return this.nickName;
	}
}
