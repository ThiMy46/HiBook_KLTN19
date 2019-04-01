package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Author;
import ute.hibook.entity.Cart;
import ute.hibook.entity.Detailbill;
import ute.hibook.entity.Promotion;
import ute.hibook.entity.Supplier;
import ute.hibook.entity.Typebook;
import ute.hibook.entity.Userreview;

public class BookDTO {

	private int idBook;
	private String cover;
	private int discount;
	private String introBook;
	private String nameBook;
	private int numberPage;
	private String picBook;
	private int price;
	private String proofread;
	private String publicationDate;
	private String publisher;
	private int quantity;
	private String size;
	private int status;
	private String tagList;
	private List<Author> authors;
	private Supplier supplier;
	private Typebook typebook;
	private List<Cart> carts;
	private List<Detailbill> detailbills;
	private List<Promotion> promotions;
	private List<Userreview> userreviews;

	public int getIdBook() {
		return this.idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getIntroBook() {
		return this.introBook;
	}

	public void setIntroBook(String introBook) {
		this.introBook = introBook;
	}

	public String getNameBook() {
		return this.nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public int getNumberPage() {
		return this.numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public String getPicBook() {
		return this.picBook;
	}

	public void setPicBook(String picBook) {
		this.picBook = picBook;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProofread() {
		return this.proofread;
	}

	public void setProofread(String proofread) {
		this.proofread = proofread;
	}

	public String getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTagList() {
		return this.tagList;
	}

	public void setTagList(String tagList) {
		this.tagList = tagList;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Typebook getTypebook() {
		return this.typebook;
	}

	public void setTypebook(Typebook typebook) {
		this.typebook = typebook;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<Detailbill> getDetailbills() {
		return this.detailbills;
	}

	public void setDetailbills(List<Detailbill> detailbills) {
		this.detailbills = detailbills;
	}

	public List<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public List<Userreview> getUserreviews() {
		return this.userreviews;
	}

	public void setUserreviews(List<Userreview> userreviews) {
		this.userreviews = userreviews;
	}

}
