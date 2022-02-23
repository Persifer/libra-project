package com.virgo.backend.exception;

public class PostException extends Exception{

    public PostException(String messaggio, Throwable causa){
        super(messaggio, causa);
    }

    public PostException(String messaggio){
        super(messaggio);
    }
}
