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
        User user2 =new User();
        user2.setName("user1");
        userService.saveUser(user2);
        User user3 =new User();
        user3.setName("user1");
        userService.saveUser(user3);
        User user4 =new User();
        user4.setName("user2");
        userService.saveUser(user4);
        Tweet tweet1 =new Tweet();
        tweet1.setText("tweet1");
        Tweet tweet2 =new Tweet();
        tweet2.setText("tweet2");
        Tweet tweet3 =new Tweet();
        tweet3.setText("tweet3");
        User userModified=new User();
        userModified=userService.addTweetToUser(tweet1, user1);
        userService.addTweetToUser(tweet2, user1);// todo de ce imi baga si Tweet 1 si 2?
        userService.addTweetToUser(tweet3, user2);
        //System.out.println(userModified.getTweets());
        //System.out.println(user1.getTweets());
        System.out.println(userService.findAllUsersByName("user2"));
        System.out.println(userService.findAllUsersByNameQuery("user1"));
        System.out.println(user3);
                userService.updateUserName(user3,"Name3");
        System.out.println(user3);
        //userService.userDelete(user1); //todo nu merge la campurile cu Tweets
        userService.deleteTweetFromUser(tweet1,user1);//todo nu merge
        Tweet foundTweet=tweetService.findTweetByText("tweet2");
        userService.deleteTweetFromUser(foundTweet,user1);
        System.out.println(foundTweet);
        System.out.println(tweetService.returnAllTweets());
        System.out.println(tweet1 + " + \n"+user1);
        //tweetService.deleteAllTweetsFromUser(user1);// todo asta merge
        //tweetService.deleteTweetByText("tweet3");


    }
}
