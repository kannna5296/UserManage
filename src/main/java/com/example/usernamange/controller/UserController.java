package com.example.usernamange.controller;

import com.example.usernamange.entity.User;
import com.example.usernamange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * ユーザー情報 Service
     */
    @Autowired
    UserService userService;


    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面のHTML
     */
    @GetMapping
    public String index(Model model) {
        List<User> userlist = userService.findAll();
        model.addAttribute("userlist", userlist);
        return "user/index";
    }

    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面のHTML
     */
    @GetMapping("new")
    public String newUser(Model model) {
        return "user/new";
    }

    @PostMapping
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user";
    }


    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "players/edit";
    }
}