package com.Spring.SpringJPA.TwitterApp2.Exceptions;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(String message){
        super(message);
    }
}
