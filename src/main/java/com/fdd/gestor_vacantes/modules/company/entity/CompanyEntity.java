package com.fdd.gestor_vacantes.modules.company.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "\\S+", message = " [username] no debe contener espacios")
    private String username;

    @Email(message = " [email] debe ser un e-mail válido")
    private String email;

    @Length(min = 10, max = 100, message = "Debe contener entre 10-100 caracteres")
    private String password;

    private String website;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
