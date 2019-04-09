package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BillDTO;
import ute.hibook.service.impl.BillServiceImpl;
@RestController
@RequestMapping(value = "/api")
public class BillAPICon {
	@Autowired
	BillServiceImpl billServiceImpl;
	@GetMapping(value="/getallbills")
	public ResponseEntity<List<BillDTO>> getallBill(){
		ArrayList<BillDTO> arrayListBill=(ArrayList<BillDTO>) billServiceImpl.getAllBill();
		
		if(arrayListBill.isEmpty()) {
			return new ResponseEntity<List<BillDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BillDTO>>(arrayListBill,HttpStatus.OK);
	}
}
