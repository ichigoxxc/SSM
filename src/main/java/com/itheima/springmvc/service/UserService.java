package com.itheima.springmvc.service;

import com.itheima.springmvc.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public List<User> findByname(String username);
}
