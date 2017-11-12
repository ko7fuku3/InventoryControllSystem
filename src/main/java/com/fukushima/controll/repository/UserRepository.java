package com.fukushima.controll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fukushima.controll.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
