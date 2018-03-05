package com.org.ms.registerService.dao;

import java.util.List;

import com.org.ms.registerService.bean.UserBean;

public interface UserRegdDao {
	public void createUser(UserBean userBean);

	public List<UserBean> listofAlluser();

	public void deleteuser(UserBean userBean );

	public UserBean getuseById(int id);
	public void updateUser(UserBean userBean);
}
