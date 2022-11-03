package com.Spring.SpringJPA.twitterapp;

import org.springframework.stereotype.Service;

@Service
public class TweetService {
    TweetRepository tweetRepository;
    UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }
}
