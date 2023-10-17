package com.security.authserver.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AuthClient {
  
  @Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "auth_client_id")
	private UUID id;

  private String clientId;

  private String clientSecret;

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<ClientAuthenticationMethod> authenticationMethods;

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<AuthorizationGrantType> authorizationGrandTypes;

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<String> redirectUris;

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<String> scopes;

  private boolean requireProofKey;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public Set<ClientAuthenticationMethod> getAuthenticationMethods() {
    return authenticationMethods;
  }

  public void setAuthenticationMethods(Set<ClientAuthenticationMethod> authenticationMethods) {
    this.authenticationMethods = authenticationMethods;
  }

  public Set<AuthorizationGrantType> getAuthorizationGrandTypes() {
    return authorizationGrandTypes;
  }

  public void setAuthorizationGrandTypes(Set<AuthorizationGrantType> authorizationGrandTypes) {
    this.authorizationGrandTypes = authorizationGrandTypes;
  }

  public Set<String> getRedirectUris() {
    return redirectUris;
  }

  public void setRedirectUris(Set<String> redirectUris) {
    this.redirectUris = redirectUris;
  }

  public Set<String> getScopes() {
    return scopes;
  }

  public void setScopes(Set<String> scopes) {
    this.scopes = scopes;
  }

  public boolean isRequireProofKey() {
    return requireProofKey;
  }

  public void setRequireProofKey(boolean requireProofKey) {
    this.requireProofKey = requireProofKey;
  }

  public static RegisteredClient toRegisteredClient(AuthClient client) {
    RegisteredClient.Builder builder = RegisteredClient.withId(client.getClientId())
      .clientId(client.getClientId())
      .clientSecret(client.getClientSecret())
      .clientIdIssuedAt(new Date().toInstant())
      .clientAuthenticationMethods(am -> am.addAll(client.getAuthenticationMethods()))
      .authorizationGrantTypes(agt -> agt.addAll(client.getAuthorizationGrandTypes()))
      .redirectUris(ru -> ru.addAll(client.getRedirectUris()))
      .scopes(s -> s.addAll(client.getScopes()))
      .clientSettings(ClientSettings.builder().requireProofKey(client.isRequireProofKey()).build());
    
    return builder.build();
  }
}
