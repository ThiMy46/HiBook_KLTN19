package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.RoleDTO;
import ute.hibook.service.impl.RoleServiceImpl;
@RestController
@RequestMapping(value = "/api")
public class RoleAPICon {
	@Autowired
	RoleServiceImpl roleServiceImpl;
	@GetMapping(value="/getallroles")
	public ResponseEntity<List<RoleDTO>> getallRole(){
		ArrayList<RoleDTO> arrayListRole=(ArrayList<RoleDTO>) roleServiceImpl.getAllRole();
		
		if(arrayListRole.isEmpty()) {
			return new ResponseEntity<List<RoleDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<RoleDTO>>(arrayListRole,HttpStatus.OK);
	}

}
