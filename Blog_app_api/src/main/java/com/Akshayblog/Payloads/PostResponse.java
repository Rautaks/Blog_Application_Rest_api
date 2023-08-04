package com.Akshayblog.Payloads;

import java.util.List;

public class PostResponse {
	
	
	private List<PostDto> content;
	private int pageNumber;
	private int pageSizee;
	private long totalElement;
	private boolean lastPage;
	

	public PostResponse(List<PostDto> content, int pageNumber, int pageSizee, int totalElement, boolean lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSizee = pageSizee;
		this.totalElement = totalElement;
		this.lastPage = lastPage;
	}
	public PostResponse() {
		super();
		
	}
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSizee() {
		return pageSizee;
	}
	public void setPageSizee(int pageSizee) {
		this.pageSizee = pageSizee;
	}
	public long getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public void setTotalPages(int totalPages) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
