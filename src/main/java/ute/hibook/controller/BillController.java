package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BillDTO;
import ute.hibook.service.impl.BillServiceImpl;
@RestController
@RequestMapping(value = "/api/v1")
public class BillController {
	@Autowired
	BillServiceImpl billSer;
	
	@GetMapping(value="/bills")
	public ResponseEntity<List<BillDTO>> getallBill(){
		List<BillDTO> bills= billSer.getAllBill();
		if(bills.isEmpty()) {
			return new ResponseEntity<List<BillDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BillDTO>>(bills,HttpStatus.OK);
	}
	
	@GetMapping(value="/bills/{idBill}")
	public ResponseEntity<BillDTO> getBillById(@PathVariable int idBill){
		BillDTO billDTO= billSer.getBillById(idBill);
		if(billDTO == null) {
			return new ResponseEntity<BillDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<BillDTO>(billDTO,HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{idUser}/bills")
	public ResponseEntity<?> getBillByIdUser(@PathVariable int idUser){
		List<BillDTO> bills= billSer.getBillsByIdUser(idUser);
		if(bills.isEmpty()) {
			return new ResponseEntity<List<BillDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BillDTO>>(bills,HttpStatus.OK);
	}
}
