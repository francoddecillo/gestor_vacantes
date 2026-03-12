package com.fdd.modules.candidate.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;


@Data
public class CandidateEntity {

    private UUID id;

    private String name;
    @NotBlank
    @Pattern(regexp = "\\S+", message = "El campo username no debe tener espacios")
    private String username;

    @Length(min=10, max=100, message = "El campo password debe tener entre 10-100 caracteres")
    private String password;

    @Email(message = "El campo email tiene que contener un email válido")

    private String email;

    private String description;

    private String curriculum;

}
