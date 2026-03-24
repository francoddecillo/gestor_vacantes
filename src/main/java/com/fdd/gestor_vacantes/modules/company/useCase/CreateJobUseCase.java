package com.fdd.gestor_vacantes.modules.company.useCase;

import com.fdd.gestor_vacantes.modules.company.entity.JobEntity;
import com.fdd.gestor_vacantes.modules.company.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    private final JobRepository jobRepository;

    public CreateJobUseCase(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}