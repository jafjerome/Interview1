package main.java.com.jafrin.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FundTransferController 
{
	@RequestMapping(value = "/FundTransfer",method=RequestMethod.GET)
	 public ModelAndView Transfer() 
	 {
		String mapping= "Transfer";
		 return new ModelAndView(mapping);		
	 }

}
