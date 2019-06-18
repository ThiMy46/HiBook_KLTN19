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

import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.PublisherDTO;
import ute.hibook.dto.SearchDTO;
import ute.hibook.dto.SupplierDTO;
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
	
	@GetMapping({"/search-newbook"})
	public ResponseEntity<?> searchBookPage() {
		
		List<BookDTO> bookall = specialSer.getNewBooksLimit(-1, 6);
		SearchDTO searchDTO = paginationListBook(bookall, (1-1)*6, 6);
		
		if(bookall.isEmpty()) {
			return new ResponseEntity<SearchDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<SearchDTO>(searchDTO, HttpStatus.OK);
	}
	
	@GetMapping("/searchs")
	public ResponseEntity<List<BookDTO>> searchBooksByTyppe(@RequestParam(value="type") String type) {
		List<BookDTO> lstNewBook= searchSer.searchType(Integer.parseInt(type), 0, 8);
		
		if(lstNewBook.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookDTO>>(lstNewBook,HttpStatus.OK);
	}
	
	public SearchDTO paginationListBook(List<BookDTO> bookall, int offsets, int limit) {
		SearchDTO searchDTO = new SearchDTO();
		
		//total page
		if((bookall.size() % limit)==0) {
			searchDTO.setTotalpage(bookall.size()/limit);
		}else {
			searchDTO.setTotalpage(bookall.size()/limit + 1);
		}
		//get currentpage
		if(offsets == -1) {
			searchDTO.setCurrentpage(1);
			searchDTO.setPre(-1);
			searchDTO.setNext(1 < searchDTO.getTotalpage() ? 2 : -1);
			
		}else {
			int num_current = offsets/limit+1;
			searchDTO.setCurrentpage(num_current);
			
			searchDTO.setNext((num_current+1) <= searchDTO.getTotalpage() ? (num_current+1) : -1);
			searchDTO.setPre((num_current-1) == 0 ? -1 : (num_current-1));
		}
		
		List<SupplierDTO> lstSupplier = new ArrayList<SupplierDTO>();
		List<PublisherDTO> lstPublisher = new ArrayList<PublisherDTO>();
		//
		List<AuthorDTO> lstAuthor = new ArrayList<AuthorDTO>();
		for (int t=0; t<bookall.size(); t++) {
			BookDTO bookDTO = bookall.get(t);
			//Supplier
			boolean flag = false;
			for (int i=0; i < lstSupplier.size(); i++) {
				if(lstSupplier.get(i).getIdSupplier() == bookDTO.getSupplier().getIdSupplier())
				{
					lstSupplier.get(i).setNumBookSearch(lstSupplier.get(i).getNumBookSearch()+1);
					flag = true;
					break;
				}
			}
			if(flag == false) {
				bookDTO.getSupplier().setNumBookSearch(1);
				lstSupplier.add(bookDTO.getSupplier());
			}
			//publisher
			flag = false;
			for (int i=0; i < lstPublisher.size(); i++) {
				if(lstPublisher.get(i).getNamePublisher().equals(bookDTO.getPublisher()))
				{
					lstPublisher.get(i).setNumBookSearch(lstPublisher.get(i).getNumBookSearch()+1);
					flag = true;
					break;
				}
			}
			if(flag == false) {
				PublisherDTO publisher = new PublisherDTO(bookDTO.getPublisher(), 1);
				lstPublisher.add(publisher);
			}
			
			//author
			for (int j=0; j < bookDTO.getAuthors().size(); j++) {
				
				if(lstAuthor.size() == 0) {
					lstAuthor.add(bookDTO.getAuthors().get(j));
					lstAuthor.get(0).setNumBookSearch(1);
				}else {
					flag=false;
					for (int i=0; i < lstAuthor.size(); i++) {
						if(bookDTO.getAuthors().get(j).getIdAuthor() == lstAuthor.get(i).getIdAuthor())
						{
							lstAuthor.get(i).setNumBookSearch(lstAuthor.get(i).getNumBookSearch()+1);
							flag = true;
							break;
						}else {
							flag = false;
						}
					}
					if(flag == false) {
						lstAuthor.add(bookDTO.getAuthors().get(j));
						lstAuthor.get(lstAuthor.size()-1).setNumBookSearch(1);
					}
				}
			}
			
		}
		searchDTO.setLstAuthor(lstAuthor);
		searchDTO.setLstSupplier(lstSupplier);
		searchDTO.setLstPublisher(lstPublisher);
		searchDTO.setAllBooks(bookall);//// add 09-06-19 to using multi filter
		return searchDTO;
	}
	
}
