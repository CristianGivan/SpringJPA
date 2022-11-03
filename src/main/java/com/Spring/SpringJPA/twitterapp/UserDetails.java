package com.Spring.SpringJPA.twitterapp;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id_user_details")
    private Long id;

    @Column
    private String street;
    @Column
    private String number;

}
