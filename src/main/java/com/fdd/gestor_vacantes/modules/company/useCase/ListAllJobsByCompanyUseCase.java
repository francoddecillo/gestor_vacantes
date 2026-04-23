package com.fdd.gestor_vacantes.modules.company.useCase;

import com.fdd.gestor_vacantes.modules.company.entity.JobEntity;
import com.fdd.gestor_vacantes.modules.company.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListAllJobsByCompanyUseCase {
    private final JobRepository jobRepository;

    public ListAllJobsByCompanyUseCase(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobEntity> execute(UUID companyId){
        return this.jobRepository.findByCompanyId(companyId);
    }
}