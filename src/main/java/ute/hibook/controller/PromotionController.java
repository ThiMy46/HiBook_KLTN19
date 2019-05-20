package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<PromotionDTO>> getallPromotion() {
		List<PromotionDTO> promotionDTOs = promotionServiceImpl.getAllPromotion();
		if (promotionDTOs.isEmpty()) {
			return new ResponseEntity<List<PromotionDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PromotionDTO>>(promotionDTOs, HttpStatus.OK);
	}

}
