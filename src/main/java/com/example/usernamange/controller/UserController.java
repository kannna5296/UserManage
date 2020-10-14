package com.example.usernamange.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    final
    JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/")
    String index(Model model) {
        List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from sample.users");
        model.addAttribute("title", "ユーザー一覧");
        model.addAttribute("users", users);
        return "index";
    }
}