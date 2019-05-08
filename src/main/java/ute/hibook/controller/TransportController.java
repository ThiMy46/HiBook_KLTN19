package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.TransportDTO;
import ute.hibook.service.impl.TransportServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class TransportController {
	
	@Autowired
	TransportServiceImpl transportSer;
	
	@GetMapping(value="/transports")
	public ResponseEntity<List<TransportDTO>> getAllTransport(){
		
		List<TransportDTO> transportDTOs= transportSer.getAllTransport();
		
		if(transportDTOs.isEmpty()) {
			return new ResponseEntity<List<TransportDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<TransportDTO>>(transportDTOs,HttpStatus.OK);
	}

}
