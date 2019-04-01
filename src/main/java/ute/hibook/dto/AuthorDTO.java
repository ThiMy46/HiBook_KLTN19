package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Book;

public class AuthorDTO {

	private int idAuthor;
	private String nameAuthor;
	private List<Book> books;

	public int getIdAuthor() {
		return this.idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getNameAuthor() {
		return this.nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
