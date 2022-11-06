package com.Spring.SpringJPA.twitterapp;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "tweet_tab")
public class Tweet {
    @Id
    @GeneratedValue
    @Column(name = "id_tweet")
    private Long id;

    @Column (name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Tweet() {
    }

    public Long getId() {
        return id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user_id="+user.getId()+
                 '}';
    }
}
