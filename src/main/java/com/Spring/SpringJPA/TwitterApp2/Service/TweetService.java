package com.Spring.SpringJPA.TwitterApp2.Service;

import com.Spring.SpringJPA.TwitterApp2.Repository.TweetRepository;
import com.Spring.SpringJPA.TwitterApp2.Entities.Tweet;
import com.Spring.SpringJPA.TwitterApp2.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
    private TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public Tweet findTweetById(Long id) {
        return tweetRepository.findTweetById(id);
    }

    public Tweet addTweetToUser(Tweet tweet, User user) {
        tweet.setUser(user);
        user.getTweets().add(tweet);// todo de ce ar trebui sa mai fac si in java pana unde merge magia
        return tweetRepository.save(tweet);
    }

    public void deleteTweet(Tweet tweet) {
        tweetRepository.delete(tweet);
    }
    public void deleteAllCommentFromTweet(Tweet tweet){
        tweet.getComments().clear();
        tweetRepository.save(tweet);
    }

}
