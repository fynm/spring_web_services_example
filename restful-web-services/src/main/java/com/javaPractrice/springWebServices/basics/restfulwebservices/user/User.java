package com.javaPractrice.springWebServices.basics.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaPractrice.springWebServices.basics.restfulwebservices.post.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//used with swagger to show this in the desc of this item
@ApiModel(description = "All details about the user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    //Validations
    @Size(min=2, message = "Name should have atleast 2 characters.")
    @ApiModelProperty(notes="Name must be > 2 characters") //uses to show this description in swagger
    private String name;

    @Past //date can only be in the past
    @ApiModelProperty(notes="Birthday must be in the past") //uses to show this description in swagger
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User(){}

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [birthDate=" + birthDate + ", id=" + id + ", name=" + name + "]";
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}