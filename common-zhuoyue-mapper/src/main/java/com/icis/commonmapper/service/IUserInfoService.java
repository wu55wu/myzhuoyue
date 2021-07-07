package com.icis.commonmapper.service;

import com.icis.commonmapper.pojo.UserInfo;

import java.util.List;

//用户service接口
public interface IUserInfoService {
	//查询所有用户数据
	List<UserInfo> findAllUser();

}
