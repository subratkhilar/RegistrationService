package com.org.ms.registerService.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.ms.registerService.bean.UserBean;
import com.org.ms.registerService.dao.UserRegdDao;

@Service("userService")
public class UserServiceImpl implements UserRegdService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRegdDao userregdDao;

	@Override
	public void createUser(UserBean userBean) {
		userregdDao.createUser(userBean);

	}

	@Override
	public List<UserBean> listofAlluser() {
		logger.info("[ listofAlluser ==== ]");
		/*
		 * UserBean user = new UserBean(); user.setId(1); user.setAge(22);
		 * user.setName("test"); List<UserBean> list = new ArrayList<>();
		 * list.add(user);
		 */
		return userregdDao.listofAlluser();
	}

	@Override
	public void deleteuser(UserBean userBean) {
		userregdDao.deleteuser(userBean);

	}

	@Override
	public UserBean gerUserByid(int userId) {
		return userregdDao.getuseById(userId);
	}

	@Override
	public void updateUser(UserBean userBean) {
		userregdDao.updateUser(userBean);
		
	}

}
