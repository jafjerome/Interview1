package VirtualBank.Bank.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.Transaction;
import VirtualBank.Bank.model.User;
import VirtualBank.Bank.service.UserService;

@RestController
@SessionAttributes("login")
public class FundTransferController 
{
	@Autowired
	  public UserService userService;
	 private Logger logger = LogManager.getLogger(FundTransferController.class);
	@RequestMapping(value = "/Deposit/{cid}", method = { RequestMethod.GET, RequestMethod.POST })
	 public ModelAndView Deposit(@PathVariable("cid") int cid, HttpServletRequest request, HttpServletResponse response,
			 @ModelAttribute("transaction") Transaction transaction,Login login) 
	 {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Deposit.$$$$$$$$$$$$$$$$$$$");
		ModelAndView mav = new ModelAndView("Deposit");
		User u = userService.shortsum(cid);
		System.out.println("%%%%%%%%%%%%"+login.getUsername());
		mav.addObject("cid", cid);
		mav.addObject("account_number", u.getAccount_number());
		mav.addObject("amount", u.getAmount());
		 return mav;	
	 }
	@RequestMapping(value = "/DepositProcess/{cid}", method = { RequestMethod.GET, RequestMethod.POST })
	 public ModelAndView DepositProcess(@PathVariable("cid")int cid , HttpServletRequest request,Transaction transaction) 
	 {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Deposit Process.$$$$$$$$$$$$$$$$$$$");
		String mapping = "redirect:/loginProcess";
		ModelAndView mav = new ModelAndView(mapping);
		  int amount = Integer.parseInt(transaction.getAmount());
		 userService.deposit(cid, amount, transaction);
		 return mav;	
	 }
	@RequestMapping(value = "/Summary/{cid}", method = { RequestMethod.GET, RequestMethod.POST })
	 public ModelAndView Summary(@PathVariable("cid") int cid, HttpServletRequest request,
			 HttpServletResponse response) 
	 {
		
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Summary.$$$$$$$$$$$$$$$$$$$");
		User u = userService.summar(cid);
		ModelAndView mav = new ModelAndView("Summary");
			mav.addObject("firstname", u.getFirstname());
			mav.addObject("lastname", u.getLastname());
			mav.addObject("address", u.getAddress());
			mav.addObject("account_number", u.getAccount_number());
			mav.addObject("amount", u.getAmount());
		return mav;	
	 }
	@RequestMapping(value = "/Transfer/{cid}", method = { RequestMethod.GET, RequestMethod.POST })
	 public ModelAndView Transfer(@PathVariable("cid") int cid, HttpServletRequest request,
			 @ModelAttribute("transaction") Transaction transaction, HttpServletResponse response) 
	 {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Transfer.$$$$$$$$$$$$$$$$$$$");
		ModelAndView mav = new ModelAndView("Transfer");
		User u = userService.shortsum(cid);
		mav.addObject("cid", cid);
		mav.addObject("account_number", u.getAccount_number());
		mav.addObject("amount", u.getAmount());
		return mav;
	 }
	@RequestMapping(value = "/TransferProcess/{cid}", method = { RequestMethod.GET, RequestMethod.POST })
	 public ModelAndView TransferProcess(@PathVariable("cid") int cid, HttpServletRequest request,
			 @ModelAttribute("transaction") Transaction transaction, HttpServletResponse response) 
	 {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Transfer.$$$$$$$$$$$$$$$$$$$");
		String mapping = "redirect:/loginProcess";
		ModelAndView mav = new ModelAndView(mapping);
		 int amount = Integer.parseInt(transaction.getAmount());
		userService.transfer(cid, amount, transaction);
		return mav;
	 }
	@RequestMapping(value = "/Mini-Statement/{cid}", method = { RequestMethod.GET, RequestMethod.POST })
	 public ModelAndView MiniStatement(@PathVariable("cid") int cid, HttpServletRequest request,
			 @ModelAttribute("transaction") Transaction transaction, HttpServletResponse response) 
	 {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Mini.$$$$$$$$$$$$$$$$$$$");
		ModelAndView mav = new ModelAndView("Mini-Statement");
		User user = userService.shortsum(cid);
		List<Transaction> li = userService.ListTransaction(cid);
       for (Object o: li)
       {
    	   Map m=(Map)o;
    	System.out.println(m.get("amount"));	   
       }
		mav.addObject("firstname", user.getFirstname());
	    mav.addObject("lastname",user.getLastname());
	    mav.addObject("accnum",user.getAccount_number());
	    mav.addObject("address",user.getAddress());
	    mav.addObject("amount",user.getAmount());
	    mav.addObject("list",li);
	    return mav;
	 }
	
}
