package com.fdd.gestor_vacantes.modules.exception;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(){
        super("Job not found");
    }
}
