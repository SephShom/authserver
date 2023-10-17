package com.security.authserver.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.security.authserver.model.AuthClient;
import com.security.authserver.repository.AuthClientRepository;

@Service
public class AuthClientDao {
  
  @Autowired AuthClientRepository authClientRepository;

  public long count() {
    return authClientRepository.count();
  }

  public <S extends AuthClient> long count(Example<S> example) {
    return authClientRepository.count(example);
  }

  public void delete(AuthClient entity) {
    authClientRepository.delete(entity);
  }

  public void deleteAll() {
    authClientRepository.deleteAll();
  }

  public void deleteAll(Iterable<? extends AuthClient> entities) {
    authClientRepository.deleteAll(entities);
  }

  public void deleteAllById(Iterable<? extends UUID> ids) {
    authClientRepository.deleteAllById(ids);
  }

  public void deleteAllByIdInBatch(Iterable<UUID> ids) {
    authClientRepository.deleteAllByIdInBatch(ids);
  }

  public void deleteAllInBatch() {
    authClientRepository.deleteAllInBatch();
  }

  public void deleteAllInBatch(Iterable<AuthClient> entities) {
    authClientRepository.deleteAllInBatch(entities);
  }

  public void deleteById(UUID id) {
    authClientRepository.deleteById(id);
  }

  public <S extends AuthClient> boolean exists(Example<S> example) {
    return authClientRepository.exists(example);
  }

  public boolean existsById(UUID id) {
    return authClientRepository.existsById(id);
  }

  public <S extends AuthClient> List<S> findAll(Example<S> example) {
    return authClientRepository.findAll(example);
  }

  public <S extends AuthClient> List<S> findAll(Example<S> example, Sort sort) {
    return authClientRepository.findAll(example, sort);
  }

  public List<AuthClient> findAll() {
    return authClientRepository.findAll();
  }

  public List<AuthClient> findAll(Sort sort) {
    return authClientRepository.findAll(sort);
  }

  public Page<AuthClient> findAll(Pageable pageable) {
    return authClientRepository.findAll(pageable);
  }

  public <S extends AuthClient> Page<S> findAll(Example<S> example, Pageable pageable) {
    return authClientRepository.findAll(example, pageable);
  }

  public List<AuthClient> findAllById(Iterable<UUID> ids) {
    return authClientRepository.findAllById(ids);
  }

  public <S extends AuthClient, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    return authClientRepository.findBy(example, queryFunction);
  }

  public Optional<AuthClient> findByClientId(String clientId) {
    return authClientRepository.findByClientId(clientId);
  }

  public Optional<AuthClient> findById(UUID id) {
    return authClientRepository.findById(id);
  }

  public <S extends AuthClient> Optional<S> findOne(Example<S> example) {
    return authClientRepository.findOne(example);
  }

  public void flush() {
    authClientRepository.flush();
  }

  public AuthClient getReferenceById(UUID id) {
    return authClientRepository.getReferenceById(id);
  }

  public <S extends AuthClient> S save(S entity) {
    return authClientRepository.save(entity);
  }

  public <S extends AuthClient> List<S> saveAll(Iterable<S> entities) {
    return authClientRepository.saveAll(entities);
  }

  public <S extends AuthClient> List<S> saveAllAndFlush(Iterable<S> entities) {
    return authClientRepository.saveAllAndFlush(entities);
  }

  public <S extends AuthClient> S saveAndFlush(S entity) {
    return authClientRepository.saveAndFlush(entity);
  }

  
}
