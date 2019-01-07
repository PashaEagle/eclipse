package com.app.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.model.UserDetails;

public interface UserDao extends CrudRepository<UserDetails, Long> {

	UserDetails findByEmail(String email);
}
