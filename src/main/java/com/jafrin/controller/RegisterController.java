package main.java.com.jafrin.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController 
{
	@RequestMapping(value = "/Register",method=RequestMethod.GET)	
	 public ModelAndView register()  
		{
			String mapping= "Register";
			 return new ModelAndView(mapping);
		}
}
