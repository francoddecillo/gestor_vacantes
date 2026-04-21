package com.fdd.gestor_vacantes.modules.exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException() {
        super("Company not found");
    }
}