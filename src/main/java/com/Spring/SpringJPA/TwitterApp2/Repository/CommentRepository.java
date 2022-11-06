package com.Spring.SpringJPA.TwitterApp2.Repository;

import com.Spring.SpringJPA.TwitterApp2.Entities.Comment;
import com.Spring.SpringJPA.TwitterApp2.Entities.Tweet;
import com.Spring.SpringJPA.TwitterApp2.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findCommentByTweet(Tweet tweet);
    public List<Comment> findCommentByTweet_User(User user);
}
