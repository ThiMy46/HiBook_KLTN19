package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.RoleDTO;
import ute.hibook.service.impl.RoleServiceImpl;

@RestController
public class RoleController {

	@Autowired
	RoleServiceImpl roleSer;
	
	@GetMapping("/role")
	public String getAllRole() {
		
		List<RoleDTO> roles= roleSer.getAllRole();
		for (RoleDTO role : roles) {
			System.out.println(role.getNameRole());
		}
		return "<h1>Hello!!!</h1>";
	}
	
	@GetMapping("/role/{idRole}")
	public String getRoleById(@PathVariable int idRole) {
		
		RoleDTO role= roleSer.getRoleById(1);
		System.out.println(role.getNameRole());
		return "<h1>Hello!!!</h1>";
	}
	
	@GetMapping("/role/add")
	public String addRole() {
		
		RoleDTO role= new RoleDTO();
		role.setNameRole("STAFF1");
		roleSer.addRole(role);
		return "<h1>Hello!!!</h1>";
	}
	
	@GetMapping("/role/update")
	public String updateRole() {
		
		RoleDTO role= new RoleDTO();
		role.setIdRole(4);
		role.setNameRole("STAFFF");
		roleSer.updateRole(role);
		return "<h1>Hello!!!</h1>";
	}
}
