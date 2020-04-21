package VirtualBank.Bank.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import VirtualBank.Bank.model.User;
import VirtualBank.Bank.service.UserService;

@RestController
public class RegisterController 
{
	@Autowired
	  public UserService userService;
	@RequestMapping(value = "/Register", method = { RequestMethod.GET, RequestMethod.POST })	
	 public ModelAndView register()  
		{
		ModelAndView mav = new ModelAndView("Register");
	    mav.addObject("user", new User());
	    return mav;
		}
	
	@RequestMapping(value = "/registerProcess",  method = { RequestMethod.GET, RequestMethod.POST })
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("user") User user) {
	    userService.register(user);
	    ModelAndView mav = null;
	    mav = new ModelAndView("welcome");
	    mav.addObject("firstname", user.getFirstname());
	    mav.addObject("accnum",user.getAccount_number());
	    return mav;
	  }
}
