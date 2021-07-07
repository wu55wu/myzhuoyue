package com.icis.commonmapper.service;

import com.icis.commonmapper.pojo.UserInfo;

import java.util.List;

//用户service接口
public interface IUserInfoService {
	//查询所有用户数据
	List<UserInfo> findAllUser();
	//查询用户方法 根据主键查询一个用户数据
	UserInfo findUserByPrimaryKey(UserInfo userInfo);
	//根据 其他字段查询数据
	List<UserInfo> findUserByUserProperty(UserInfo userInfo);
	//根据名字 模糊查询 用户数据
	List<UserInfo> findUserByLikeName(UserInfo userInfo);




}
