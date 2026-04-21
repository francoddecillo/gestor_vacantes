package com.fdd.gestor_vacantes.modules.company.useCase;
import com.fdd.gestor_vacantes.modules.company.repository.CompanyRepository;
import com.fdd.gestor_vacantes.modules.company.entity.JobEntity;
import com.fdd.gestor_vacantes.modules.company.repository.JobRepository;
import com.fdd.gestor_vacantes.modules.exception.CompanyNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public CreateJobUseCase(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}