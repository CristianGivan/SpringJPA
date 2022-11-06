package com.Spring.SpringJPA.twitterapp;

import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public class TweetService {
    TweetRepository tweetRepository;
    UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }
    public Tweet findTweetByText(String text){
        return tweetRepository.findTweetByText(text);
    }
    public List<Tweet> returnAllTweets(){
        return (List<Tweet>) tweetRepository.findAll();
    }

    public void deleteAllTweetsFromUser(User user){
        tweetRepository.deleteAll(user.getTweets());
        //System.out.println(user.getTweets());
        user.getTweets().clear();
        //tweetRepository.deleteTweetsById(7L);
        //tweetRepository.deleteAll();
        //System.out.println(user.getTweets());
        //tweetRepository.deleteAll(user.getTweets());
    }
    public void deleteTweetByText(String text){
        tweetRepository.deleteTweetsByText(text);
    }
}
