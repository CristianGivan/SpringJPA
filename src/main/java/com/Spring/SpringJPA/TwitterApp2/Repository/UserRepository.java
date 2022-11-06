package com.Spring.SpringJPA.TwitterApp2.Repository;

import com.Spring.SpringJPA.TwitterApp2.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {



}
