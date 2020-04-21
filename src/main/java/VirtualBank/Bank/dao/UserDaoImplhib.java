package VirtualBank.Bank.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.Transaction;
import VirtualBank.Bank.model.User;

@Repository("UserDao")
public class UserDaoImplhib implements UserDao
{
	@Autowired
    public SessionFactory sf;
	List<User> users;
	
	@Transactional
	public int register(User user) 
	{
	Session session = sf.getCurrentSession();
	String accnumber= RandomString(); 
	user.setAccount_number(accnumber);
	session.save(user);
	Transaction t = new Transaction();
	String uid=Integer.toString(user.getId()) ;
	t.setUid(uid);
	t.setAccount_number_source(accnumber);
	t.setAccount_number_target("OPENING BALANCE");
	t.setAmount(user.getAmount());
	t.setDate(Date());
	t.setBalance(user.getAmount());
	t.setFloating_amount("0");
	t.setType("CREDITED");
	session.save(t);
	return 0;
	}
	@Override
	@Transactional
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

	@Override
	@Transactional
	public User summar(int acc) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		User us = session.get(User.class, acc);
		return us;
	}
	
	public String Date()
	{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	String d= (formatter.format(date)).toString();
	return d;
	}
	
	public String RandomString()
	{ 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	        int n=10;
	        StringBuilder sb = new StringBuilder(n); 
	        for (int i = 0; i < n; i++) 
	        { 
	            int index = (int)(AlphaNumericString.length() * Math.random()); 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
			return sb.toString();
	    } 
	@Override
	@Transactional
	public User shortsum(int cid) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		User us = session.get(User.class, cid);
		return us;
	}
	
	@Override
	@Transactional
	public int deposit(int cid ,  int amount,Transaction transaction) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String HQL_QUERY="update User set amount =?1 where id =?2 ";
		Integer a=Integer.parseInt(transaction.getFloating_amount())+amount;
		String acc=Integer.toString(a) ;
		String c=Integer.toString(cid);
		transaction.setBalance(acc);
		transaction.setDate(Date());
		transaction.setUid(c);
		transaction.setAccount_number_target("DEPOSIT-SELF");
		transaction.setType("CREDITED");
		session.save(transaction);
		Query q=session.createQuery(HQL_QUERY);
		q.setParameter(1,  acc);
		q.setParameter(2, cid);
		int s=q.executeUpdate();
		return s;
	}
	@Override
	@Transactional
	public int transfer(int cid, int amount, Transaction transaction)
	{
		Session session = sf.getCurrentSession();
		//Amount debited for user sending
		Integer a=Integer.parseInt(transaction.getFloating_amount())-amount;
		String acc=Integer.toString(a) ;
		String HQL_QUERY="update User set amount =?1 where id =?2 ";
		Query q=session.createQuery(HQL_QUERY);
		q.setParameter(1,  acc);
		q.setParameter(2, cid);
		q.executeUpdate();
		//Amount credited for recipient user
		String HQL_QUERY1="from User where account_number =?1";
		Query q1=session.createQuery(HQL_QUERY1);
		int cidr = 0;
		String amountr = "";
		q1.setParameter(1,transaction.getAccount_number_target());
		          //getting the id of the recipient
		List<User> users =q1.list();
		Iterator<User> li =users.iterator();
		while(li.hasNext())
		{
			Object o =(Object)li.next();
			User u = (User)o;
			 cidr=u.getId();
			 amountr=u.getAmount();
		}
		String HQL_QUERY2="update User set amount =?1 where id =?2 ";
		Query q2=session.createQuery(HQL_QUERY2);
		Integer ar=Integer.parseInt(amountr)+amount;
		String balr=Integer.toString(ar);
		q2.setParameter(1,  balr);
		q2.setParameter(2, cidr);
		q2.executeUpdate();
		//insert in transaction table  for sending user
		String c=Integer.toString(cid);
		transaction.setDate(Date());
		transaction.setUid(c);
		transaction.setBalance(acc);
		transaction.setType("DEBITED");
		session.save(transaction);
		//insert in transaction table  for recipient user
		String cr=Integer.toString(cidr);
		Transaction t =new Transaction();
		t.setDate(Date());
		t.setUid(cr);
		t.setBalance(balr);
		t.setAccount_number_source("NEFT FROM");
		t.setAccount_number_target(transaction.getAccount_number_source());
		t.setFloating_amount(amountr);
		t.setBalance(balr);
		t.setAmount(transaction.getAmount());
		t.setType("CREDITED");
		session.save(t);
		return 0;
	}
	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public List<Transaction> ListTransaction(int cid) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		//String HQL_QUERY="select * from Transaction where uid =?1";
		String uid= Integer.toString(cid) ;
		@SuppressWarnings("rawtypes")
		NativeQuery  query = session.createNativeQuery("select tid,type,account_number_source,account_number_target,date,Floating_amount,balance,amount from transaction_details where uid =?");
		//Query<Transaction> q=session.createQuery(HQL_QUERY);
		query.setParameter(1, uid);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List t=query.list();
		return query.list();
	}
}
