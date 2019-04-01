package ute.hibook.dto;

import ute.hibook.entity.Book;
import ute.hibook.entity.User;

public class CartDTO {

	private int idCart;
	private int price;
	private int quantity;
	private Book book;
	private User user;
	public int getIdCart() {
		return this.idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
