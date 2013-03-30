package com.thinkgem.jeesite.modules.top.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.top.dao.TopUserDao;
import com.thinkgem.jeesite.modules.top.entity.TopUser;

/**
 * top用户Service
 * @author lay
 * @version 2013-03-22
 */
@Component
@Transactional(readOnly = true)
public class TopUserService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(TopUserService.class);
	
	@Autowired
	private TopUserDao userDao;
	
	public TopUser get(Long id) {
		return userDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void save(TopUser user) {
		userDao.save(user);
	}
	
}
