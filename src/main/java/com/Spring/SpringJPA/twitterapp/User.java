package com.Spring.SpringJPA.twitterapp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tweet> tweets;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tweet> getTweets() {
        if (tweets == null) {
            return new ArrayList<>();
        }
        return tweets;
    }

    public void setTweets(List<Tweet> tweet) {
        this.tweets = tweet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tweet=" + tweets +
                '}';
    }

    public List<Tweet> addTweet(Tweet tweet) {
        List<Tweet> newTweets=this.getTweets();
        newTweets.add(tweet);
        tweets=newTweets;
        return tweets;
    }
}
