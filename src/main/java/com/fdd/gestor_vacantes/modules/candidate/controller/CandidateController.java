package com.fdd.gestor_vacantes.modules.candidate.controller;


import com.fdd.gestor_vacantes.modules.candidate.entity.CandidateEntity;

import com.fdd.gestor_vacantes.modules.candidate.useCase.ApplyJobCandidateUseCase;
import com.fdd.gestor_vacantes.modules.candidate.useCase.CreateCandidateUseCase;
import com.fdd.gestor_vacantes.modules.candidate.useCase.ProfileCandidateUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CreateCandidateUseCase createCandidateUseCase;
    private final ProfileCandidateUseCase profileCandidateUseCase;
    private final ApplyJobCandidateUseCase applyJobCandidateUseCase;

    public CandidateController(CreateCandidateUseCase createCandidateUseCase, ProfileCandidateUseCase profileCandidateUseCase, ApplyJobCandidateUseCase applyJobCandidateUseCase) {
        this.createCandidateUseCase = createCandidateUseCase;
        this.profileCandidateUseCase = profileCandidateUseCase;
        this.applyJobCandidateUseCase = applyJobCandidateUseCase;
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){
        try{
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> get(HttpServletRequest request){
        var idCandidate = request.getAttribute("candidate_id");
        try {
            var profile = this.profileCandidateUseCase
                    .execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/job/apply")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> applyJob(HttpServletRequest request, @RequestBody UUID idJob){
        var idCandidate = request.getAttribute("candidate_id");
        try{
            var result = this.applyJobCandidateUseCase.execute(UUID.fromString(idCandidate.toString()), idJob);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
