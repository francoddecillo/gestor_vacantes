package com.fdd.gestor_vacantes.modules.company.useCase;


import com.fdd.gestor_vacantes.modules.company.entity.JobEntity;
import com.fdd.gestor_vacantes.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute (JobEntity jobEntity){
        return this.jobRepository.save(jobEntity);

    }

}
