package com.icis.user;

import com.icis.pojo.*;

import java.util.List;

//后台商品服务接口
public interface IManageService {
	//查询所有的一级分类
	List<BaseCatalog1> findAllBaseCatalog1();
	//根据一级分类获得二级分类
	List<BaseCatalog2> findAllBaseCatalog2Bycatalog1Id(String catalog1Id);
	//根据二级分类获得三级分类
	List<BaseCatalog3> findAllBaseCatalog3Bycatalog2Id(String catalog2Id);
	//根据三级分类 添加平台属性
	List<BaseAttrInfo> getAttrInfoListBycatalog3Id(String catalog3Id);
	//根据平台属性id 获得属性值列表
	BaseAttrInfo getAttrValueListByAttrId(String attrId);
	//保存属性和属性值
	void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
