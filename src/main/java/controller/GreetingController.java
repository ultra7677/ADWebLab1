package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.GreetingForm;

@Controller
public class GreetingController {

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public String showPage(GreetingForm greetingForm){
    	
    	return "/hello";
    }
    
    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String editGreetingForm(GreetingForm greetingForm){
    	//System.out.println(greetingForm.getName());
    	greetingForm.setContent("Hello," + greetingForm.getName());
    	return "/greeting";
    }
    
}
