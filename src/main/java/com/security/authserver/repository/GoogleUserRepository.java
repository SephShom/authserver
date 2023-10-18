package com.security.authserver.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.authserver.model.GoogleUser;

@Repository
public interface GoogleUserRepository extends JpaRepository<GoogleUser, UUID> {
  
  Optional<GoogleUser> findByEmail(String email);
}
