package com.itheima.springmvc.dao;

import com.itheima.springmvc.pojo.Items;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    List<Items> selectAll();

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
}