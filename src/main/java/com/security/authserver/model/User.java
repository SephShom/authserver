package com.security.authserver.model;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "s_user")
public class User implements UserDetails {
  
  @Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "user_id")
	private UUID id;

  @Nationalized
	@Column(name = "username", length = 254, unique = true)
	private String username;
	
	@Size(min = 5, max = 60)
	@Column(name = "password", length = 60)
	private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="s_user_authority", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
  private Set<Authority> roles;

  @Column(name = "account_non_expired")
	private boolean accountNonExpired;
	
	@Column(name = "account_non_blocked")
	private boolean accountNonLocked;
	
	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;

  @Column(name = "enabled")
	private boolean enabled;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Authority> getRoles() {
    return roles;
  }

  public void setRoles(Set<Authority> roles) {
    this.roles = roles;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
