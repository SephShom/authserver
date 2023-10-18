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

import com.security.authserver.model.GoogleUser;
import com.security.authserver.repository.GoogleUserRepository;

@Service
public class GoogleUserDao {
  
  @Autowired GoogleUserRepository googleUserRepository;

  public long count() {
    return googleUserRepository.count();
  }

  public <S extends GoogleUser> long count(Example<S> example) {
    return googleUserRepository.count(example);
  }

  public void delete(GoogleUser entity) {
    googleUserRepository.delete(entity);
  }

  public void deleteAll() {
    googleUserRepository.deleteAll();
  }

  public void deleteAll(Iterable<? extends GoogleUser> entities) {
    googleUserRepository.deleteAll(entities);
  }

  public void deleteAllById(Iterable<? extends UUID> ids) {
    googleUserRepository.deleteAllById(ids);
  }

  public void deleteAllByIdInBatch(Iterable<UUID> ids) {
    googleUserRepository.deleteAllByIdInBatch(ids);
  }

  public void deleteAllInBatch() {
    googleUserRepository.deleteAllInBatch();
  }

  public void deleteAllInBatch(Iterable<GoogleUser> entities) {
    googleUserRepository.deleteAllInBatch(entities);
  }

  public void deleteById(UUID id) {
    googleUserRepository.deleteById(id);
  }

  public <S extends GoogleUser> boolean exists(Example<S> example) {
    return googleUserRepository.exists(example);
  }

  public boolean existsById(UUID id) {
    return googleUserRepository.existsById(id);
  }

  public <S extends GoogleUser> List<S> findAll(Example<S> example) {
    return googleUserRepository.findAll(example);
  }

  public <S extends GoogleUser> List<S> findAll(Example<S> example, Sort sort) {
    return googleUserRepository.findAll(example, sort);
  }

  public List<GoogleUser> findAll() {
    return googleUserRepository.findAll();
  }

  public List<GoogleUser> findAll(Sort sort) {
    return googleUserRepository.findAll(sort);
  }

  public Page<GoogleUser> findAll(Pageable pageable) {
    return googleUserRepository.findAll(pageable);
  }

  public <S extends GoogleUser> Page<S> findAll(Example<S> example, Pageable pageable) {
    return googleUserRepository.findAll(example, pageable);
  }

  public List<GoogleUser> findAllById(Iterable<UUID> ids) {
    return googleUserRepository.findAllById(ids);
  }

  public <S extends GoogleUser, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    return googleUserRepository.findBy(example, queryFunction);
  }

  public Optional<GoogleUser> findByEmail(String email) {
    return googleUserRepository.findByEmail(email);
  }

  public Optional<GoogleUser> findById(UUID id) {
    return googleUserRepository.findById(id);
  }

  public <S extends GoogleUser> Optional<S> findOne(Example<S> example) {
    return googleUserRepository.findOne(example);
  }

  public void flush() {
    googleUserRepository.flush();
  }

  public GoogleUser getReferenceById(UUID id) {
    return googleUserRepository.getReferenceById(id);
  }

  public <S extends GoogleUser> S save(S entity) {
    return googleUserRepository.save(entity);
  }

  public <S extends GoogleUser> List<S> saveAll(Iterable<S> entities) {
    return googleUserRepository.saveAll(entities);
  }

  public <S extends GoogleUser> List<S> saveAllAndFlush(Iterable<S> entities) {
    return googleUserRepository.saveAllAndFlush(entities);
  }

  public <S extends GoogleUser> S saveAndFlush(S entity) {
    return googleUserRepository.saveAndFlush(entity);
  }
  
}
