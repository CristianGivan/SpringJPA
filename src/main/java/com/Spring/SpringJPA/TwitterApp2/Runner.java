package com.Spring.SpringJPA.TwitterApp2;

import com.Spring.SpringJPA.TwitterApp2.Entities.Comment;
import com.Spring.SpringJPA.TwitterApp2.Entities.Tweet;
import com.Spring.SpringJPA.TwitterApp2.Entities.User;
import com.Spring.SpringJPA.TwitterApp2.Service.CommentService;
import com.Spring.SpringJPA.TwitterApp2.Service.TweetService;
import com.Spring.SpringJPA.TwitterApp2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private UserService userService;
    private TweetService tweetService;
    private CommentService commentsService;

    @Autowired
    public Runner(
            UserService userService,
            TweetService tweetService,
            CommentService commentsService
    ) {
        this.userService = userService;
        this.tweetService = tweetService;
        this.commentsService = commentsService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("user1", "address1", null);
        User user2 = new User("user2", "address1", null);
        User user3 = new User("user3", "address2", null);
        User user4 = new User("user4", "address2", null);
        User user5 = new User("user5", "address3", null);
        User addedUser1 = userService.addUser(user1);
        User addedUser2 = userService.addUser(user2);
        User addedUser3 = userService.addUser(user3);
        User addedUser4 = userService.addUser(user4);
        User addedUser5 = userService.addUser(user5);


        Tweet tweet1 = new Tweet("text1");
        Tweet tweet2 = new Tweet("text2");
        Tweet tweet3 = new Tweet("text3");
        Tweet tweet4 = new Tweet("text4");
        Tweet tweet5 = new Tweet("text5");
        Tweet tweetSaved1 = tweetService.addTweetToUser(tweet1, user1);
        Tweet tweetSaved2 = tweetService.addTweetToUser(tweet2, user2);
        Tweet tweetSaved3 = tweetService.addTweetToUser(tweet3, user2);
        Tweet tweetSaved4 = tweetService.addTweetToUser(tweet4, user3);
        Tweet tweetSaved5 = tweetService.addTweetToUser(tweet5, user4);

        Comment comment1 = new Comment("Comment1");
        Comment comment2 = new Comment("Comment2");
        Comment comment3 = new Comment("Comment3");
        Comment comment4 = new Comment("Comment4");
        Comment comment5 = new Comment("Comment5");
        Comment commentSaved1 = commentsService.addCommentToTweet(comment1, tweet1);
        Comment commentSaved2 = commentsService.addCommentToTweet(comment2, tweet2);
        Comment commentSaved3 = commentsService.addCommentToTweet(comment3, tweet2);
        Comment commentSaved4 = commentsService.addCommentToTweet(comment4, tweet3);
        Comment commentSaved5 = commentsService.addCommentToTweet(comment5, tweet4);


        Tweet tweetFound = tweetService.findTweetById(2l);
        user3.setAddress("addressX");
        User userModified = user3;
        userService.updateUser(userModified);
        //userService.deleteUser(user5);
        //userService.deleteUserById(3l);// todo de ce nu merge sa sterg ID1
        //tweetService.deleteTweet(tweet2);

        Long idTweetToBeDeleted =2L;
        Tweet beforeDeletedTweed=tweetService.findTweetById(idTweetToBeDeleted);
        System.out.println("Before delete " +beforeDeletedTweed);
        tweetService.deleteAllCommentFromTweet(beforeDeletedTweed);
        Tweet afterDeletedTweed=tweetService.findTweetById(idTweetToBeDeleted);
        System.out.println("After delete " + afterDeletedTweed);
        List<Comment> commentsToBeDeleted=new ArrayList<>();
        //commentsToBeDeleted=commentsService.deleteCommentsFromTweet(beforeDeletedTweed);
        List<User> allUsers = userService.getAllUsers();

        List<Comment> commentsToBeDeletedFromUser=new ArrayList<>();
        commentsToBeDeletedFromUser=commentsService.deleteAllCommentsOfAUser(addedUser2);
        System.out.println(commentsToBeDeletedFromUser);

        System.out.println(commentsToBeDeleted);
        System.out.println(allUsers);
        System.out.println("AllUsers:\n");
        allUsers.forEach(x -> System.out.println(x));
        System.out.println("Before delete " +beforeDeletedTweed);
        System.out.println("After delete " + afterDeletedTweed);;
        System.out.println(commentsToBeDeleted);
        System.out.println(commentsToBeDeletedFromUser);
    }
}
