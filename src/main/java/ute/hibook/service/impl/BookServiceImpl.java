package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.BookDaoImpl;
import ute.hibook.dto.BookDTO;
import ute.hibook.entity.Book;
import ute.hibook.entity.Supplier;
import ute.hibook.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDaoImpl bookDao;
	
	public void addBook(BookDTO bookDTO) {
		Book book= new Book();
		book.setNameBook(bookDTO.getNameBook());
		book.setCover(bookDTO.getCover());
		book.setDiscount(bookDTO.getDiscount());
		book.setIntroBook(bookDTO.getIntroBook());
		book.setNumberPage(bookDTO.getNumberPage());
		book.setPicBook(bookDTO.getPicBook());
		book.setPrice(bookDTO.getPrice());
		book.setProofread(bookDTO.getProofread());
		book.setPublicationDate(bookDTO.getPublicationDate());
		book.setPublisher(bookDTO.getPublisher());
		book.setQuantity(bookDTO.getQuantity());
		book.setSize(bookDTO.getSize());
		book.setStatus(bookDTO.getStatus());
		book.setTagList(bookDTO.getTagList());
		
		/*
		 * Supplier supplier=new Supplier();
		 * supplier.setIdSupplier(bookDTO.getSupplier().getIdSupplier());
		 * supplier.setNameSupplier(bookDTO.getSupplier().getNameSupplier());
		 */
		/*
		 * book.setSupplier(bookDTO.getSupplier());
		 * book.setTypebook(bookDTO.getTypebook());
		 */
		
		bookDao.addBook(book);		
		System.out.println("add Book successful!");
	}

	public void updateBook(BookDTO bookDTO) {
		Book book= bookDao.getBookById(bookDTO.getIdBook());
		if(book!=null) {
			book.setNameBook(bookDTO.getNameBook());
			book.setCover(bookDTO.getCover());
			book.setDiscount(bookDTO.getDiscount());
			book.setIntroBook(bookDTO.getIntroBook());
			book.setNumberPage(bookDTO.getNumberPage());
			book.setPicBook(bookDTO.getPicBook());
			book.setPrice(bookDTO.getPrice());
			book.setProofread(bookDTO.getProofread());
			book.setPublicationDate(bookDTO.getPublicationDate());
			book.setPublisher(bookDTO.getPublisher());
			book.setQuantity(bookDTO.getQuantity());
			book.setSize(bookDTO.getSize());
			book.setStatus(bookDTO.getStatus());
			book.setTagList(bookDTO.getTagList());
			/*
			 * book.setSupplier(bookDTO.getSupplier());
			 * book.setTypebook(bookDTO.getTypebook());
			 */
			
			bookDao.updateBook(book);
			System.out.println("update Book successful!");
		}
	}

	public void deleteBook(int idBook) {
		Book book= bookDao.getBookById(idBook);
		if(book!=null) {
			bookDao.deleteBook(idBook);
			System.out.println("delete Book successful!");
		}
	}

	public BookDTO getBookById(int idBook) {
		Book book= bookDao.getBookById(idBook);
		
		BookDTO bookDTO= new BookDTO();
		bookDTO.setIdBook(book.getIdBook());
		bookDTO.setNameBook(book.getNameBook());
		bookDTO.setCover(book.getCover());
		bookDTO.setDiscount(book.getDiscount());
		bookDTO.setIntroBook(book.getIntroBook());
		bookDTO.setNumberPage(book.getNumberPage());
		bookDTO.setPicBook(book.getPicBook());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setProofread(book.getProofread());
		bookDTO.setPublicationDate(book.getPublicationDate());
		bookDTO.setPublisher(book.getPublisher());
		bookDTO.setQuantity(book.getQuantity());
		bookDTO.setSize(book.getSize());
		bookDTO.setStatus(book.getStatus());
		bookDTO.setTagList(book.getTagList());
		/*
		 * bookDTO.setSupplier(book.getSupplier());
		 * bookDTO.setTypebook(book.getTypebook());
		 */
		//System.out.println(book.getAuthors().get(0).getNameAuthor());
		
		return bookDTO;
	}

	public List<BookDTO> getAllBook() {
		List<Book> lstBook= bookDao.getAllBook();
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstBook) {
			
			BookDTO bookDTO= new BookDTO();
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setCover(book.getCover());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setIntroBook(book.getIntroBook());
			bookDTO.setNumberPage(book.getNumberPage());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublicationDate(book.getPublicationDate());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setSize(book.getSize());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			/*
			 * bookDTO.setSupplier(book.getSupplier());
			 * bookDTO.setTypebook(book.getTypebook());
			 */
		
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

}
