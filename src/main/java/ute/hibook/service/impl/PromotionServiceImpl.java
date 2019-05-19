package ute.hibook.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.PromotionDaoImpl;
import ute.hibook.dto.PromotionDTO;
import ute.hibook.entity.Promotion;
import ute.hibook.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	PromotionDaoImpl promotionDao;
	
	public void addPromotion(PromotionDTO promotionDTO) {
		
		Promotion promotion= new Promotion();
		promotion.setContentPromotion(promotionDTO.getContentPromotion());
		promotion.setPicPromotion(promotionDTO.getPicPromotion());
		promotion.setSaleOff(promotionDTO.getSaleOff());
		promotion.setTimeEnd(promotionDTO.getTimeEnd());
		promotion.setTimeStart(promotionDTO.getTimeStart());
		promotion.setTitlePromotion(promotionDTO.getTitlePromotion());
		
		promotionDao.addPromotion(promotion);		
		System.out.println("add Promotion successful!");
	}

	public void updatePromotion(PromotionDTO promotionDTO) {
		Promotion promotion= promotionDao.getPromotionById(promotionDTO.getIdPromotion());
		if(promotion!=null) {
			promotion.setContentPromotion(promotionDTO.getContentPromotion());
			promotion.setPicPromotion(promotionDTO.getPicPromotion());
			promotion.setSaleOff(promotionDTO.getSaleOff());
			promotion.setTimeEnd(promotionDTO.getTimeEnd());
			promotion.setTimeStart(promotionDTO.getTimeStart());
			promotion.setTitlePromotion(promotionDTO.getTitlePromotion());
			
			promotionDao.updatePromotion(promotion);
			System.out.println("update Promotion successful!");
		}
	}

	public void deletePromotion(int idPromotion) {
		Promotion promotion= promotionDao.getPromotionById(idPromotion);
		if(promotion!=null) {
			promotionDao.deletePromotion(idPromotion);
			System.out.println("delete Promotion successful!");
		}
	}

	public PromotionDTO getPromotionById(int idPromotion) {
		Promotion promotion= promotionDao.getPromotionById(idPromotion);
		
		PromotionDTO promotionDTO= new PromotionDTO();
		promotionDTO.setIdPromotion(promotion.getIdPromotion());
		promotionDTO.setContentPromotion(promotion.getContentPromotion());
		promotionDTO.setPicPromotion(promotion.getPicPromotion());
		promotionDTO.setSaleOff(promotion.getSaleOff());
		promotionDTO.setTimeEnd(promotion.getTimeEnd());
		promotionDTO.setTimeStart(promotion.getTimeStart());
		promotionDTO.setTitlePromotion(promotion.getTitlePromotion());
		//System.out.println(promotion.getBooks().get(0).getNameBook());
		
		return promotionDTO;
	}

	public List<PromotionDTO> getAllPromotion() {
		List<Promotion> lstPromotion= promotionDao.getAllPromotion();
		
		List<PromotionDTO> lstPromotionDTO= new ArrayList<PromotionDTO>();
		for (Promotion promotion : lstPromotion) {
			
			PromotionDTO promotionDTO= new PromotionDTO();
			promotionDTO.setIdPromotion(promotion.getIdPromotion());
			promotionDTO.setContentPromotion(promotion.getContentPromotion());
			promotionDTO.setPicPromotion(promotion.getPicPromotion());
			promotionDTO.setSaleOff(promotion.getSaleOff());
			promotionDTO.setTimeEnd(promotion.getTimeEnd());
			promotionDTO.setTimeStart(promotion.getTimeStart());
			promotionDTO.setTitlePromotion(promotion.getTitlePromotion());
		
			lstPromotionDTO.add(promotionDTO);
		}
		return lstPromotionDTO;
	}

	public List<PromotionDTO> getAllPromotiondate() {
		List<Promotion> lstPromotionDate= promotionDao.getAllPromotionDate();
		
		List<PromotionDTO> lstPromotionDTOdate= new ArrayList<PromotionDTO>();
		for (Promotion promotion : lstPromotionDate) {
			
			PromotionDTO promotionDTO= new PromotionDTO();
			promotionDTO.setIdPromotion(promotion.getIdPromotion());
			promotionDTO.setContentPromotion(promotion.getContentPromotion());
			promotionDTO.setPicPromotion(promotion.getPicPromotion());
			promotionDTO.setSaleOff(promotion.getSaleOff());
			promotionDTO.setTimeEnd(promotion.getTimeEnd());
			promotionDTO.setTimeStart(promotion.getTimeStart());
			promotionDTO.setTitlePromotion(promotion.getTitlePromotion());
		
			lstPromotionDTOdate.add(promotionDTO);
		}
		return lstPromotionDTOdate;
	}

	

}
