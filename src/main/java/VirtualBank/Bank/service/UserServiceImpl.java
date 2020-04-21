package VirtualBank.Bank.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VirtualBank.Bank.dao.UserDao;
import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.Transaction;
import VirtualBank.Bank.model.User;

public class UserServiceImpl implements UserService {
      @Autowired      
	  public UserDao userDao;
      
    @Override
  	@Transactional
	  public int register(User user) {
	    return userDao.register(user);
	  }

    @Override
	@Transactional
	  public User validateUser(Login login) {
	    return userDao.validateUser(login);
	  }

	@Override
	public User summar(int acc) {
		// TODO Auto-generated method stub
		return userDao.summar(acc);
	}


	@Override
	public User shortsum(int cid) {
		// TODO Auto-generated method stub
		return userDao.shortsum(cid);
	}

	@Override
	public int deposit(int cid, int amount,Transaction transaction ) {
		// TODO Auto-generated method stub
		return userDao.deposit(cid, amount, transaction);
	}

	@Override
	public int transfer(int cid, int amount, Transaction transaction) {
		// TODO Auto-generated method stub
		return userDao.transfer(cid, amount, transaction);
	}

	@Override
	public List<Transaction> ListTransaction(int cid) {
		// TODO Auto-generated method stub
		return userDao.ListTransaction(cid);
	}
	}
