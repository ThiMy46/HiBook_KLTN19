package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detailbill database table.
 * 
 */
@Entity(name="detailbill")
public class Detailbill implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetailbillPK id;

	private int price;

	private int quantityBuy;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="idBill")
	private Bill bill;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="idBook")
	private Book book;

	public Detailbill() {
	}

	public DetailbillPK getId() {
		return this.id;
	}

	public void setId(DetailbillPK id) {
		this.id = id;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityBuy() {
		return this.quantityBuy;
	}

	public void setQuantityBuy(int quantityBuy) {
		this.quantityBuy = quantityBuy;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}