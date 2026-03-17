package com.fdd.gestor_vacantes.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @CreationTimestamp
    private LocalDateTime createdAt;


}
