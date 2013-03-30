package com.thinkgem.jeesite.modules.top.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.thinkgem.jeesite.modules.top.entity.Item;

/**
 * 淘宝商品DAO接口
 * @author lay
 * @version 2013-03-18
 */
public interface ItemDao extends ItemDaoCustom, CrudRepository<Item, Long> {

	@Modifying
	@Query("update Item set delFlag='" + Item.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
	public List<Item> findByNick(String nick);
	
}

/**
 * DAO自定义接口
 * @author lay
 */
interface ItemDaoCustom extends BaseDao<Item> {

}

/**
 * DAO自定义接口实现
 * @author lay
 */
@Component
class ItemDaoImpl extends BaseDaoImpl<Item> implements ItemDaoCustom {

}
