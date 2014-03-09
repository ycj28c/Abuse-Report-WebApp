package structure;

public class Page {
	private int pageIndex;
	private int pageSize;
	private int totalNum;
	
	public Page() {  
		this.pageIndex = 0;  
		this.pageSize = 0;  
		this.totalNum = 0;  
	} 
	
	public Page(int pageIndex, int pageSize, int totalNum) {  
		this.pageIndex = pageIndex;  
		this.pageSize = pageSize;  
		this.totalNum = totalNum;  
	} 
	 
	public int getPageIndex(){
		return pageIndex;
	}
	public int getpageSize(){
		return pageSize;
	}
	public int gettotalNum(){
		return totalNum;
	}
	public void setPageIndex(int pageIndex){
		this.pageIndex = pageIndex;
	}
	public void setpageSize(int pageSize){
		this.pageSize = pageSize;
	}
	public void settotalNum(int totalNum){
		this.totalNum = totalNum;
	}
	
}
