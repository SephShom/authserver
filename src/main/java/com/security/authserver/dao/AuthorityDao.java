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

import com.security.authserver.enums.RoleName;
import com.security.authserver.model.Authority;
import com.security.authserver.repository.AuthorityRepository;

@Service
public class AuthorityDao {
  
  @Autowired AuthorityRepository authorityRepository;

  public long count() {
    return authorityRepository.count();
  }

  public <S extends Authority> long count(Example<S> example) {
    return authorityRepository.count(example);
  }

  public void delete(Authority entity) {
    authorityRepository.delete(entity);
  }

  public void deleteAll() {
    authorityRepository.deleteAll();
  }

  public void deleteAll(Iterable<? extends Authority> entities) {
    authorityRepository.deleteAll(entities);
  }

  public void deleteAllById(Iterable<? extends UUID> ids) {
    authorityRepository.deleteAllById(ids);
  }

  public void deleteAllByIdInBatch(Iterable<UUID> ids) {
    authorityRepository.deleteAllByIdInBatch(ids);
  }

  public void deleteAllInBatch() {
    authorityRepository.deleteAllInBatch();
  }

  public void deleteAllInBatch(Iterable<Authority> entities) {
    authorityRepository.deleteAllInBatch(entities);
  }

  public void deleteById(UUID id) {
    authorityRepository.deleteById(id);
  }

  public <S extends Authority> boolean exists(Example<S> example) {
    return authorityRepository.exists(example);
  }

  public boolean existsById(UUID id) {
    return authorityRepository.existsById(id);
  }

  public <S extends Authority> List<S> findAll(Example<S> example) {
    return authorityRepository.findAll(example);
  }

  public <S extends Authority> List<S> findAll(Example<S> example, Sort sort) {
    return authorityRepository.findAll(example, sort);
  }

  public List<Authority> findAll() {
    return authorityRepository.findAll();
  }

  public List<Authority> findAll(Sort sort) {
    return authorityRepository.findAll(sort);
  }

  public Page<Authority> findAll(Pageable pageable) {
    return authorityRepository.findAll(pageable);
  }

  public <S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable) {
    return authorityRepository.findAll(example, pageable);
  }

  public List<Authority> findAllById(Iterable<UUID> ids) {
    return authorityRepository.findAllById(ids);
  }

  public <S extends Authority, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    return authorityRepository.findBy(example, queryFunction);
  }

  public Optional<Authority> findById(UUID id) {
    return authorityRepository.findById(id);
  }

  public Optional<Authority> findByRole(RoleName roleName) {
    return authorityRepository.findByRole(roleName);
  }

  public <S extends Authority> Optional<S> findOne(Example<S> example) {
    return authorityRepository.findOne(example);
  }

  public void flush() {
    authorityRepository.flush();
  }

  public Authority getReferenceById(UUID id) {
    return authorityRepository.getReferenceById(id);
  }

  public <S extends Authority> S save(S entity) {
    return authorityRepository.save(entity);
  }

  public <S extends Authority> List<S> saveAll(Iterable<S> entities) {
    return authorityRepository.saveAll(entities);
  }

  public <S extends Authority> List<S> saveAllAndFlush(Iterable<S> entities) {
    return authorityRepository.saveAllAndFlush(entities);
  }

  public <S extends Authority> S saveAndFlush(S entity) {
    return authorityRepository.saveAndFlush(entity);
  }

  
}
