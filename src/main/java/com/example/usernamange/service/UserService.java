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

    /**
     * ユーザーtableの内容を全検索
     */
    public List<User> findAll() {
        // ユーザーTBLの内容を全検索
        return userRepository.findAll();
    }

    /**
     * ユーザーtableに1件保存
     */
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * ユーザーtableの内容を1件検索
     */
    public User findOne(Long id) {
        return userRepository.getOne(id);
    }

    /**
     * ユーザーtableの内容を1件削除
     */
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
