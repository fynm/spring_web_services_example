package com.javaPractrice.springWebServices.basics.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
    
    @Autowired
    private UserDaoService service;
    
    //retreive all users
    //GET /users
    @GetMapping(path="/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //retrieveUser(int id) - specific user based on id
    //GET /users/{id}

    @GetMapping(path="/users/{id}")
    public User retrieveUser_id(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id); //created exception msg and mark it as 404 
        }
        return user;
    }

    //To Test this we will need to use a REST Client -> getpostman.com 
    //Created
    //input - details of the user
    //output - created and returned created URI
    @PostMapping(path="/users")
    public ResponseEntity createUser(@RequestBody User user){
        User savedUser = service.save(user);

        //Create URI of new saved User
        // /users/{id}    id->savedUser.getId(); 
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedUser.getId())
                        .toUri();
        //return status code 
        return ResponseEntity.created(location).build();
    }

}