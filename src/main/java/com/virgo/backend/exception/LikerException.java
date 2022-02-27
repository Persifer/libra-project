package com.virgo.backend.exception;

public class LikerException extends Exception{

    public LikerException(String message){
        super(message);
    }

    public LikerException(String message, Throwable throwable){
        super(message, throwable);
    }
}
