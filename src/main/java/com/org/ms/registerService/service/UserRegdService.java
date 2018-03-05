package com.org.ms.registerService.service;

import java.util.List;

import com.org.ms.registerService.bean.UserBean;

public interface UserRegdService {
	public void createUser(UserBean userBean);

	public List<UserBean> listofAlluser();

	public void deleteuser(UserBean userBean);

	public UserBean gerUserByid(int  userId);
	public void updateUser(UserBean userBean);
}
