package com.javaPractrice.springWebServices.basics.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
    private static List<Post> posts = new ArrayList<>();
    
    private static int postsCount = 3;

    static{
        posts.add(new Post(1, "The first post!", new Date(), 1));
        posts.add(new Post(2, "The seceond post!", new Date(), 1));
        posts.add(new Post(3, "The third post!", new Date(), 2));
    }

    public List<Post> findAll(){
        return posts;
    }

    public List<Post> findAllFromUser(int userId){
        List<Post> userPosts = new ArrayList<>();
        for(Post post:posts){
            if(post.getUserId()==userId){
                userPosts.add(post);
            }
        }
        if(userPosts.size() > 0){
            return userPosts;
        }else{
            return null;
        }
    }

    public Post save(Post post){
        if(post.getId() == null){
            post.setId(++postsCount);
        }
        posts.add(post);
        return post;
    }


}