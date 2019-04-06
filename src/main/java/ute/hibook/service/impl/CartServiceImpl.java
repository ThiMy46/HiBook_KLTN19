package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.CartDaoImpl;
import ute.hibook.dto.CartDTO;
import ute.hibook.entity.Cart;
import ute.hibook.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDaoImpl cartDao;
	
	public void addCart(CartDTO cartDTO) {
		Cart cart= new Cart();
		cart.setPrice(cartDTO.getPrice());
		cart.setQuantity(cartDTO.getQuantity());
		cart.setUser(cartDTO.getUser());
		cart.setBook(cartDTO.getBook());
		
		cartDao.addCart(cart);		
		System.out.println("add Cart successful!");
	}

	public void updateCart(CartDTO cartDTO) {
		Cart cart= cartDao.getCartById(cartDTO.getIdCart());
		if(cart!=null) {
			cart.setPrice(cartDTO.getPrice());
			cart.setQuantity(cartDTO.getQuantity());
			cart.setUser(cartDTO.getUser());
			cart.setBook(cartDTO.getBook());
			
			cartDao.updateCart(cart);
			System.out.println("update Cart successful!");
		}
	}

	public void deleteCart(int idCart) {
		Cart cart= cartDao.getCartById(idCart);
		if(cart!=null) {
			cartDao.deleteCart(idCart);
			System.out.println("delete Cart successful!");
		}
	}

	public CartDTO getCartById(int idCart) {
		Cart cart= cartDao.getCartById(idCart);
		
		CartDTO cartDTO= new CartDTO();
		cartDTO.setIdCart(cart.getIdCart());
		cartDTO.setPrice(cart.getPrice());
		cartDTO.setQuantity(cart.getQuantity());
		cartDTO.setUser(cart.getUser());
		cartDTO.setBook(cart.getBook());
		//System.out.println(cart.getUsers().get(0).getEmail());
		
		return cartDTO;
	}

	public List<CartDTO> getAllCart() {
		List<Cart> lstCart= cartDao.getAllCart();
		
		List<CartDTO> lstCartDTO= new ArrayList<CartDTO>();
		for (Cart cart : lstCart) {
			
			CartDTO cartDTO= new CartDTO();
			cartDTO.setIdCart(cart.getIdCart());
			cartDTO.setPrice(cart.getPrice());
			cartDTO.setQuantity(cart.getQuantity());
			cartDTO.setUser(cart.getUser());
			cartDTO.setBook(cart.getBook());
		
			lstCartDTO.add(cartDTO);
		}
		return lstCartDTO;
	}

}
