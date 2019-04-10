package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.SpecialDao;
import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
@Service
public class SpecialServiceImpl {

	@Autowired
	SpecialDao specialDao;
	
	public List<BookDTO> getBookLimit(int begin, int num) {
		List<Book> lstBookLimit= specialDao.getBookLimit(begin, num);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstBookLimit) {
			BookDTO bookDTO=new BookDTO();
			
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			List<AuthorDTO> lstAuthor=new ArrayList<AuthorDTO>();
			for (Author author : book.getAuthors()) {
				AuthorDTO authorDTO=new AuthorDTO();
				authorDTO.setIdAuthor(author.getIdAuthor());
				authorDTO.setNameAuthor(author.getNameAuthor());
				lstAuthor.add(authorDTO);
			}
			bookDTO.setAuthors(lstAuthor);
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}
	
	public List<BookDTO> getBestSellBooks() {
		List<Book> lstBookBestSell= specialDao.getBestSellBooks();
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstBookBestSell) {
			
			BookDTO bookDTO=new BookDTO();
			
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}
	
	public List<BookDTO> searchBook(String key, String type) {
		List<Book> lstSearch= specialDao.searchNameBook(key, type);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstSearch) {
			BookDTO bookDTO=new BookDTO();
			
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
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}
}
