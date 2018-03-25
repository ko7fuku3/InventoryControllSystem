package com.fukushima.controll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fukushima.controll.entity.User;

/**
 * ユーザーのRepository.
 * @author koshiro
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * ユーザ情報検索.
	 * 
	 * @param userName ユーザ名
	 * @return ユーザー情報
	 */
	@Query(value = "SELECT id, user_name, password, created FROM User WHERE user_name = :userName", nativeQuery = true)
	List<User> findUser(@Param("userName") String userName);
}
