package com.fdd.gestor_vacantes.modules.company.controller;


import com.fdd.gestor_vacantes.modules.company.dto.CreateJobDTO;
import com.fdd.gestor_vacantes.modules.company.entity.JobEntity;
import com.fdd.gestor_vacantes.modules.company.useCase.CreateJobUseCase;
import com.fdd.gestor_vacantes.modules.company.useCase.ListAllJobsByCompanyUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;
@RestController
@RequestMapping("/company/job")
public class JobController {


    private final CreateJobUseCase createJobUseCase;
    private final ListAllJobsByCompanyUseCase listAllJobsByCompanyUseCase;

    public JobController(CreateJobUseCase createJobUseCase, ListAllJobsByCompanyUseCase listAllJobsByCompanyUseCase) {
        this.createJobUseCase = createJobUseCase;
        this.listAllJobsByCompanyUseCase = listAllJobsByCompanyUseCase;
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        try{
            var jobEntity = JobEntity.builder()
                    .benefits(createJobDTO.getBenefits())
                    .companyId(UUID.fromString(companyId.toString()))
                    .description(createJobDTO.getDescription())
                    .level(createJobDTO.getLevel())
                    .build();

            var result = this.createJobUseCase.execute(jobEntity);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public ResponseEntity<Object> listByCompany(HttpServletRequest request){
        var companyId = request.getAttribute("company_id");
        var result = this.listAllJobsByCompanyUseCase.execute(UUID.fromString(companyId.toString()));
        return ResponseEntity.ok().body(result);
    }

}