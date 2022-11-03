package com.Spring.SpringJPA.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    public UserService userService;
    public TweetService tweetService;

    public Runner(@Autowired UserService userService,@Autowired TweetService tweetService){
        this.userService=userService;
        this.tweetService=tweetService;
    }


    @Override
    public void run(String... args) throws Exception {

        User user1 =new User();
        user1.setName("user1");
        userService.saveUser(user1);
        Tweet tweet1 =new Tweet();
        tweet1.setText("tweet1");
        User userModified=new User();
        userModified=userService.addTweetToUser(tweet1, user1);
        //System.out.println(userModified.getTweets());
        //System.out.println(user1.getTweets());
    }
}
