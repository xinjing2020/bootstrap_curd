package com.laoxu.demo.bootstrapcurd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laoxu.demo.bootstrapcurd.model.User;
import com.laoxu.demo.bootstrapcurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wangxiaobo
 * @create: 2022-05-11 08:18
 **/
@Controller
@RequestMapping()
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "login";
    }



    @Autowired
    UserService userService;


    @PostMapping("/doLogin")
    public String login(@RequestParam String username, @RequestParam String password,
                        Model model, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse){

        QueryWrapper<User> param = new QueryWrapper<> ();
        param.eq("username",username);
        User user = (User) userService.getObj (param);
        // 未找到用户
        if (user==null){
            model.addAttribute("error","用户不存在");
            return "login";
        }
        if (!password.equals(user.getPassword())){
            model.addAttribute("error","密码错误");
            return "login";
        }
        model.addAttribute("username",username);
        httpServletRequest.getSession().setAttribute("user",user);
        return "index";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute ("user");
        return "login";
    }



}
