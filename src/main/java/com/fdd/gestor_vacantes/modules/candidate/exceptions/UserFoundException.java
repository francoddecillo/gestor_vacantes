package com.fdd.gestor_vacantes.modules.candidate.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("Usuario existe");
    }
}
