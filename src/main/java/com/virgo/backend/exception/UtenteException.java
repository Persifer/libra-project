package com.virgo.backend.exception;

public class UtenteException extends Exception{

    public UtenteException(String messaggio, Throwable causa){
        super(messaggio, causa);
    }

    public UtenteException(String messaggio){
        super(messaggio);
    }
}
