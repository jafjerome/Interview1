package VirtualBank.Bank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VirtualBank.Bank.dao.UserDao;
import VirtualBank.Bank.model.Login;
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

	}
