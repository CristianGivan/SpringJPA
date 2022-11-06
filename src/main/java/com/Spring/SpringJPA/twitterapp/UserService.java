package com.Spring.SpringJPA.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    TweetRepository tweetRepository;
    UserRepository userRepository;

    public UserService(@Autowired TweetRepository tweetRepository, @Autowired UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User addTweetToUser(Tweet tweet, User user) {
        tweet.setUser(user);
        user.addTweet(tweet);
        //user.getTweets().add(tweet);
        //tweetRepository.save(tweet);
        return userRepository.save(user);
    }

    public List<User> findAllUsersByName(String name) {
        return userRepository.findAllByName(name);
    }

    public List<User> findAllUsersByNameQuery(String name) {
        return userRepository.findAllUsersByName(name);
    }

    public User updateUserName(User user, String name){
        user.setName(name);
        return userRepository.save(user);
    }
    public void userDelete(User user){
        userRepository.delete(user);
    }
    public void deleteTweetFromUser (Tweet tweet, User user){
        user.getTweets().remove(tweet);
        tweetRepository.delete(tweet);
    }

}
