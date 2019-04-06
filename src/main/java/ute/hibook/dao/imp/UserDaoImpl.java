package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.UserDao;
import ute.hibook.entity.User;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void deleteUser(int idUser) {
		sessionFactory.getCurrentSession().delete(getUserById(idUser));
	}

	public User getUserById(int idUser) {
		return sessionFactory.getCurrentSession().get(User.class, idUser);
	}

	public List<User> getAllUser() {
		return sessionFactory.getCurrentSession().createQuery("from user").getResultList();
	}

}
