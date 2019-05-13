package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.BookUpdateDTO;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
import ute.hibook.entity.Supplier;
import ute.hibook.entity.Typebook;
import ute.hibook.service.impl.BookServiceImpl;
@RestController
@RequestMapping(value = "/api/v1")
public class BookController {
	
	@Autowired
	BookServiceImpl bookSer;
	
	@GetMapping(value="/books")
	public ResponseEntity<List<BookDTO>> getAllBook(){
		ArrayList<BookDTO> arrayListBook=(ArrayList<BookDTO>) bookSer.getAllBook();
		
		if(arrayListBook.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BookDTO>>(arrayListBook,HttpStatus.OK);
	}
	
	@GetMapping(value="/books/{idBook}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable int idBook){
		BookDTO book=bookSer.getBookById(idBook);
		
		if(null == book) {
			return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<BookDTO>(book,HttpStatus.OK);
	}
	
	/*======================ADD Book================= */
	@PostMapping(value="/books")
	public ResponseEntity<?> addBook(@RequestParam String publisher,@RequestParam String nameBook, @RequestParam int price, @RequestParam int discount, 
			@RequestParam String size, @RequestParam int numberPage, @RequestParam String publicationDate,
			@RequestParam int quantity, @RequestParam String cover, @RequestParam String intro, @RequestParam String fileimg,
			@RequestParam String fileproofread, @RequestParam int idType, @RequestParam int idSupplier, @RequestParam(value="arr_author[]") List<Integer> arr_author){
	
		Book book=new Book();
		book.setNameBook(nameBook);
		book.setCover(cover);
		book.setPublisher(publisher);
		book.setSize(size);
		book.setNumberPage(numberPage);
		book.setPublicationDate(publicationDate);
		book.setQuantity(quantity);
		book.setIntroBook(intro);
		book.setDiscount(discount);
		book.setPrice(price);
		book.setPicBook(fileimg);
		book.setProofread(fileproofread);
		//set status 0: new add, haven't bill
		book.setStatus(0);
		//list tag using search
		//book.setTagList(bookDTO.getTagList());
		
		Typebook type = new Typebook();
		type.setIdType(idType);
		book.setTypebook(type);
		
		Supplier supplier = new Supplier();
		supplier.setIdSupplier(idSupplier);
		book.setSupplier(supplier);
		
		List<Author> authors=new ArrayList<Author>();
		for (int author : arr_author) {
			Author auth = new Author();
			auth.setIdAuthor(author);
			authors.add(auth);
		}
		book.setAuthors(authors);
		
		bookSer.addBook(book);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Book================= */
	@PutMapping(value="/books/{idBook}")
	public ResponseEntity<?> updateBook(@PathVariable int idBook, @RequestBody BookUpdateDTO bookdto){
	
		bookdto.setIdBook(idBook);
		
		bookSer.updateBook(bookdto);
		return new ResponseEntity<Integer>(idBook, HttpStatus.OK);
	}
	/*======================DELETE book by ID================= */
	@DeleteMapping(value="/books/{idBook}")
	public ResponseEntity<?> deleteBook(@PathVariable int idBook){
		bookSer.deleteBook(idBook);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
