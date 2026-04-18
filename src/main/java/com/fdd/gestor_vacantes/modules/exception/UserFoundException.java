package com.fdd.gestor_vacantes.modules.exception;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("User already exists");
    }
}
