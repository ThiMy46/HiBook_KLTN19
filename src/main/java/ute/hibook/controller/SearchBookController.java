package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.SearchDTO;
import ute.hibook.service.impl.SpecialServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class SearchBookController {

	@Autowired
	SpecialServiceImpl specialSer;
	
	@GetMapping("/booklimit-author")
	public ResponseEntity<List<SearchDTO>> getInforDifferent() {
		List<SearchDTO> searchs =new ArrayList<SearchDTO>();
		if(searchs.isEmpty()) {
			return new ResponseEntity<List<SearchDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<SearchDTO>>(searchs,HttpStatus.OK);
	}
	
}
