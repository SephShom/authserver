package com.security.authserver.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.authserver.dao.AuthorityDao;
import com.security.authserver.dao.UserDao;
import com.security.authserver.dto.CreateUserDto;
import com.security.authserver.dto.MessageDto;
import com.security.authserver.enums.RoleName;
import com.security.authserver.model.Authority;
import com.security.authserver.model.User;

@Service
public class UserService {
  
  @Autowired UserDao userDao;
  @Autowired AuthorityDao authorityDao;
  @Autowired PasswordEncoder passwordEncoder;

  public MessageDto createUser(CreateUserDto dto) {
    User user = new User();
    user.setUsername(dto.username());
    user.setPassword(passwordEncoder.encode(dto.password()));

    Set<Authority> roles = new HashSet<>();
    dto.roles().forEach(r -> {
      Authority role = authorityDao.findByRole(RoleName.valueOf(r))
        .orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(role);
    });

    user.setRoles(roles);
    userDao.save(user);
   
    return new MessageDto("user " + user.getUsername() + " saved");
  }
}
