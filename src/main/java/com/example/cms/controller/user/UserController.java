package com.example.cms.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/join")
    public String join() {
        return "/user/joinForm";
    }

    @GetMapping("/login")
    public String login() {
        return "/user/loginForm";
    }

    @GetMapping("/edit")
    public String edit() {
        return "/user/editUserForm";
    }

    @GetMapping("/mypage")
    public String mypage() {
        return "/user/mypage";
    }

    @GetMapping("/users")
    public String users() {
        return "/user/userlist";
    }

    @GetMapping("/leave")
    public String leave() {
        return "/user/leaveForm";
    }
}
