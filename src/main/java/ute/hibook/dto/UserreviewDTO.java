package ute.hibook.dto;

import ute.hibook.entity.Book;
import ute.hibook.entity.User;

public class UserreviewDTO {

	private int idReview;
	private String content;
	private int reportNum;
	private int star;
	private String timeReview;
	private String title;
	private Book book;
	private User user;

	public int getIdReview() {
		return this.idReview;
	}

	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReportNum() {
		return this.reportNum;
	}

	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}

	public int getStar() {
		return this.star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getTimeReview() {
		return this.timeReview;
	}

	public void setTimeReview(String timeReview) {
		this.timeReview = timeReview;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
