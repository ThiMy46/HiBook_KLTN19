package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.AuthorDTO;
import ute.hibook.service.impl.AuthorServiceImpl;

@RestController
public class AuthorController {

	@Autowired
	AuthorServiceImpl authorSer;
	
	@GetMapping("/authors")
	public String getAllAuthor() {
		
		List<AuthorDTO> authors= authorSer.getAllAuthor();
		for (AuthorDTO author : authors) {
			System.out.println(author.getNameAuthor());
		}
		return "<h1>Hello!!!</h1>";
	}
	
	@GetMapping("/authors/{idAuthor}")
	public String getAuthorById(@PathVariable int idAuthor) {
		
		AuthorDTO author= authorSer.getAuthorById(idAuthor);
		
		System.out.println(author.getNameAuthor());
		return "<h1>Hello!!!</h1>";
	}
}
