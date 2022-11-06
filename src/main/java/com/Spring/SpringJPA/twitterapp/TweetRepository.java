package com.Spring.SpringJPA.twitterapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {
    Tweet findTweetByText(String text);
    void deleteTweetsById(Long id);
    void deleteTweetsByText(String text);


}
