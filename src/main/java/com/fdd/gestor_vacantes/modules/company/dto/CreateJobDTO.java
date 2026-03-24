package com.fdd.gestor_vacantes.modules.company.dto;
import lombok.Data;

@Data
public class CreateJobDTO {

    private String description;
    private String benefits;
    private String level;
}