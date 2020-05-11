package eg.edu.alexu.csd.datastructure.mailServer;

public class Sort implements ISort {
	
	private boolean Date, Priority, Attachment;

	public Sort() {
		setDate();
	}

	@Override
	public void setDate() {
		Date = true;
		Priority = false;
		Attachment = false;
	}

	@Override
	public void setImportance() {
		Date = false;
		Priority = true;
		Attachment = false;
	}

	@Override
	public void setAttachment() {
		Date = false;
		Priority = false;
		Attachment = true;
	}

	@Override
	public boolean isAttachment() {
		return Attachment;
	}
	
	@Override
	public boolean isDate() {
		return Date;
	}
	
	@Override
	public boolean isPriority() {
		return Priority;
	}

}
