package main.java.com.jafrin.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GreetController 
{
	@RequestMapping(value = "/",method=RequestMethod.GET)	
	 public ModelAndView root()  
	{
		String mapping= "home";
		 return new ModelAndView(mapping);
	}
	@RequestMapping(value = "/Login",method=RequestMethod.GET)	
	   public ModelAndView login()
	    {
	        String mapping="Login" ;
	        return new ModelAndView(mapping);
	    }
    @RequestMapping(value = "/Logoff",method=RequestMethod.GET)	
   public ModelAndView execute()
    {
        String mapping="Logoff" ;
        return new ModelAndView(mapping);
    }
}
