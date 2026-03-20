package com.fdd.gestor_vacantes.modules.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fdd.gestor_vacantes.modules.candidate.entity.CandidateEntity;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
