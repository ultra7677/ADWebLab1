package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/hello") // Use Spring MVC to handle web requests
	@ResponseBody
	String home(){
		return "Hello World";
	}
	
	public static void main(String args[]) throws Exception{
		SpringApplication.run(SampleController.class,args);
	}
}
