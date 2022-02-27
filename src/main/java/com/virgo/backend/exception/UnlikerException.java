package com.virgo.backend.exception;

public class UnlikerException extends Exception{

    public UnlikerException(String message){
        super(message);
    }

    public UnlikerException(String message, Throwable throwable){
        super(message, throwable);
    }
}
