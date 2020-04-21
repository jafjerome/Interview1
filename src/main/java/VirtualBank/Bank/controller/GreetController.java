package VirtualBank.Bank.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import VirtualBank.Bank.model.Login;
import VirtualBank.Bank.model.User;
import VirtualBank.Bank.service.UserService;

@RestController
@SessionAttributes("login")
public class GreetController 
{
	 private Logger logger = LogManager.getLogger(GreetController.class);
	  @Autowired
	  UserService userService;
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })	
	 public ModelAndView root()  
	{
		logger.info("$$$$$$$$$$$$$$$$$$$Entering application.$$$$$$$$$$$$$$$$$$$");
		ModelAndView mav = new ModelAndView("home");
		 return mav;
	}
	@RequestMapping(value = "/Login",method=RequestMethod.GET)	
	   public ModelAndView showLogin(Login login,	HttpServletRequest request, HttpServletResponse response)
	    {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering Login.$$$$$$$$$$$$$$$$$$$");
	        ModelAndView mav = new ModelAndView("Login");
	        mav.addObject("login", new Login());
	        request.setAttribute("login", login);
	        return mav;
	    }
	@RequestMapping(value = "/loginProcess",  method = { RequestMethod.GET, RequestMethod.POST })
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
		logger.info("$$$$$$$$$$$$$$$$$$$Entering LoginProcess.$$$$$$$$$$$$$$$$$$$");
		String uname = request.getParameter("username");
		HttpSession session =request.getSession();
		session.setAttribute("username", uname);
	    ModelAndView mav = null;
	    User user = userService.validateUser(login);
	    if (null != user) 
	    {
	    mav = new ModelAndView("sample");
	    mav.addObject("firstname", user.getFirstname());
	    mav.addObject("lastname",user.getLastname());
	    mav.addObject("accnum",user.getAccount_number());
	    mav.addObject("cid",user.getId());
	    }
	    else
	    {
	    mav = new ModelAndView("Login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	

    @RequestMapping(value = "/Logoff", method = { RequestMethod.GET, RequestMethod.POST })	
   public ModelAndView execute(HttpServletRequest request,SessionStatus status)
    {	
    	ModelAndView mav =new ModelAndView("Logoff");
        HttpSession session = request.getSession(false);
        session.removeAttribute("login");
        status.setComplete();
        session.invalidate();
        return mav;
    }
}
