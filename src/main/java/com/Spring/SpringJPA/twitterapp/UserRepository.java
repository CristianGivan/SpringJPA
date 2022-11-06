package com.Spring.SpringJPA.twitterapp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findAllByName(String name);
    //@Query(value = "Select u from User u where u.name= : nameUser")
    @Query(value = "Select \n" +
            "*\n" +
            "from user_tab as u\n" +
            "where\n" +
            "u.user_name=\"user1\";",nativeQuery = true)
    List<User> findAllUsersByName(@Param("nameUser") String name);
}
