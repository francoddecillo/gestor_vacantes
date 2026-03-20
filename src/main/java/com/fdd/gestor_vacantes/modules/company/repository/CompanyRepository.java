package com.fdd.gestor_vacantes.modules.company.repository;

import com.fdd.gestor_vacantes.modules.candidate.entity.CandidateEntity;
import com.fdd.gestor_vacantes.modules.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository <CompanyEntity, UUID>{
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
}
