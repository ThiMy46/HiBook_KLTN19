package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Bill;
import ute.hibook.entity.Cart;
import ute.hibook.entity.Role;
import ute.hibook.entity.Userreview;

public class UserDTO {

	private int idUser;
	private String address;
	private String birthday;
	private String email;
	private String nameUser;
	private String numberphone;
	private String password;
	private byte sex;
	private List<Bill> bills;
	private List<Cart> carts;
	private Role role;
	private List<Userreview> userreviews;

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNumberphone() {
		return this.numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getSex() {
		return this.sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Userreview> getUserreviews() {
		return this.userreviews;
	}

	public void setUserreviews(List<Userreview> userreviews) {
		this.userreviews = userreviews;
	}
}
