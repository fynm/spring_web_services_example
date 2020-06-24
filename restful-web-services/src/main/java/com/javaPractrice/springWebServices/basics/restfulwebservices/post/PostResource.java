package com.javaPractrice.springWebServices.basics.restfulwebservices.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {
    
    @Autowired
    private PostDaoService service;

    //Get all posts
    @GetMapping(path="/users/posts")
    public List<Post> retrieveAllPosts(){
        return service.findAll();
    }

    //Get all posts from user
    @GetMapping(path="/users/{userId}/posts")
    public List<Post> retrieveAllUserPosts(@PathVariable int userId){
        List<Post> userPosts = service.findAllFromUser(userId);
        if(userPosts == null){
            //throw exception
        }
        return userPosts;
    }

    @PostMapping(path="/users/{userId}/posts")
    public void createPost(@RequestBody Post post, @PathVariable int userId){
        //post.setUserId(userId);
        Post savedPost = service.save(post);
    }
}