package com.example.usernamange.controller;

import com.example.usernamange.entity.User;
import com.example.usernamange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayList(Model model) {
        List<User> userlist = userService.searchAll();
        model.addAttribute("title", "ユーザ一覧");
        model.addAttribute("userlist", userlist);
        return "index";
    }

    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面のHTML
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("title", "新規作成");
        return "create";
    }
}