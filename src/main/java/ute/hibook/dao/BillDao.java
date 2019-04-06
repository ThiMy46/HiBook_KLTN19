package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Bill;

public interface BillDao {

	public void addBill(Bill bill);
	public void updateBill(Bill bill);
	public void deleteBill(int idBill);
	public Bill getBillById(int idBill);
	public List<Bill> getAllBill();
}
