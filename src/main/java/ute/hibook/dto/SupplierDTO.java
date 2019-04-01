package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Book;

public class SupplierDTO {

	private int idSupplier;
	private String nameSupplier;
	private List<Book> books;

	public int getIdSupplier() {
		return this.idSupplier;
	}

	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getNameSupplier() {
		return this.nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
