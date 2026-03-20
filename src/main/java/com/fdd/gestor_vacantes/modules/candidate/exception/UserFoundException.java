package com.fdd.gestor_vacantes.modules.candidate.exception;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("Usuario existe");
    }
}
