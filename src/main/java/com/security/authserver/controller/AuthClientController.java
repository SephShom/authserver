package com.security.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.authserver.dto.CreateAuthClientDto;
import com.security.authserver.dto.MessageDto;
import com.security.authserver.service.AuthClientService;

@RestController
@RequestMapping(value = "oclient")
public class AuthClientController {
  

  @Autowired AuthClientService authClientService;

  @PostMapping(value = "save")
  public ResponseEntity<MessageDto> create(@RequestBody CreateAuthClientDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(authClientService.create(dto));
  }
}
