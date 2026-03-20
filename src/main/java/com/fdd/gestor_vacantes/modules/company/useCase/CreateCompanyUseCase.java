package com.fdd.gestor_vacantes.modules.company.useCase;

import com.fdd.gestor_vacantes.modules.candidate.exception.UserFoundException;
import com.fdd.gestor_vacantes.modules.company.entity.CompanyEntity;
import com.fdd.gestor_vacantes.modules.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {


    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute (CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(),companyEntity.getEmail())
                .ifPresent((user) ->{
                    throw new UserFoundException();
                });
        return this.companyRepository.save(companyEntity);
    }
}
