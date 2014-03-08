package itext;

public interface LetterInterface {
	public void setPath(String path);
	public String getPDFPath();
	public String getPDFname();
	public void makeLetter() throws Exception;
}
