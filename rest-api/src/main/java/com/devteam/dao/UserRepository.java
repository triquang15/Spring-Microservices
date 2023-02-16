package com.devteam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devteam.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
