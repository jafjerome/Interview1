package VirtualBank.Bank.dao;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.User;

public interface UserDao 
{

	  int register(User user);

	  User validateUser(Login login);
	}

