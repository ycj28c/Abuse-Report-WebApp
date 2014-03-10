package structure;

public class Page {
	private int pageSize;
	private int totalNum;
	private int totalPage;
	public int currentPage;
	public int nextPage;
	public int previousPage;
	
	public Page() {  
		this.pageSize = 0;
		this.totalNum = 0;
		this.totalPage = 0;
		this.currentPage = 0;  
		this.nextPage = 0;  
		this.previousPage = 0;  
	} 
	
	public Page(int totalNum, int pageSize, int currentPage) {  
		this.currentPage = currentPage;  
		this.totalNum = totalNum;  
		this.pageSize = pageSize;  
	} 
	 
	public void generatepage(){
		this.previousPage = this.currentPage - 1;
		this.nextPage = this.currentPage + 1;
		this.totalPage = this.totalNum/this.pageSize+(this.totalNum%this.pageSize> 0 ? 1 : 0);
	}
	
	public int getPageSize(){
		return this.pageSize;
	}
	public int getTotalNum(){
		return this.totalNum;
	}
	public int getTotalPage(){
		return this.totalPage;
	}
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
	public void setTotalNum(int totalNum){
		this.totalNum = totalNum;
	}
	public void setTotalPage(int totalPage){
		this.totalPage = totalPage;
	}
	
}
