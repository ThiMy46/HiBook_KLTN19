package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ute.hibook.dto.BookDTO;
import ute.hibook.service.impl.SearchBookServiceImpl;

@Controller
public class Page1Controller {
	@Autowired
	SearchBookServiceImpl searchSer;

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
}
