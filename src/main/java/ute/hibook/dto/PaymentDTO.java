package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Bill;

public class PaymentDTO {
	
	private int idPayment;
	private String namePayment;
	private List<Bill> bills;
	
	public int getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public String getNamePayment() {
		return this.namePayment;
	}

	public void setNamePayment(String namePayment) {
		this.namePayment = namePayment;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
}
