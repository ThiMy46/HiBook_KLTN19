package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Bill;

public class TransportDTO {

	private int idTransport;
	private String describes;
	private int fee;
	private String nameTransport;
	private List<Bill> bills;

	public int getIdTransport() {
		return this.idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	public String getDescribes() {
		return this.describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public int getFee() {
		return this.fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getNameTransport() {
		return this.nameTransport;
	}

	public void setNameTransport(String nameTransport) {
		this.nameTransport = nameTransport;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
}
