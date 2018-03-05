package com.org.ms.registerService.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.ms.registerService.bean.UserBean;
import com.org.ms.registerService.exception.UserNotFoundException;
import com.org.ms.registerService.service.UserRegdService;

@RestController
public class UserRegdController {
	@Autowired
	private UserRegdService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody UserBean userBean) {
		try {
			userService.createUser(userBean);
			return new ResponseEntity<>("User Sucessfully created ", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserBean> getAllUser() {
		return userService.listofAlluser();
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteuser(@PathVariable("userId") int userId) {

		UserBean userBean = userService.gerUserByid(userId);
		if (userBean == null || userBean.equals("")) {
			throw new UserNotFoundException("User Id-" + userId + "is not exist");
		}
		userService.deleteuser(userBean);
		String message = "User id " + userId + " Deleted sucessfully";

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateUser/{id}/{name}/{age}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@PathVariable("id") int userId, @PathVariable("name") String name,
			@PathVariable("age") int age) {
		UserBean userBean = userService.gerUserByid(userId);
		userBean.setAge(age);
		userBean.setName(name);
		if (userBean == null || userBean.equals("")) {
			throw new UserNotFoundException("User Id-" + userId + "is not exist");
		}
		userService.updateUser(userBean);
		return new ResponseEntity<>("user is updated Successfully!!", HttpStatus.OK);
		
	}
}
