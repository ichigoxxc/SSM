package com.itheima.springmvc.service;

import java.util.Date;
import java.util.List;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 查询商品信息
 * @author lx
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;

    public ItemsMapper getItemsMapper() {
        return itemsMapper;
    }

    public void setItemsMapper(ItemsMapper itemsMapper) {
        this.itemsMapper = itemsMapper;
    }

    //查询商品列表
	public List<Items> selectItemsList(){
		return itemsMapper.selectAll();
	}

    //查询商品列表
    public List<Items> selectItemsList(ItemsMapper target){
        return target.selectAll();
    }
	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}
	//修改
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
