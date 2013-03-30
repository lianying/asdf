package com.thinkgem.jeesite.modules.top.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.top.dao.ItemDao;
import com.thinkgem.jeesite.modules.top.entity.Item;

/**
 * 淘宝商品Service
 * @author lay
 * @version 2013-03-18
 */
@Component
@Transactional(readOnly = true)
public class ItemService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	private ItemDao itemDao;
	
	public Item get(Long id) {
		return itemDao.findOne(id);
	}
	
	
//	public Page<Item> find(Page<Item> page, Item item) {
//		DetachedCriteria dc = itemDao.createDetachedCriteria();
//		if (item.getUser()!=null && item.getUser().getId()>0){
//			dc.add(Restrictions.eq("user.id", item.getUser().getId()));
//		}
//		if (StringUtils.isNotEmpty(item.getName())){
//			dc.add(Restrictions.like("name", "%"+item.getName()+"%"));
//		}
//		if (StringUtils.isNotEmpty(item.getRemarks())){
//			dc.add(Restrictions.like("remarks", "%"+item.getRemarks()+"%"));
//		}
//		dc.add(Restrictions.eq("delFlag", Item.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.desc("id"));
//		return itemDao.find(page, dc);
//	}
	
	@Transactional(readOnly = false)
	public void save(Item item) {
		itemDao.save(item);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		itemDao.deleteById(id);
	}
	
}
