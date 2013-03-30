package com.thinkgem.jeesite.modules.top.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.thinkgem.jeesite.modules.top.entity.TopUser;

/**
 * top用户DAO接口
 * @author lay
 * @version 2013-03-22
 */
public interface TopUserDao extends TopUserDaoCustom, CrudRepository<TopUser, Long> {

}

/**
 * DAO自定义接口
 * @author lay
 */
interface TopUserDaoCustom extends BaseDao<TopUser> {

}

/**
 * DAO自定义接口实现
 * @author lay
 */
@Component
class TopUserDaoImpl extends BaseDaoImpl<TopUser> implements TopUserDaoCustom {

}
