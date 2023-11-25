package com.cg.firstjpaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.firstjpaproject.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
