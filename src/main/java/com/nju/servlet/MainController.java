package com.nju.servlet;


import java.util.ArrayList;
import java.util.List;

import com.nju.entity.User;
import com.nju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by mark on 4/24/15.
 */

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
/*	@RequestMapping("")
	public String home() {
		List<User> us = new ArrayList<User>();
		User u = new User();
		u.setUsername("Hello");
		us.add(u);
		u = new User();
		u.setUsername("World");
		us.add(u);
		userService.saveUsers(us);
		return "index";
	}

	@RequestMapping("/json")
	@ResponseBody
	public List<User> json() {
		return userService.getAllUsernames();
	}*/

}
