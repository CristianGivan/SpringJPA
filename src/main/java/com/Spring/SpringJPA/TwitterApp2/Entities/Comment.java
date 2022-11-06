package com.Spring.SpringJPA.TwitterApp2.Entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq")
    @SequenceGenerator(name = "comments_seq"
            , sequenceName = "comments_seq"
            , initialValue = 1
            , allocationSize = 1
    )

    @Column(name = "comments_id")
    private Long id;

    @Column(name = "text")
    private String text;

/*    @Column(name = "tweet")
    private Tweet tweet12;*/
    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    public Comment() {
    }

    public Comment(String text) {
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

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", tweet_id=" + tweet.getId() +
                '}';
    }
}
