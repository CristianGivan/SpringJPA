package com.Spring.SpringJPA.TwitterApp2.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tweet_seq")
    @SequenceGenerator(name = "tweet_seq", sequenceName = "tweet_seq",initialValue = 1,allocationSize = 1)
    @Column(name = "tweet_id")
    private Long id;

    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id_")
    private User user;


    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    List<Comment> comments;


    public Tweet() {
    }

    public Tweet(String text) {
        this.text = text;
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

    public List<Comment> getComments() {
        if (comments==null){
            comments=new ArrayList<>();
        }
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user_id=" + user.getId() +
                ", comments=" + comments +
                '}';
    }
}
