package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.CartDTO;
import ute.hibook.service.impl.CartServiceImpl;
@RestController
@RequestMapping(value = "/api")
public class CartAPICon {
	@Autowired
	CartServiceImpl cartServiceImpl;
	@GetMapping(value="/getallcarts")
	public ResponseEntity<List<CartDTO>> getallCart(){
		ArrayList<CartDTO> arrayListCart=(ArrayList<CartDTO>) cartServiceImpl.getAllCart();
		
		if(arrayListCart.isEmpty()) {
			return new ResponseEntity<List<CartDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<CartDTO>>(arrayListCart,HttpStatus.OK);
	}

}
