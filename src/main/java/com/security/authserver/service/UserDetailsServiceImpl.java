package com.security.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.authserver.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

  @Autowired UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userDao.findByUsername(username)
    .orElseThrow(() -> new RuntimeException("User not found"));
  }
  
}
