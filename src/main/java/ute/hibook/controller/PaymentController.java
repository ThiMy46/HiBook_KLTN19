package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.PaymentDTO;
import ute.hibook.service.impl.PaymentServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentController {

	@Autowired
	PaymentServiceImpl paymentSer;
	
	@GetMapping(value="/payments")
	public ResponseEntity<List<PaymentDTO>> getAllPayment(){
		
		List<PaymentDTO> paymentDTOs= paymentSer.getAllPayment();
		
		if(paymentDTOs.isEmpty()) {
			return new ResponseEntity<List<PaymentDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<PaymentDTO>>(paymentDTOs,HttpStatus.OK);
	}
}
