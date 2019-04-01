package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Book;

public class PromotionDTO {

	private int idPromotion;
	private String contentPromotion;
	private String picPromotion;
	private int saleOff;
	private String timeEnd;
	private String timeStart;
	private String titlePromotion;
	private List<Book> books;
	
	public int getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getContentPromotion() {
		return this.contentPromotion;
	}

	public void setContentPromotion(String contentPromotion) {
		this.contentPromotion = contentPromotion;
	}

	public String getPicPromotion() {
		return this.picPromotion;
	}

	public void setPicPromotion(String picPromotion) {
		this.picPromotion = picPromotion;
	}

	public int getSaleOff() {
		return this.saleOff;
	}

	public void setSaleOff(int saleOff) {
		this.saleOff = saleOff;
	}

	public String getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTitlePromotion() {
		return this.titlePromotion;
	}

	public void setTitlePromotion(String titlePromotion) {
		this.titlePromotion = titlePromotion;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
