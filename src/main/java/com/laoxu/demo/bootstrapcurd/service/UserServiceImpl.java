package com.laoxu.demo.bootstrapcurd.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laoxu.demo.bootstrapcurd.mapper.UserMapper;
import com.laoxu.demo.bootstrapcurd.model.User;
import org.springframework.stereotype.Service;

/**
 * @author: wangxiaobo
 * @create: 2022-05-11 09:52
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
