package ute.hibook.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import ute.hibook.entity.Book;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SpecialDao {

	@Autowired
	SessionFactory sessionFactory;

	/* GET Book limit num, begin from number location book*/
	@Transactional
	public List<Book> getBookLimit(int begin, int num) {
			Session session=sessionFactory.getCurrentSession();
			List<Book> lstBook=new ArrayList<Book>();
			lstBook=session.createQuery("from book").setFirstResult(begin).setMaxResults(num).getResultList();
			return lstBook;
	}
	
	/*Best selling books */
	@Transactional
	public List<Book> getBestSellBooks() {
			Session session=sessionFactory.getCurrentSession();
			ProcedureCall query= session.createStoredProcedureCall("getNumBooksSold",Book.class);
			ResultSetOutput resultSetOutput = (ResultSetOutput) query.getOutputs().getCurrent();
			List<Book> lstBook=resultSetOutput.getResultList();
			return lstBook;
	}
	
	/* Support search follow name book */
	@Transactional
	public List<Book> searchNameBook(String key, String type) {
		Session session=sessionFactory.getCurrentSession();
		Query search=null;
		if(type.equals("")){
			search= session.createQuery("from book where nameBook like :nameBook");
			search.setParameter("nameBook", "%"+key+"%");
		}else {
			search= session.createQuery("from book where nameBook like :nameBook and idType = :idType");
			search.setParameter("idType", type);
			search.setParameter("nameBook", "%"+key+"%");
		}
		try{
			List<Book> books=search.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}
}
