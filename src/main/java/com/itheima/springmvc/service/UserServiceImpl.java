package com.itheima.springmvc.service;

import com.itheima.springmvc.dao.UserMapper;
import com.itheima.springmvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findByname(String username){
            List<User> list = userMapper.selectByUsername(username);
            return list;
    }
}
