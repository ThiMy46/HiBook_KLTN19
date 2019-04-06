package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.UserreviewDaoImpl;
import ute.hibook.dto.UserreviewDTO;
import ute.hibook.entity.Userreview;
import ute.hibook.service.UserreviewService;

@Service
public class UserreviewServiceImpl implements UserreviewService{

	@Autowired
	UserreviewDaoImpl userreviewDao;
	
	public void addUserreview(UserreviewDTO userreviewDTO) {
		Userreview userreview= new Userreview();
		userreview.setContent(userreviewDTO.getContent());
		userreview.setReportNum(userreviewDTO.getReportNum());
		userreview.setStar(userreviewDTO.getStar());
		userreview.setTimeReview(userreviewDTO.getTimeReview());
		userreview.setTitle(userreviewDTO.getTitle());
		userreview.setBook(userreviewDTO.getBook());
		userreview.setUser(userreviewDTO.getUser());
		
		userreviewDao.addUserreview(userreview);		
		System.out.println("add Userreview successful!");
	}

	public void updateUserreview(UserreviewDTO userreviewDTO) {
		Userreview userreview= userreviewDao.getUserreviewById(userreviewDTO.getIdReview());
		if(userreview!=null) {
			userreview.setContent(userreviewDTO.getContent());
			userreview.setReportNum(userreviewDTO.getReportNum());
			userreview.setStar(userreviewDTO.getStar());
			userreview.setTimeReview(userreviewDTO.getTimeReview());
			userreview.setTitle(userreviewDTO.getTitle());
			userreview.setBook(userreviewDTO.getBook());
			userreview.setUser(userreviewDTO.getUser());
			
			userreviewDao.updateUserreview(userreview);
			System.out.println("update Userreview successful!");
		}
	}

	public void deleteUserreview(int idUserreview) {
		Userreview userreview= userreviewDao.getUserreviewById(idUserreview);
		if(userreview!=null) {
			userreviewDao.deleteUserreview(idUserreview);
			System.out.println("delete Userreview successful!");
		}
	}

	public UserreviewDTO getUserreviewById(int idUserreview) {
		Userreview userreview= userreviewDao.getUserreviewById(idUserreview);
		
		UserreviewDTO userreviewDTO= new UserreviewDTO();
		userreviewDTO.setIdReview(userreview.getIdReview());
		userreviewDTO.setContent(userreview.getContent());
		userreviewDTO.setReportNum(userreview.getReportNum());
		userreviewDTO.setStar(userreview.getStar());
		userreviewDTO.setTimeReview(userreview.getTimeReview());
		userreviewDTO.setTitle(userreview.getTitle());
		userreviewDTO.setBook(userreview.getBook());
		userreviewDTO.setUser(userreview.getUser());
		
		return userreviewDTO;
	}

	public List<UserreviewDTO> getAllUserreview() {
		List<Userreview> lstUserreview= userreviewDao.getAllUserreview();
		
		List<UserreviewDTO> lstUserreviewDTO= new ArrayList<UserreviewDTO>();
		for (Userreview userreview : lstUserreview) {
			
			UserreviewDTO userreviewDTO= new UserreviewDTO();
			userreviewDTO.setIdReview(userreview.getIdReview());
			userreviewDTO.setContent(userreview.getContent());
			userreviewDTO.setReportNum(userreview.getReportNum());
			userreviewDTO.setStar(userreview.getStar());
			userreviewDTO.setTimeReview(userreview.getTimeReview());
			userreviewDTO.setTitle(userreview.getTitle());
			userreviewDTO.setBook(userreview.getBook());
			userreviewDTO.setUser(userreview.getUser());
		
			lstUserreviewDTO.add(userreviewDTO);
		}
		return lstUserreviewDTO;
	}

}
