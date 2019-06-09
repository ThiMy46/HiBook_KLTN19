package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.SearchDTO;
import ute.hibook.service.impl.SearchBookServiceImpl;
import ute.hibook.service.impl.SpecialServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class SearchBookController {

	@Autowired
	SpecialServiceImpl specialSer;
	@Autowired
	SearchBookServiceImpl searchSer;
	
	@GetMapping("/booklimit-author")
	public ResponseEntity<List<SearchDTO>> getInforDifferent() {
		List<SearchDTO> searchs =new ArrayList<SearchDTO>();
		if(searchs.isEmpty()) {
			return new ResponseEntity<List<SearchDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<SearchDTO>>(searchs,HttpStatus.OK);
	}
	
	@GetMapping({"/search_newbooks"})
	public ResponseEntity<List<BookDTO>> searchBookPage() {
		
		List<BookDTO> bookall = specialSer.getNewBooksLimit(-1, 6);
		
		if(bookall.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BookDTO>>(bookall, HttpStatus.OK);
	}
	
	@GetMapping("/searchs")
	public ResponseEntity<List<BookDTO>> searchBooksByTyppe(@RequestParam(value="type") String type) {
		List<BookDTO> lstNewBook= searchSer.searchType(Integer.parseInt(type), 0, 8);
		
		if(lstNewBook.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookDTO>>(lstNewBook,HttpStatus.OK);
	}
	
}
