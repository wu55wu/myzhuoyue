package com.icis.manage.controller;

import com.icis.pojo.*;
import com.icis.user.IManageService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//后台管理的控制器
@Controller
@CrossOrigin //解决跨域问题
public class ManageController {
	//引用服务  接口
	@Reference
	private IManageService iManageService;
	//查询一级分类 返回json数据
	@RequestMapping("/getCatalog1")
	@ResponseBody
	public List<BaseCatalog1> getBaseCatalog1(){
		return iManageService.findAllBaseCatalog1();
	}

	//根据一级分类获得二级分类 /getCatalog2?catalog1Id=1
	@RequestMapping("/getCatalog2")
	@ResponseBody
	public List<BaseCatalog2> getBaseCatalog2(String catalog1Id){
		return iManageService.findAllBaseCatalog2Bycatalog1Id(catalog1Id);
	}

	//根据二级分类获得三级分类 /getCatalog3?catalog2Id=1
	@RequestMapping("/getCatalog3")
	@ResponseBody
	public List<BaseCatalog3> getBaseCatalog3(String catalog2Id){
		return iManageService.findAllBaseCatalog3Bycatalog2Id(catalog2Id);
	}

	//根据三级分类id 获得平台属性
	@RequestMapping("/attrInfoList")
	@ResponseBody
	public List<BaseAttrInfo> getAttrInfoListBycatalog3Id(String catalog3Id){
		return iManageService.getAttrInfoListBycatalog3Id(catalog3Id);
	}

	//根据平台属性id 获得属性值列表 getAttrValueList?attrId=23
	@RequestMapping("/getAttrValueList")
	@ResponseBody
	public List<BaseAttrValue> getAttrValueListBybaseAttrInfoId(String attrId){
		BaseAttrInfo baseAttrInfo = iManageService.getAttrValueListByAttrId(attrId);
		return baseAttrInfo.getAttrValueList();
	}

	//保存属性和属性值 saveAttrInfo
	//@RequestBody 把json对象转化为javabean
	@RequestMapping("/saveAttrInfo")
	@ResponseBody
	public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
		iManageService.saveAttrInfo(baseAttrInfo);
	}



}
