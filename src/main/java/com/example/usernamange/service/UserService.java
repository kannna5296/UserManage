package com.example.usernamange.service;

import com.example.usernamange.entity.User;
import com.example.usernamange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {

    /**
     * ユーザー情報 Repository
     */
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        // ユーザーTBLの内容を全検索
        return userRepository.findAll();
    }
}
