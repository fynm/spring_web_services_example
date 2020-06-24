package com.javaPractrice.springWebServices.basics.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.javaPractrice.springWebServices.basics.restfulwebservices.post.Post;
import com.javaPractrice.springWebServices.basics.restfulwebservices.post.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import org.springframework.hateoas.EntityModel;
// import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserJpaResource {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PostRepository postRepo;

    // retreive all users
    // GET /users
    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepo.findAll();
    }

    // retrieveUser(int id) - specific user based on id
    // GET /users/{id}

    @GetMapping(path = "/jpa/users/{id}")
    public Optional<User> retrieveUser_id(@PathVariable int id) {
        Optional<User> user = userRepo.findById(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id); //created exception msg and mark it as 404 
        }

        //HATEOAS -> enables us to add more links for request returns
        //Going to skip this practice section for Hateoas -> depreciated and doesnt work based on course
        // EntityModel<User> model = new EntityModel<>(user);
        // WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        // model.add(linkTo.withRel("all-users"));

        return user;
    }

    //To Test this we will need to use a REST Client -> getpostman.com 
    //Created
    //input - details of the user
    //output - created and returned created URI
    //Need @Valid for validations
    @PostMapping(path="/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User savedUser = userRepo.save(user);

        //Create URI of new saved User
        // /users/{id}    id->savedUser.getId(); 
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedUser.getId())
                        .toUri();
        //return status code 
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepo.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsersPost(@PathVariable int id){
        Optional<User> userOptional = userRepo.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
        Optional<User> userOptional = userRepo.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }

        User user = userOptional.get();
        post.setUser(user);

        postRepo.save(post);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}").buildAndExpand(post.getId())
                        .toUri();
        //return status code 
        return ResponseEntity.created(location).build();
    }

}