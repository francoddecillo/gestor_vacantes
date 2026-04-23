package com.fdd.gestor_vacantes.modules.company.repository;

import com.fdd.gestor_vacantes.modules.company.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    List<JobEntity> findByDescriptionContainingIgnoreCase(String title);
    List<JobEntity> findByCompanyId(UUID companyId);
}
