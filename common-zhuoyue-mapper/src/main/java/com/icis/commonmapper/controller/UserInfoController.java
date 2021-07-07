package com.icis.commonmapper.controller;

import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody //作用域该类下面所有的方法
public class UserInfoController {
	@Autowired
	private IUserInfoService userInfoService;

	//查询所有用户列表
	@RequestMapping("/getAllUser")
	public List<UserInfo> findAllUser(){
		return this.userInfoService.findAllUser();
	}

}
