package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.PublisherDTO;
import ute.hibook.dto.SearchDTO;
import ute.hibook.dto.SupplierDTO;
import ute.hibook.service.impl.BookServiceImpl;
import ute.hibook.service.impl.SearchBookServiceImpl;
import ute.hibook.service.impl.SpecialServiceImpl;

@Controller
public class Page1Controller {
	@Autowired
	SearchBookServiceImpl searchSer;
	@Autowired
	SpecialServiceImpl specialSer;
	@Autowired 
	BookServiceImpl bookSer;

	@GetMapping({"/search-author/{idAuthor}"})
	public String searchAuthor(@PathVariable int idAuthor, Model model) {
		List<BookDTO> books = searchSer.searchAuthor(idAuthor);
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
		}
		return "listbook";
	}
	@GetMapping({"/search-supplier/{idSupplier}"})
	public String searchSupplier(@PathVariable int idSupplier, Model model) {
		List<BookDTO> books = searchSer.searchSupplier(idSupplier);
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
		}
		return "listbook";
	}
	@GetMapping({"/search-type/{idType}"})
	public String searchType(@PathVariable int idType, Model model) {
		List<BookDTO> books = searchSer.searchType(idType);
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
		}
		return "listbook";
	}
	@GetMapping({"/search-key"})
	public String searchKey(@RequestParam(value = "q") String keyword, Model model) {
		List<BookDTO> books = searchSer.searchIndex(keyword);
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
		}
		return "listbook";
	}
	
	@GetMapping({"/search-bestsells"})
	public String searchBestsells(Model model) {
		List<BookDTO> books = specialSer.getBestSellBooksLimit(0, 9);
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
		}
		return "listbook";
	}
	
	@GetMapping({"/search-newbook"})
	public String searchBooklimit(Model model) {
		int offsets = 6;
		int limit = 6;//>=6
		
		List<BookDTO> bookall = specialSer.getNewBooksLimit(-1, 6);
		SearchDTO searchDTO = new SearchDTO();
		//currentpage
		if(offsets == -1) {
			searchDTO.setCurrentpage(1);
		}else {
			searchDTO.setCurrentpage(offsets/limit+1);
		}
		//total page
		if((bookall.size() % limit)==0) {
			searchDTO.setTotalpage(bookall.size()/limit);
		}else {
			searchDTO.setTotalpage(bookall.size()/limit + 1);
		}
		
		List<SupplierDTO> lstSupplier = new ArrayList<SupplierDTO>();
		List<PublisherDTO> lstPublisher = new ArrayList<PublisherDTO>();
		//
		List<AuthorDTO> lstAuthor = new ArrayList<AuthorDTO>();
		List<BookDTO> books = new ArrayList<BookDTO>();
		
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
			//book have author object
			BookDTO bookFull = bookSer.getBookById(bookDTO.getIdBook());
			//author
			flag = false;
			for (int i=0; i < lstAuthor.size(); i++) {
				for (int j=0; j < bookDTO.getAuthors().size(); j++) {
					if(lstAuthor.get(i).getIdAuthor() ==  bookDTO.getAuthors().get(j).getIdAuthor())
					{
						lstAuthor.get(i).setNumBookSearch(lstAuthor.get(i).getNumBookSearch()+1);
						flag = true;
					}else {
						bookDTO.getAuthors().get(j).setNumBookSearch(1);
						lstAuthor.add(bookDTO.getAuthors().get(j));
					}
				}
			}
			//list books - display 
			//6 <= 
			if(offsets <= t && books.size() < limit) {
				books.add(bookFull);
			}
			
		}
		searchDTO.setLstSupplier(lstSupplier);
		searchDTO.setLstPublisher(lstPublisher);
		
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
			model.addAttribute("search", searchDTO);
		}
		return "listbook";
	}
}
