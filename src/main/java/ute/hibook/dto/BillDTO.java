package ute.hibook.dto;

import java.util.List;

import ute.hibook.entity.Detailbill;
import ute.hibook.entity.Orderstatus;
import ute.hibook.entity.Payment;
import ute.hibook.entity.Transport;
import ute.hibook.entity.User;

public class BillDTO {

	private int idBill;
	private String dateCreate;
	private String deliveryAdress;
	private String nameReceiver;
	private String numberphone;
	private int total;
	private Payment payment;
	private Orderstatus orderstatus;
	private Transport transport;
	private User user;
	private List<Detailbill> detailbills;

	public int getIdBill() {
		return this.idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public String getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDeliveryAdress() {
		return this.deliveryAdress;
	}

	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}

	public String getNameReceiver() {
		return this.nameReceiver;
	}

	public void setNameReceiver(String nameReceiver) {
		this.nameReceiver = nameReceiver;
	}

	public String getNumberphone() {
		return this.numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Orderstatus getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(Orderstatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Detailbill> getDetailbills() {
		return this.detailbills;
	}

	public void setDetailbills(List<Detailbill> detailbills) {
		this.detailbills = detailbills;
	}

	
}
