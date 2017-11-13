package com.fukushima.controll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fukushima.controll.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT id, user_name, password, created FROM User WHERE user_name = :userName", nativeQuery = true)
	List<User> findUser(@Param("userName") String userName);
}
