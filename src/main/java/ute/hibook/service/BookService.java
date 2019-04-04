package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.BookDTO;

public interface BookService {

	public void addBook(BookDTO bookDTO);
	public void updateBook(BookDTO bookDTO);
	public void deleteBook(int idBook);
	public BookDTO getBookById(int idBook);
	public List<BookDTO> getAllBook();
}
