package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.TypebookDTO;
import ute.hibook.service.impl.TypebookServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class TypeBookController {

	@Autowired
	TypebookServiceImpl typebookSer;
	
	@GetMapping(value="/typebooks")
	public ResponseEntity<List<TypebookDTO>> getAllTypeBook(){
		
		List<TypebookDTO> lstTypeBook= typebookSer.getAllTypebook();
		
		if(lstTypeBook.isEmpty()) {
			return new ResponseEntity<List<TypebookDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<TypebookDTO>>(lstTypeBook,HttpStatus.OK);
	}
}
