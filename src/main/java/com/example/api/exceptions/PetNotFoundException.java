package com.example.api.exceptions;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(String message){super(message);}
}
