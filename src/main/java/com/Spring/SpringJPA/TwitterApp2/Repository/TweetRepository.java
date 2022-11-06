package com.Spring.SpringJPA.TwitterApp2.Repository;

import com.Spring.SpringJPA.TwitterApp2.Entities.Tweet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<Tweet,Long> {

    Tweet findTweetById(Long id);
}
