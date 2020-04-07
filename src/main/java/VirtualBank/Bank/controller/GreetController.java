package VirtualBank.Bank.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.User;
import VirtualBank.Bank.service.UserService;

@RestController
public class GreetController 
{
	 private Logger logger = LogManager.getLogger(GreetController.class);
	  @Autowired
	  UserService userService;
	@RequestMapping(value = "/",method=RequestMethod.GET)	
	 public ModelAndView root()  
	{
		logger.info("$$$$$$$$$$$$$$$$$$$Entering application.$$$$$$$$$$$$$$$$$$$");
		ModelAndView mav = new ModelAndView("home");
		 return mav;
	}
	@RequestMapping(value = "/Login",method=RequestMethod.GET)	
	   public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response)
	    {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Login.$$$$$$$$$$$$$$$$$$$");
	        ModelAndView mav = new ModelAndView("Login");
	        mav.addObject("login", new Login());
	        return mav;
	    }
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering LoginProcess.$$$$$$$$$$$$$$$$$$$");
	    ModelAndView mav = null;
	    User user = userService.validateUser(login);
	    if (null != user) {
	    mav = new ModelAndView("welcome");
	    mav.addObject("firstname", user.getFirstname());
	    } else {
	    mav = new ModelAndView("Login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }

    @RequestMapping(value = "/Logoff",method=RequestMethod.GET)	
   public ModelAndView execute()
    {
        String mapping="Logoff" ;
        return new ModelAndView(mapping);
    }
}
