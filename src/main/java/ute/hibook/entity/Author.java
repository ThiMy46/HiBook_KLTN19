package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the author database table.
 * 
 */
@Entity(name="author")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAuthor;

	private String nameAuthor;

	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="authors")
	private List<Book> books;

	public Author() {
	}

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