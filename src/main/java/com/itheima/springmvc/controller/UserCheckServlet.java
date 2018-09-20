package com.itheima.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.User;
import com.itheima.springmvc.service.*;

import com.itheima.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/*
*  20180919 问题servlet自动注入失败
*/
public class UserCheckServlet extends HttpServlet{


    @Autowired
    private ItemService itemService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                this.getServletContext());
    }


    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{

        //0-编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //1-获得用户名
        String username = request.getParameter("username");
        //2-查询是否存在，这里会有个问题，就是new A , A 中的B是Autowired
        List<Items> list = itemService.selectItemsList();
        String jsonResult = JSON.toJSONString(list);
        response.getWriter().print(jsonResult);

    }

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException {
        doGet(request,response);
    }

    }
