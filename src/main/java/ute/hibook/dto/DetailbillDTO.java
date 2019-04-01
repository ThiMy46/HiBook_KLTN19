package ute.hibook.dto;

import ute.hibook.entity.Bill;
import ute.hibook.entity.Book;

public class DetailbillDTO {

	private int idDetailBill;
	private int price;
	private int quantityBuy;
	private Bill bill;
	private Book book;

	public int getIdDetailBill() {
		return this.idDetailBill;
	}

	public void setIdDetailBill(int idDetailBill) {
		this.idDetailBill = idDetailBill;
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
