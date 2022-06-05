package com.laoxu.demo.bootstrapcurd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wangxiaobo
 * @create: 2022-05-10 21:40
 **/
@Controller
public class MainController {

    @RequestMapping("/list")
    public String list(){

        return "list";
    }
    /**
     * 区分get 和 post请求
     * get：展示页面
     * post：收集数据
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/registers")
    public String register1(){
        return "registers";
    }
}
