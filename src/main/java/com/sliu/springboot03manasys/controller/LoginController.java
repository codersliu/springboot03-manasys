package com.sliu.springboot03manasys.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        if(!StringUtils.isEmpty(username)&&password.equals("123456")){
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }

    }

    @RequestMapping("/user/signout")
    public String signout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
