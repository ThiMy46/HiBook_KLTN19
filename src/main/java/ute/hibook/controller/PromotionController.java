package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.ConvertPromotionDTO;
import ute.hibook.dto.PromotionDTO;
import ute.hibook.service.impl.PromotionServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class PromotionController {
	@Autowired
	PromotionServiceImpl promotionServiceImpl;

	@GetMapping(value = "/promotionDate")
	public ResponseEntity<List<PromotionDTO>> getallPromotionDate() {

		List<PromotionDTO> lPromotionDTOs = promotionServiceImpl.getAllPromotiondate();

		if (lPromotionDTOs.isEmpty()) {
			return new ResponseEntity<List<PromotionDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PromotionDTO>>(lPromotionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/promotions")
	public ResponseEntity<List<ConvertPromotionDTO>> getallPromotion() {
		List<ConvertPromotionDTO> promotionDTOs = promotionServiceImpl.getAllPromotion();
		if (promotionDTOs.isEmpty()) {
			return new ResponseEntity<List<ConvertPromotionDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ConvertPromotionDTO>>(promotionDTOs, HttpStatus.OK);
	}
	@GetMapping(value = "/promotions/{idPromotion}")
	public ResponseEntity<ConvertPromotionDTO> getPromotionbyID(@PathVariable int idPromotion) {
		ConvertPromotionDTO promotionDTOs = promotionServiceImpl.getPromotionById(idPromotion);
		if (promotionDTOs==null) {
			return new ResponseEntity<ConvertPromotionDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ConvertPromotionDTO>(promotionDTOs, HttpStatus.OK);
	}
	/*======================DELETE book by ID================= */
	@DeleteMapping(value="/promotions/{idPromotion}")
	public ResponseEntity<?> deleteBook(@PathVariable int idPromotion){
		promotionServiceImpl.deletePromotion(idPromotion);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
