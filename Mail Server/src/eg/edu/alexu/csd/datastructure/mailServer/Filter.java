package eg.edu.alexu.csd.datastructure.mailServer;

public class Filter implements IFilter {
	
	private String date ,priority,fromMail,toMail,Subject;
	private boolean at,before ,after;
	
	public Filter() {
		this.after=false;
		this.at=false;
		this.before=false;
		this.date=null;
		this.fromMail=null;
		this.priority=null;
		this.Subject=null;
		this.toMail=null;
	}
	@Override
	public String getToMail() {
		return toMail;
	}
	@Override
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	@Override
	public String getDate() {
		return date;
	}
	@Override
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String getSubject() {
		return Subject;
	}
	@Override
	public void setSubject(String subject) {
		Subject = subject;
	}
	@Override
	public String getPriority() {
		return priority;
	}
	@Override
	public void setPriority(String priority) {
		this.priority = priority;
	}
	@Override
	public String getFromMail() {
		return fromMail;
	}
	@Override
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}
	@Override
	public boolean isAfter() {
		return after;
	}
	@Override
	public void setAfter(boolean after) {
		this.after = after;
	}
	@Override
	public boolean isBefore() {
		return before;
	}
	@Override
	public void setBefore(boolean before) {
		this.before = before;
	}
	@Override
	public boolean isAt() {
		return at;
	}
	@Override
	public void setAt(boolean at) {
		this.at = at;
	}
	

}
