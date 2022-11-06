package com.Spring.SpringJPA.TwitterApp2.Service;

import com.Spring.SpringJPA.TwitterApp2.Entities.Comment;
import com.Spring.SpringJPA.TwitterApp2.Entities.Tweet;
import com.Spring.SpringJPA.TwitterApp2.Entities.User;
import com.Spring.SpringJPA.TwitterApp2.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentsRepository;

    @Autowired
    public CommentService(CommentRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comment addCommentToTweet(Comment comment, Tweet tweet) {
        tweet.getComments().add(comment);
        comment.setTweet(tweet);
        return commentsRepository.save(comment);
    }

    public void deleteListOfComments(List<Comment> comments) {
        commentsRepository.deleteAll(comments);
    }

    public List<Comment> deleteCommentsFromTweet(Tweet tweet) {
        List<Comment> commentsToBeDeleted = commentsRepository.findCommentByTweet(tweet);
        deleteListOfComments(commentsToBeDeleted);
        return commentsToBeDeleted;

    }

    public  List<Comment> deleteAllCommentsOfAUser(User user){
        List<Comment> commentsToBeDeleted =commentsRepository.findCommentByTweet_User(user);
        deleteListOfComments(commentsToBeDeleted);
        return commentsToBeDeleted;

    }

}
