package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.UserDTO;
import ute.hibook.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

	@Autowired
	UserServiceImpl userSer;
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserDTO>> loaduseradmin() {
		List<UserDTO> listUserDTO=userSer.getAllUser();
		if(listUserDTO.isEmpty()) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserDTO>>(listUserDTO, HttpStatus.OK);
		
	}
	/*======================GET user by IDUser================= */
	@GetMapping(value = "/users/{idUser}")
	public ResponseEntity<UserDTO> getUser(@PathVariable int idUser) {
		UserDTO userDTO=userSer.getUserById(idUser);
		
		if(userDTO == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		
	}
	/*======================ADD user================= */
//	@PostMapping(value="/users")
//	public ResponseEntity<?> addUser(@RequestParam String nameUser, @RequestParam String numberphone,
//			@RequestParam String email, @RequestParam String password, @RequestParam int role, 
//			@RequestParam int sex, @RequestParam String birthday, @RequestParam String address){
//		User user=new User(nameUser, numberphone, email, BCrypt.hashpw(password,BCrypt.gensalt(12)), sex, birthday, address);
//		
//		Role role1 =new Role();
//		role1.setIdRole(role);
//		user.setRole(role1);
//		int idAdd=userSer.addUser(user);
//		if(idAdd==0){
//			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Integer>(idAdd, HttpStatus.OK);
//	}
	
	@PostMapping(value="/users/{idUser}")
	public ResponseEntity<?> updatePass(@PathVariable int idUser, @RequestParam String old, @RequestParam String passnew){
		UserDTO userDTO=userSer.getUserById(idUser);
		if(BCrypt.checkpw(old, userDTO.getPassword())){
			userDTO.setPassword(BCrypt.hashpw(passnew,BCrypt.gensalt(12)).toString());
			System.out.println(userDTO.getPassword());
			userSer.updateUser(userDTO);
			return new ResponseEntity<Integer>(1, HttpStatus.OK);//update
		}else{
			return new ResponseEntity<Integer>(-1, HttpStatus.OK);//pass old wrong
		}
		
	}
	
	/*======================Update Role by idUser================= */
//	@PutMapping(value="/user/{idUser}/role/{idRole}")
//	public ResponseEntity<?> updateRoleUser(@PathVariable int idUser, @PathVariable int idRole){
//		boolean up=userSer.updateRoleUser(idUser, idRole);
//		if(!up){
//			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//	}
	
	/*======================Update User================= */
	@PutMapping(value="/users/{idUser}")
	public ResponseEntity<?> updateUser(@PathVariable int idUser, @RequestBody UserDTO userDTO){
		System.out.println(idUser);
		userDTO.setIdUser(idUser);
		userSer.updateUser(userDTO);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	/*======================DELETE user by ID================= */
//	@DeleteMapping(value="/users/{idUser}")
//	public ResponseEntity<?> deleteAuthor(@PathVariable int idUser){
//		/*======================================ADMIN========== */
//		boolean delete=userSer.deleteUser(idUser);
//		if(!delete){
//			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//	}
}
