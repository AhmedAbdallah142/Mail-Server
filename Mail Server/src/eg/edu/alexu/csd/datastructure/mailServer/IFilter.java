package eg.edu.alexu.csd.datastructure.mailServer;

public interface IFilter {
	public String getToMail();
	public void setToMail(String toMail);
	public String getDate();
	public void setDate(String date);
	public String getSubject();
	public void setSubject(String subject);
	public String getPriority();
	public void setPriority(String priority);
	public String getFromMail();
	public void setFromMail(String fromMail);
	public boolean isAfter();
	public void setAfter(boolean after);
	public boolean isBefore();
	public void setBefore(boolean before);
	public boolean isAt();
	public void setAt(boolean at);
}
