package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.BillDao;
import ute.hibook.entity.Bill;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class BillDaoImpl implements BillDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addBill(Bill bill) {
		sessionFactory.getCurrentSession().save(bill);
	}

	public void updateBill(Bill bill) {
		sessionFactory.getCurrentSession().update(bill);
	}

	public void deleteBill(int idBill) {
		sessionFactory.getCurrentSession().delete(getBillById(idBill));
	}

	public Bill getBillById(int idBill) {
		return sessionFactory.getCurrentSession().get(Bill.class, idBill);
	}

	public List<Bill> getAllBill() {
		return sessionFactory.getCurrentSession().createQuery("from bill").getResultList();
	}

}
