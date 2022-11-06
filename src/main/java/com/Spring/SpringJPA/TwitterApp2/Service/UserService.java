package com.Spring.SpringJPA.TwitterApp2.Service;

import com.Spring.SpringJPA.TwitterApp2.Exceptions.NoUserFoundException;
import com.Spring.SpringJPA.TwitterApp2.Repository.TweetRepository;
import com.Spring.SpringJPA.TwitterApp2.Repository.UserRepository;
import com.Spring.SpringJPA.TwitterApp2.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    @Autowired
    public UserService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }
    public User findUserById(Long id) throws NoUserFoundException {

        return userRepository.findById(id).orElseThrow(()->new NoUserFoundException("User not found"));
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    public void deleteUserById(Long id) throws NoUserFoundException {
        userRepository.delete(findUserById(id));
    }
}
