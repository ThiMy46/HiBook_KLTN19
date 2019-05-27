package ute.hibook.dto;

import java.util.List;

public class SearchDTO {

	private int totalpage;
	private int currentpage;
	private List<AuthorDTO> lstAuthor;
	private List<SupplierDTO> lstSupplier;
	private List<PublisherDTO> lstPublisher;
	
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public List<AuthorDTO> getLstAuthor() {
		return lstAuthor;
	}
	public void setLstAuthor(List<AuthorDTO> lstAuthor) {
		this.lstAuthor = lstAuthor;
	}
	public List<SupplierDTO> getLstSupplier() {
		return lstSupplier;
	}
	public void setLstSupplier(List<SupplierDTO> lstSupplier) {
		this.lstSupplier = lstSupplier;
	}
	public List<PublisherDTO> getLstPublisher() {
		return lstPublisher;
	}
	public void setLstPublisher(List<PublisherDTO> lstPublisher) {
		this.lstPublisher = lstPublisher;
	}
	
}
