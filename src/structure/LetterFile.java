package structure;

public class LetterFile {
	private String directionName;
	private String oldName;
	private String newName;
	private String path;
	
	public String getdirectionName(){
		return this.directionName;
	}
	public void setdirectionName(String directionName){
		this.directionName = directionName;
	}
	public String getoldName(){
		return this.oldName;
	}
	public void setoldName(String oldName){
		this.oldName = oldName;
	}
	public String getnewName(){
		return this.newName;
	}
	public void setnewName(String newName){
		this.newName = newName;
	}
	public String getpath(){
		return this.path;
	}
	public void setpath(String path){
		this.path = path;
	}
}
