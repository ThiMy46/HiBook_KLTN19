package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.DetailbillDaoImpl;
import ute.hibook.dto.DetailbillDTO;
import ute.hibook.entity.Detailbill;
import ute.hibook.service.DetailbillService;

@Service
public class DetailbillServiceImpl implements DetailbillService{

	@Autowired
	DetailbillDaoImpl detailbillDao;
	
	public void addDetailbill(DetailbillDTO detailbillDTO) {
		Detailbill detailbill= new Detailbill();
		detailbill.setPrice(detailbillDTO.getPrice());
		detailbill.setQuantityBuy(detailbillDTO.getQuantityBuy());
		detailbill.setBill(detailbillDTO.getBill());
		detailbill.setBook(detailbillDTO.getBook());
		
		detailbillDao.addDetailbill(detailbill);		
		System.out.println("add Detailbill successful!");
	}

	public void updateDetailbill(DetailbillDTO detailbillDTO) {
		Detailbill detailbill= detailbillDao.getDetailbillById(detailbillDTO.getIdDetailBill());
		if(detailbill!=null) {
			detailbill.setPrice(detailbillDTO.getPrice());
			detailbill.setQuantityBuy(detailbillDTO.getQuantityBuy());
			detailbill.setBill(detailbillDTO.getBill());
			detailbill.setBook(detailbillDTO.getBook());
			
			detailbillDao.updateDetailbill(detailbill);
			System.out.println("update Detailbill successful!");
		}
	}

	public void deleteDetailbill(int idDetailbill) {
		Detailbill detailbill= detailbillDao.getDetailbillById(idDetailbill);
		if(detailbill!=null) {
			detailbillDao.deleteDetailbill(idDetailbill);
			System.out.println("delete Detailbill successful!");
		}
	}

	public DetailbillDTO getDetailbillById(int idDetailbill) {
		Detailbill detailbill= detailbillDao.getDetailbillById(idDetailbill);
		
		DetailbillDTO detailbillDTO= new DetailbillDTO();
		detailbillDTO.setIdDetailBill(detailbill.getIdDetailBill());
		detailbillDTO.setPrice(detailbill.getPrice());
		detailbillDTO.setQuantityBuy(detailbill.getQuantityBuy());
		detailbillDTO.setBill(detailbill.getBill());
		detailbillDTO.setBook(detailbill.getBook());
		
		//System.out.println(Detailbill.getUsers().get(0).getEmail());
		
		return detailbillDTO;
	}

	public List<DetailbillDTO> getAllDetailbill() {
		List<Detailbill> lstDetailbill= detailbillDao.getAllDetailbill();
		
		List<DetailbillDTO> lstDetailbillDTO= new ArrayList<DetailbillDTO>();
		for (Detailbill detailbill : lstDetailbill) {
			
			DetailbillDTO detailbillDTO= new DetailbillDTO();
			detailbillDTO.setIdDetailBill(detailbill.getIdDetailBill());
			detailbillDTO.setPrice(detailbill.getPrice());
			detailbillDTO.setQuantityBuy(detailbill.getQuantityBuy());
			detailbillDTO.setBill(detailbill.getBill());
			detailbillDTO.setBook(detailbill.getBook());
		
			lstDetailbillDTO.add(detailbillDTO);
		}
		return lstDetailbillDTO;
	}

}
