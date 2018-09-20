package com.itheima.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.springmvc.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;

/**
 * 商品管理
 * 
 * @author lx
 * http://localhost:8080/springmvc_day01_mybatis/item/itemlist.action
 */
@Controller
public class ItemController {
	
	
	//信息列表
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList(){
		//从Mysql中查询
		List<Items> list = itemService.selectItemsList();
		
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}


	// 绑定包装数据类型
	// 查询页面
	@RequestMapping("/item/queryitem.action")
	public ModelAndView queryItem(QueryVo queryVo) {
		Integer id = queryVo.getItems().getId();
		List<Items> list = new ArrayList<Items>();
		String name = queryVo.getItems().getName();
		if(null!=id){
			Items items = itemService.selectItemsById(id);
			list.add(items);
		}
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("itemList", list);
		mav.addObject("queryId",id);
		mav.addObject("queryName",name);
		mav.setViewName("itemList");
		return mav;
	}

	//修改详细页面：2种方式 方式一
	@RequestMapping(value = "/itemEdit.action")
	public ModelAndView toEdit(@RequestParam(value = "id",required = false,defaultValue = "1") Integer id,
			HttpServletRequest request,HttpServletResponse response
			,HttpSession session,Model model){

		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;

	}


	//修改详细页面：2种方式 方式二 Servlet时代开发
/*	@RequestMapping(value = "/itemEdit.action")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse response
			,HttpSession session,Model model){

		String id = request.getParameter("id");
		Items items = itemService.selectItemsById(Integer.parseInt(id));
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;

	}*/


	//更新数据
	@RequestMapping(value = "/updateitem.action")
//	public ModelAndView updateitem(Items items){
	public ModelAndView updateitem(QueryVo vo){

		//修改
		itemService.updateItemsById(vo.getItems());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
		
	}
	
}
