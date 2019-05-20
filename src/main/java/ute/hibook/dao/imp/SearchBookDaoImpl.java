package ute.hibook.dao.imp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.SearchBookDao;
import ute.hibook.entity.Book;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SearchBookDaoImpl implements SearchBookDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Book> searchIndex(String key) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("from book where nameBook like :nameBook");
		de.setParameter("nameBook", "%"+key+"%");
		try{
			List<Book> books=de.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}
	public List<Book> searchIndexType(String key, String type) {
		Session session=sessionFactory.getCurrentSession();
		Query de;
		if(type.equals("")){
			de= session.createQuery("from book where nameBook like :nameBook");
			de.setParameter("nameBook", "%"+key+"%");
		}else {
			de= session.createQuery("from book where nameBook like :nameBook and idType = :idType");
			de.setParameter("idType", type);
			de.setParameter("nameBook", "%"+key+"%");
		}
		try{
			List<Book> books=de.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}
	public List<Book> searchFirstKey(String firstKey) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("from book where nameBook like :nameBook");
		de.setParameter("nameBook", firstKey+"%");
		try{
			List<Book> books=de.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}
	public List<Book> searchAuthor(int idAuthor) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("from book, authorbook where book.idBook = authorbook.idBook and idAuthor = :idAuthor");
		de.setParameter("idBook", idAuthor);
		try{
			List<Book> books=de.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}
	public List<Book> searchSupplier(int idSupplier) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("from book where idSupplier = :idSupplier");
		de.setParameter("idSupplier", idSupplier);
		try{
			List<Book> books=de.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}
	public List<Book> searchType(int idType) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("from book where idType = :idType");
		de.setParameter("idType", idType);
		try{
			List<Book> books=de.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}

}
