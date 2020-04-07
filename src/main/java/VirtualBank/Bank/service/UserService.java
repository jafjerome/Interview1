package VirtualBank.Bank.service;

import org.springframework.stereotype.Service;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.User;


public interface UserService {

  int register(User user);

  User validateUser(Login login);
}