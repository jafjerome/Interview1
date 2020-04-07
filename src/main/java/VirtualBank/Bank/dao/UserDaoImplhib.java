package VirtualBank.Bank.dao;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.User;

@Repository("UserDao")
public class UserDaoImplhib implements UserDao
{
	@Autowired
    public SessionFactory sf;
	
	@Transactional
	public int register(User user) 
	{
		// TODO Auto-generated method stub
	Session session = sf.getCurrentSession();
	session.save(user);
	return 0;
	}
	@Override
	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String HQL_QUERY="from User where username =?1 and password =?2";
		Query q=session.createQuery(HQL_QUERY);
		q.setParameter(1,  login.getUsername());
		q.setParameter(2,  login.getPassword());
		List<User> users =q.list();
		 return users.size() > 0 ? users.get(0) : null;
	}
}
