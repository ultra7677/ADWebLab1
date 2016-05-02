###Build a Web Application with Spring Boot + Spring Web MVC + Thymeleaf

---
####Spring Boot  
Spring Boot offers a fast way to build "just run" applications with less configuration code.  

My application is based on Java maven project, and we should add these code to our dependency file `pom.xml`. 

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.3.3.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
    <dependencies>
		<dependency>
        	<groupId>org.springframework.boot</groupId>
        	<artifactId>spring-boot-starter-web</artifactId>
    	</dependency>
	</dependencies>

Then, we can write a simple Web application in Java.  

`SampleController.java`
<pre><code>
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
</code></pre>

`@Controller` represents "C" in Spring MVC, by using this annotation, Spring knows that this class is used for handling web requests.  

`@EnableAutoConfiguration` tells Spring to "guess" and help you do the configuration, since `spring-boot-starter-web` added Spring MVC and Tomcat, the auto configuration will assume that you are developing a web application and setup Spring accordingly.    

`@RequestMapping` annotation provides "routing" information, it tells Spring that any HTTP request with the path "/hello" should be mapped to the `home` method.  

Tomcat is started on tcp port 8080, so if we type `http://localhost:8080/hello` in a web browser, we will see "Hello World" in the openning page. 

---
####Spring Web MVC  
Until now, we have not use Model and View in our application, and that is what we will going to do in this section.  
The Spring Web model-view-controller (MVC) framework is designed around a `DispatcherServlet` that dispatches requests to handlers (ususally are `@Controller` and `@RequestMapping` annotations), and the workflow of this process is showing below.  


