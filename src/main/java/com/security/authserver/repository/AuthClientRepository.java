package com.security.authserver.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.authserver.model.AuthClient;

@Repository
public interface AuthClientRepository extends JpaRepository<AuthClient, UUID> {
  
  Optional<AuthClient> findByClientId(String clientId);
}
