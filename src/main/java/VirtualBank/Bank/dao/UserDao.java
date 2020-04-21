	package VirtualBank.Bank.dao;

import java.util.List;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.Transaction;
import VirtualBank.Bank.model.User;

public interface UserDao 
{

	  int register(User user);

	  User validateUser(Login login);
	  
	  List<Transaction> ListTransaction(int cid);
	  
	  User shortsum(int cid);
	  
	  User summar(int acc);
	  
	  int deposit(int cid, int amount,Transaction transaction);
	  
	  int transfer(int cid , int amount,Transaction transaction);
	}

