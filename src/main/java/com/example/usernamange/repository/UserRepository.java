package com.example.usernamange.repository;

import com.example.usernamange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報 Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
