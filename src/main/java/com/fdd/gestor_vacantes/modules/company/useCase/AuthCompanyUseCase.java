package com.fdd.gestor_vacantes.modules.company.useCase;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fdd.gestor_vacantes.modules.company.dto.AuthCompanyRequestDTO;
import com.fdd.gestor_vacantes.modules.company.dto.AuthCompanyResponseDTO;
import com.fdd.gestor_vacantes.modules.company.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret.company}")
    private String secretKey;

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthCompanyUseCase(CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthCompanyResponseDTO execute(AuthCompanyRequestDTO authCompanyRequestDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyRequestDTO.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/password incorrect");
        });

        var passwordMatches = this.passwordEncoder.matches(authCompanyRequestDTO.getPassword(), company.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create().withIssuer("javacantes")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(company.getId().toString()).withExpiresAt(expiresIn).withClaim("roles", Arrays.asList("COMPANY")).sign(algorithm);
        var roles = Arrays.asList("COMPANY");
        var authCompanyResponseDTO = AuthCompanyResponseDTO.builder()
                .access_token(token).expires_in(expiresIn.toEpochMilli()).roles(roles).build();
        return authCompanyResponseDTO;
    }
}
