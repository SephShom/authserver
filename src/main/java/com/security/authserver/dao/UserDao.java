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

import com.security.authserver.model.User;
import com.security.authserver.repository.UserRepository;

@Service
public class UserDao {
  
  @Autowired UserRepository userRepository;

  public long count() {
    return userRepository.count();
  }

  public <S extends User> long count(Example<S> example) {
    return userRepository.count(example);
  }

  public void delete(User entity) {
    userRepository.delete(entity);
  }

  public void deleteAll() {
    userRepository.deleteAll();
  }

  public void deleteAll(Iterable<? extends User> entities) {
    userRepository.deleteAll(entities);
  }

  public void deleteAllById(Iterable<? extends UUID> ids) {
    userRepository.deleteAllById(ids);
  }

  public void deleteAllByIdInBatch(Iterable<UUID> ids) {
    userRepository.deleteAllByIdInBatch(ids);
  }

  public void deleteAllInBatch() {
    userRepository.deleteAllInBatch();
  }

  public void deleteAllInBatch(Iterable<User> entities) {
    userRepository.deleteAllInBatch(entities);
  }

  public void deleteById(UUID id) {
    userRepository.deleteById(id);
  }

  public <S extends User> boolean exists(Example<S> example) {
    return userRepository.exists(example);
  }

  public boolean existsById(UUID id) {
    return userRepository.existsById(id);
  }

  public <S extends User> List<S> findAll(Example<S> example) {
    return userRepository.findAll(example);
  }

  public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
    return userRepository.findAll(example, sort);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public List<User> findAll(Sort sort) {
    return userRepository.findAll(sort);
  }

  public Page<User> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
    return userRepository.findAll(example, pageable);
  }

  public List<User> findAllById(Iterable<UUID> ids) {
    return userRepository.findAllById(ids);
  }

  public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    return userRepository.findBy(example, queryFunction);
  }

  public Optional<User> findById(UUID id) {
    return userRepository.findById(id);
  }

  public Optional<User> findByUsername(String name) {
    return userRepository.findByUsername(name);
  }

  public <S extends User> Optional<S> findOne(Example<S> example) {
    return userRepository.findOne(example);
  }

  public void flush() {
    userRepository.flush();
  }

  public User getReferenceById(UUID id) {
    return userRepository.getReferenceById(id);
  }

  public <S extends User> S save(S entity) {
    return userRepository.save(entity);
  }

  public <S extends User> List<S> saveAll(Iterable<S> entities) {
    return userRepository.saveAll(entities);
  }

  public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
    return userRepository.saveAllAndFlush(entities);
  }

  public <S extends User> S saveAndFlush(S entity) {
    return userRepository.saveAndFlush(entity);
  }
  
}
