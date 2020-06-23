package com.javaPractrice.springWebServices.basics.restfulwebservices.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController {
    
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


}