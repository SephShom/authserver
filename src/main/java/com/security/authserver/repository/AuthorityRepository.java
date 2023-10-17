package com.security.authserver.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.authserver.enums.RoleName;
import com.security.authserver.model.Authority;

@Repository
public interface AuthorityRepository  extends JpaRepository<Authority, UUID> {
  
  Optional<Authority> findByRole(RoleName roleName);
}
