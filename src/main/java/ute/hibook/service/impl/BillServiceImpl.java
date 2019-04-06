package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.BillDaoImpl;
import ute.hibook.dto.BillDTO;
import ute.hibook.entity.Bill;
import ute.hibook.service.BillService;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillDaoImpl billDao;
	
	public void addBill(BillDTO billDTO) {
		Bill bill= new Bill();
		bill.setDateCreate(billDTO.getDateCreate());
		bill.setDeliveryAdress(billDTO.getDeliveryAdress());
		bill.setNameReceiver(billDTO.getNameReceiver());
		bill.setNumberphone(billDTO.getNumberphone());
		bill.setTotal(billDTO.getTotal());
		bill.setPayment(billDTO.getPayment());
		bill.setOrderstatus(billDTO.getOrderstatus());
		bill.setTransport(billDTO.getTransport());
		bill.setUser(billDTO.getUser());
		
		billDao.addBill(bill);		
		System.out.println("add Bill successful!");
	}

	public void updateBill(BillDTO billDTO) {
		Bill bill= billDao.getBillById(billDTO.getIdBill());
		if(bill!=null) {
			bill.setDateCreate(billDTO.getDateCreate());
			bill.setDeliveryAdress(billDTO.getDeliveryAdress());
			bill.setNameReceiver(billDTO.getNameReceiver());
			bill.setNumberphone(billDTO.getNumberphone());
			bill.setTotal(billDTO.getTotal());
			bill.setPayment(billDTO.getPayment());
			bill.setOrderstatus(billDTO.getOrderstatus());
			bill.setTransport(billDTO.getTransport());
			bill.setUser(billDTO.getUser());
			
			billDao.updateBill(bill);
			System.out.println("update Bill successful!");
		}
	}

	public void deleteBill(int idBill) {
		Bill bill= billDao.getBillById(idBill);
		if(bill!=null) {
			billDao.deleteBill(idBill);
			System.out.println("delete Bill successful!");
		}
	}

	public BillDTO getBillById(int idBill) {
		Bill bill= billDao.getBillById(idBill);
		
		BillDTO billDTO= new BillDTO();
		billDTO.setIdBill(bill.getIdBill());
		billDTO.setDateCreate(bill.getDateCreate());
		billDTO.setDeliveryAdress(bill.getDeliveryAdress());
		billDTO.setNameReceiver(bill.getNameReceiver());
		billDTO.setNumberphone(bill.getNumberphone());
		billDTO.setTotal(bill.getTotal());
		billDTO.setPayment(bill.getPayment());
		billDTO.setOrderstatus(bill.getOrderstatus());
		billDTO.setTransport(bill.getTransport());
		billDTO.setUser(bill.getUser());
		//System.out.println(bill.getDetailbills().get(0).getIdDetailBill());
		
		return billDTO;
	}

	public List<BillDTO> getAllBill() {
		List<Bill> lstBill= billDao.getAllBill();
		
		List<BillDTO> lstBillDTO= new ArrayList<BillDTO>();
		for (Bill bill : lstBill) {
			
			BillDTO billDTO= new BillDTO();
			billDTO.setIdBill(bill.getIdBill());
			billDTO.setDateCreate(bill.getDateCreate());
			billDTO.setDeliveryAdress(bill.getDeliveryAdress());
			billDTO.setNameReceiver(bill.getNameReceiver());
			billDTO.setNumberphone(bill.getNumberphone());
			billDTO.setTotal(bill.getTotal());
			billDTO.setPayment(bill.getPayment());
			billDTO.setOrderstatus(bill.getOrderstatus());
			billDTO.setTransport(bill.getTransport());
			billDTO.setUser(bill.getUser());
		
			lstBillDTO.add(billDTO);
		}
		return lstBillDTO;
	}

}
