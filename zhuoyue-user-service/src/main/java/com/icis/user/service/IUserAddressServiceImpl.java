package com.icis.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.icis.pojo.UserAddress;
import com.icis.user.IUserAddressService;
import com.icis.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

//@Service
@Service//一个新的注解 把服务从spring本地放入到zookeeper  import com.alibaba.dubbo.config.annotation.Service;
public class IUserAddressServiceImpl implements IUserAddressService {

	@Autowired
	private UserAddressMapper addressMapper;

	@Override
	public List<UserAddress> getUserAddressListByUserId(String userId) {
		//创建一个用户地址对象
		UserAddress userAddress=new UserAddress();
		//设置用户id
		userAddress.setUserId(userId);

		return this.addressMapper.select(userAddress);
	}
}
