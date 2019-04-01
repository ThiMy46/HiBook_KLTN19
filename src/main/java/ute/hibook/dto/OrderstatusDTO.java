package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Bill;

public class OrderstatusDTO {

	private int idStatus;
	private String nameStatus;
	private List<Bill> bills;

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return this.nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
}
