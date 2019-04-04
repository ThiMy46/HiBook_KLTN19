package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.BookDao;
import ute.hibook.entity.Book;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class BookDaoImpl implements BookDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	public void deleteBook(int idBook) {
		sessionFactory.getCurrentSession().delete(getBookById(idBook));
	}

	public Book getBookById(int idBook) {
		return sessionFactory.getCurrentSession().get(Book.class, idBook);
	}

	public List<Book> getAllBook() {
		return sessionFactory.getCurrentSession().createQuery("from book").getResultList();
	}

}
