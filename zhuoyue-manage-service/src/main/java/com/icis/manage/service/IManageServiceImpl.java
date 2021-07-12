package com.icis.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.icis.manage.mapper.*;
import com.icis.pojo.*;
import com.icis.user.IManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class IManageServiceImpl implements IManageService {
	//注入一级分类的mapper
	@Autowired
	private BaseCatalog1Mapper baseCatalog1Mapper;
	//注入二级分类 mapper
	@Autowired
	private BaseCatalog2Mapper baseCatalog2Mapper;
	//注入三级分类 mapper
	@Autowired
	private BaseCatalog3Mapper baseCatalog3Mapper;
	//注入平台属性名mapper
	@Autowired
	private BaseAttrInfoMapper baseAttrInfoMapper;
	//注入平台属性值 mapper
	@Autowired
	private BaseAttrValueMapper baseAttrValueMapper;

	@Override
	public List<BaseCatalog1> findAllBaseCatalog1() {
		List<BaseCatalog1> baseCatalog1s = baseCatalog1Mapper.selectAll();
		return baseCatalog1s;
	}
	//根据一级分类获得二级分类
	@Override
	public List<BaseCatalog2> findAllBaseCatalog2Bycatalog1Id( String catalog1Id) {
		BaseCatalog2 baseCatalog2 = new BaseCatalog2();
		//设置一节分类id
		baseCatalog2.setCatalog1Id(catalog1Id);
		return baseCatalog2Mapper.select(baseCatalog2);
	}

	@Override
	public List<BaseCatalog3> findAllBaseCatalog3Bycatalog2Id(String catalog2Id) {
		BaseCatalog3 baseCatalog3 = new BaseCatalog3();
		baseCatalog3.setCatalog2Id(catalog2Id);
		return baseCatalog3Mapper.select(baseCatalog3);
	}

	//根据三级分类 添加平台属性
	@Override
	public List<BaseAttrInfo> getAttrInfoListBycatalog3Id(String catalog3Id) {
		BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
		baseAttrInfo.setCatalog3Id(catalog3Id);
		return baseAttrInfoMapper.select(baseAttrInfo);
	}

	//根据平台属性id 获得属性值列表
	@Override
	public BaseAttrInfo getAttrValueListByAttrId(String attrId) {
		//创建属性对象
		BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
		//创建属性值对象
		BaseAttrValue baseAttrValue = new BaseAttrValue();
		baseAttrValue.setAttrId(baseAttrInfo.getId());
		List<BaseAttrValue> attrValueList = baseAttrValueMapper.select(baseAttrValue);
		baseAttrInfo.setAttrValueList(attrValueList);
		return baseAttrInfo;
	}

	//保存属性和属性值
	@Override
	public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
		//如果有主键就进行更新属性 没有就插入新属性
		if (baseAttrInfo.getId()!=null&&baseAttrInfo.getId().length()>0){
			//通过主键更新属性
			baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);
		}else {
			baseAttrInfo.setId(null);
			System.out.println("=============baseAttrInfo:"+baseAttrInfo);
			baseAttrInfoMapper.insertSelective(baseAttrInfo);
		}

		if (baseAttrInfo.getAttrValueList()!=null&&baseAttrInfo.getAttrValueList().size()>0){
			//把原来的属性值全部清空
			BaseAttrValue baseAttrValue4Del = new BaseAttrValue();
			baseAttrValue4Del.setAttrId(baseAttrInfo.getId());
			baseAttrValueMapper.delete(baseAttrValue4Del);
			for (BaseAttrValue baseAttrValue : baseAttrInfo.getAttrValueList()) {
				//防止主键赋空值  把主键设置为空 让它自增
				baseAttrValue.setId(null);
				baseAttrValue.setAttrId(baseAttrInfo.getId());
				baseAttrValueMapper.insertSelective(baseAttrValue);
			}


		}
	}
}
