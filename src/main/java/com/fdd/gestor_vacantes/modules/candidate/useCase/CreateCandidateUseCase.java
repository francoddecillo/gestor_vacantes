package com.fdd.gestor_vacantes.modules.candidate.useCase;

import com.fdd.gestor_vacantes.modules.candidate.entity.CandidateEntity;
import com.fdd.gestor_vacantes.modules.candidate.exception.UserFoundException;
import com.fdd.gestor_vacantes.modules.candidate.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public CreateCandidateUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public CandidateEntity execute(CandidateEntity candidateEntity) {

        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}