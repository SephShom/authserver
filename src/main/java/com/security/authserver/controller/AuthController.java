package com.security.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.authserver.dto.CreateUserDto;
import com.security.authserver.dto.MessageDto;
import com.security.authserver.service.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
  
  @Autowired UserService userService;

  @PostMapping(value = "/save-user")  
  public ResponseEntity<MessageDto> createUser(@RequestBody CreateUserDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
  }

  @PostMapping(value = "/hola")  
  public void holaUser() {
    System.out.println("hello");
  }
}
