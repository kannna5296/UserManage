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
     * ユーザー情報新規作成画面を表示
     * @param model Model
     * @return ユーザー情報新規作成画面のHTML
     */
    @GetMapping("new")
    public String newUser(Model model) {
        return "user/new";
    }

    /**
     * ユーザー情報新規作成実行
     * @param user User
     * @return ユーザー情報一覧画面のHTMLへのリダイレクト
     */
    @PostMapping
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user";
    }

    /**
     * ユーザー情報編集画面を表示
     * @param model Model
     * @param id ユーザID
     * @return ユーザー情報編集画面のHTML
     */
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    /**
     * ユーザー情報詳細画面を表示
     * @param model Model
     * @param id ユーザID
     * @return ユーザー情報詳細画面のHTML
     */
    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user/show";
    }

    /**
     * ユーザー情報編集を実行
     * @param user User
     * @param id ユーザID
     * @return ユーザー情報一覧画面のHTMLへのリダイレクト
     */
    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userService.save(user);
        return "redirect:/user";
    }

    /**
     * ユーザー情報削除を実行
     * @param id ユーザID
     * @return ユーザー情報一覧画面のHTMLへのリダイレクト
     */
    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/user";
    }
}