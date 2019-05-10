package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.UserreviewDTO;
import ute.hibook.service.impl.UserreviewServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class UserReviewController {

	@Autowired
	UserreviewServiceImpl userReviewSer;
//	Load userreview admin
	@GetMapping(value = "/reviews")
	public ResponseEntity<List<UserreviewDTO>> loadUserReview(){
		List<UserreviewDTO> listReview=userReviewSer.getAllUserreview();
		
		if(listReview.isEmpty()) {
			return new ResponseEntity<List<UserreviewDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<UserreviewDTO>>(listReview,HttpStatus.OK);
		
	}
	/*======================DELETE Review by ID================= */
	@DeleteMapping(value="/reviews/{idReview}")
	public ResponseEntity<?> deleteReview(@PathVariable int idReview){
		System.out.println(idReview);
		userReviewSer.deleteUserreview(idReview);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
