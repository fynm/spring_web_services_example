package com.javaPractrice.springWebServices.basics.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController {

    //Internationlization
    @Autowired
    private MessageSource messageSource;
    
    //method - Hello World
    //HTTP Method: GET
    //URI - /hello-world
    @RequestMapping(method=RequestMethod.GET, path="/hello-world")
    //@GetMapping(path="/hello-world") -> alternative
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping(method=RequestMethod.GET, path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale){
        return messageSource.getMessage("good.morning.message",null, locale);
    }


}