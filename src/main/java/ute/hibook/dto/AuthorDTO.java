package ute.hibook.dto;

import java.util.List;

public class AuthorDTO {

	private int idAuthor;
	private String nameAuthor;
	private List<BookDTO> books;

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

	public List<BookDTO> getBooks() {
		return this.books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
}
