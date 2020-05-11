package eg.edu.alexu.csd.datastructure.mailServer;

public interface IMail {
	public String getBody();
	public void setBody(String body);
	public String getPriority();
	public void setPriority(String priority);
	public String getSubject();
	public void setSubject(String subject);
	public String getTo();
	public void setTo(String to);
	public String getFrom();
	public void setFrom(String from);
	public boolean isAttachment();
	public void setAttachment(boolean attachment);
	public String getDate();
	public void setDate(String date);
}
