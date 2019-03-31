package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity(name="promotion")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPromotion;

	@Lob
	private String contentPromotion;

	private String picPromotion;

	private int saleOff;

	private String timeEnd;

	private String timeStart;

	private String titlePromotion;

	//bi-directional many-to-many association to Book
	@ManyToMany
	@JoinTable(
		name="detailpromotion"
		, joinColumns={
			@JoinColumn(name="idPromotion")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idBook")
			}
		)
	private List<Book> books;

	public Promotion() {
	}

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