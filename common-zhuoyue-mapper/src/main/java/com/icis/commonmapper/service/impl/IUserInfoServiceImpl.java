package com.icis.commonmapper.service.impl;

import com.icis.commonmapper.mapper.UserInfoMapper;
import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class IUserInfoServiceImpl implements IUserInfoService {

	//注入mapper
	@Autowired
	private UserInfoMapper userInfoMapper;

	//实现查询所有用户数据
	@Override
	public List<UserInfo> findAllUser() {
		//查询所有 SELECT * FROM user_info
		return userInfoMapper.selectAll();
	}

	@Override
	public UserInfo findUserByPrimaryKey(UserInfo userInfo) {
		//SELECT * FROM user_info where id=?
		return this.userInfoMapper.selectByPrimaryKey(userInfo);
	}

	//根据条件 查询 条件封装到pojo
	@Override
	public List<UserInfo> findUserByUserProperty(UserInfo userInfo) {
		return this.userInfoMapper.select(userInfo);
	}

	//模糊查询
	@Override
	public List<UserInfo> findUserByLikeName(UserInfo userInfo) {
		//封装条件 %value%
		// Example 模板 查询条件通过模板封装
		Example example = new Example(UserInfo.class);
		Example.Criteria criteria = example.createCriteria();
		//根据名字模糊查询
		criteria.andLike("name","%"+userInfo.getName()+"%");
		criteria.andGreaterThan("id",userInfo.getId());//id>2
		return this.userInfoMapper.selectByExample(example);
	}






}
