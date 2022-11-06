package com.Spring.SpringJPA.TwitterApp2.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq",initialValue = 1,allocationSize = 1)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL
            //,orphanRemoval = true
    )
    private List<Tweet> tweets;


    public User() {
    }

    public User(String name, String address, List<Tweet> tweets) {
        this.name = name;
        this.address = address;
        this.tweets = tweets;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Tweet> getTweets() {
        if (tweets == null) {
            tweets = new ArrayList<>();
        }
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tweets=" + tweets +
                '}';
    }
}
