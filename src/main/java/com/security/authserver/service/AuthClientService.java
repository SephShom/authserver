package com.security.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import com.security.authserver.dao.AuthClientDao;
import com.security.authserver.dto.CreateAuthClientDto;
import com.security.authserver.dto.MessageDto;
import com.security.authserver.model.AuthClient;

@Service
public class AuthClientService implements RegisteredClientRepository {
  
  @Autowired AuthClientDao authClientDao;
  @Autowired PasswordEncoder passwordEncoder;

  private AuthClient clientFromDto(CreateAuthClientDto dto) {
    AuthClient client = new AuthClient();
    client.setClientId(dto.getClientId());
    client.setClientSecret(passwordEncoder.encode(dto.getClientSecret()));
    client.setAuthenticationMethods(dto.getAuthenticationMethods());
    client.setAuthorizationGrandTypes(dto.getAuthorizationGrandTypes());
    client.setRedirectUris(dto.getRedirectUris());
    client.setScopes(dto.getScopes());    
    client.setRequireProofKey(dto.isRequireProofKey());

    return client;
  }

  @Override
  public void save(RegisteredClient registeredClient) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public RegisteredClient findById(String id) {
    AuthClient client = authClientDao.findByClientId(id)
      .orElseThrow(() -> new RuntimeException("client not found"));
    return AuthClient.toRegisteredClient(client);
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
     AuthClient client = authClientDao.findByClientId(clientId)
      .orElseThrow(() -> new RuntimeException("client not found"));
    return AuthClient.toRegisteredClient(client);
  }

  public MessageDto create(CreateAuthClientDto dto) {
    AuthClient client = clientFromDto(dto);
    authClientDao.save(client);
    return new MessageDto("client " + client.getClientId() +  "created");
  }
}
