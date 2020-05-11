package eg.edu.alexu.csd.datastructure.mailServer;

public class Folder implements IFolder{
	
	private String folderPath;
	
	public Folder() {
		this.setFolderPath(null);
	}
	
	
	@Override
	public String getFolderPath() {
		return folderPath;
	}
	@Override
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

}
