package com.itheima.springmvc.service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;

import java.util.List;

public interface ItemService {
	
	//查询商品列表
	public List<Items> selectItemsList();
	//查询商品列表
	public List<Items> selectItemsList(ItemsMapper itemsMapper);
	public Items selectItemsById(Integer id);
	
	
	//修改
	public void updateItemsById(Items items);

}
