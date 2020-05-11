package eg.edu.alexu.csd.datastructure.mailServer;

public class Mail implements IMail {
	
	
	private String subject,from,to,priority,body,date;
	private boolean attachment;
	public Mail() {
		this.from=null;
		this.body=null;
		this.priority=null;
		this.subject=null;
		this.to=null;
		this.attachment=false;
		this.date=null;
	}

	@Override
	public String getBody() {
		return this.body;
	}

	@Override
	public void setBody(String body) {
		this.body=body;
	}

	@Override
	public String getPriority() {
		return this.priority;
	}

	@Override
	public void setPriority(String priority) {
		this.priority=priority;
	}

	@Override
	public String getSubject() {
		return this.subject;
	}

	@Override
	public void setSubject(String subject) {
		this.subject=subject;
	}

	@Override
	public String getTo() {
		return this.to;
	}

	@Override
	public void setTo(String to) {
		this.to=to;
	}

	@Override
	public String getFrom() {
		return this.from;
	}

	@Override
	public void setFrom(String from) {
		this.from=from;
	}
	
	@Override
	public boolean isAttachment() {
		return attachment;
	}

	@Override
	public void setAttachment(boolean attachment) {
		this.attachment = attachment;
	}

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public void setDate(String date) {
		this.date = date;
	}
	
}
