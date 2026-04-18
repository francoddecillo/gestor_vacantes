package com.fdd.gestor_vacantes.modules.candidate.useCase;


import com.fdd.gestor_vacantes.modules.candidate.repository.ApplyJobRepository;
import com.fdd.gestor_vacantes.modules.exception.JobNotFoundException;
import com.fdd.gestor_vacantes.modules.exception.UserNotFoundException;
import com.fdd.gestor_vacantes.modules.candidate.repository.CandidateRepository;
import com.fdd.gestor_vacantes.modules.company.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {
    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;
    private final ApplyJobRepository applyJobRepository;

    public ApplyJobCandidateUseCase(CandidateRepository candidateRepository, JobRepository jobRepository, ApplyJobRepository applyJobRepository) {
        this.candidateRepository = candidateRepository;
        this.jobRepository = jobRepository;
        this.applyJobRepository = applyJobRepository;

    }

    public void execute(UUID idCandidate, UUID idJob){
        this.candidateRepository.findById(idCandidate).orElseThrow(() ->{ throw new UserNotFoundException();});
        this.jobRepository.findById(idJob).orElseThrow(() ->{ throw new JobNotFoundException();});
        
    }
}
