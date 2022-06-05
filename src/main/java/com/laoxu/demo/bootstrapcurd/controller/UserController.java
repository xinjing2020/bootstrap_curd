package com.laoxu.demo.bootstrapcurd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laoxu.demo.bootstrapcurd.common.Result;
import com.laoxu.demo.bootstrapcurd.common.ResultUtil;
import com.laoxu.demo.bootstrapcurd.model.User;
import com.laoxu.demo.bootstrapcurd.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wangxiaobo
 * @create: 2022-05-11 15:26
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String user(){
        return "user";
    }

    /**
     * 分页查询
     * @param username
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public Result<IPage<User>> list(@RequestParam(value = "username", required = false) String username,
                                    @RequestParam(defaultValue = "1") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize){

        // 构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<> ();
        if (!StringUtils.isEmpty(username)){
            queryWrapper.like("username",username);
            queryWrapper.orderByDesc("create_time");
        }

        Page<User> page  = new Page<> (pageNo, pageSize);
        IPage<User> result  = userService.page(page, queryWrapper);
        // 设置总记录数
        result.setTotal (userService.count(queryWrapper));

        return ResultUtil.ok(result);
    }

}
