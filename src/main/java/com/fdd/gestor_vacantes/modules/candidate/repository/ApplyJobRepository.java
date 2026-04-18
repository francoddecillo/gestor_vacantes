package com.fdd.gestor_vacantes.modules.candidate.repository;

import com.fdd.gestor_vacantes.modules.candidate.entity.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {

}