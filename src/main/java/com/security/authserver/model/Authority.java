package com.security.authserver.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import com.security.authserver.enums.RoleName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "s_authority")
public class Authority implements GrantedAuthority{
  
  @Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "authority_id")
	private UUID id;

  @Enumerated(EnumType.STRING)
  private RoleName role;

  @Override
  public String getAuthority() {    
    return role.name();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public RoleName getRole() {
    return role;
  }

  public void setRole(RoleName role) {
    this.role = role;
  }

  
}
