package ute.hibook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.AuthorDaoImpl;
import ute.hibook.dto.AuthorDTO;
import ute.hibook.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorDaoImpl authorDao;

	public void addAuthor(AuthorDTO authorDTO) {
		// TODO Auto-generated method stub
		
	}

	public void updateAuthor(AuthorDTO authorDTO) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAuthor(int idAuthor) {
		// TODO Auto-generated method stub
		
	}

	public AuthorDTO getAuthorById(int idAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AuthorDTO> getAllAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
