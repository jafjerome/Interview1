package VirtualBank.Bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.Transaction;
import VirtualBank.Bank.model.User;

@Service
public interface UserService {

  int register(User user);

  User summar(int acc);
  
  User validateUser(Login login);
   
  User shortsum(int cid);
  
  int deposit(int cid , int amount,Transaction transaction);
  
  int transfer(int cid , int amount,Transaction transaction);
  
  List<Transaction> ListTransaction(int cid);
}