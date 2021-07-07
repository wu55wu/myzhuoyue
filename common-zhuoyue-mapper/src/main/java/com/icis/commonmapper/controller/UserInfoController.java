package com.icis.commonmapper.controller;

import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody //作用域该类下面所有的方法
@RestController
public class UserInfoController {
	@Autowired
	private IUserInfoService userInfoService;

	//查询所有用户列表
	//@RequestMapping("/getAllUser")
	@GetMapping("/getAllUser")
	public List<UserInfo> findAllUser(){
		return this.userInfoService.findAllUser();
	}

	//根据主键查询一个用户
	@RequestMapping("/getUserByPrimaryKey")
	public UserInfo getUserByPrimaryKey(String uid){
		//查询
		UserInfo userInfo = new UserInfo();
		userInfo.setId(uid);

		return this.userInfoService.findUserByPrimaryKey(userInfo);
	}

	//根据 给出的属性 查询数据
	@RequestMapping("/findUserByProperty")
	public List<UserInfo> getUserByProperty(UserInfo userInfo){
		return this.userInfoService.findUserByUserProperty(userInfo);
	}

	//根据名字模糊查询数据
	//@RequestMapping("/findUserByLikeName")
	@GetMapping("/findUserByLikeName")
	public List<UserInfo> findUserByLikeName(UserInfo userInfo){
		return this.userInfoService.findUserByLikeName(userInfo);
	}


}
