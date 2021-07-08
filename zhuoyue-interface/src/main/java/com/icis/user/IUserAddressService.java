package com.icis.user;

import com.icis.pojo.UserAddress;

import java.util.List;

//用户地址服务接口
public interface IUserAddressService {
	//根据用户id查询用户地址列表
	List<UserAddress> getUserAddressListByUserId(String userId);
}
