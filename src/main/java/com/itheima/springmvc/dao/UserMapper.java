package com.itheima.springmvc.dao;

import com.itheima.springmvc.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}