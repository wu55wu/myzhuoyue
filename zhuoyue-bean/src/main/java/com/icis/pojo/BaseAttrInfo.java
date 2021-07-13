package com.icis.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//平台属性
/*
* 通用mapper 默认开启驼峰命名支持 忽略大小写
* */
//@Table(name = "base_attr_info")
@Data
public class BaseAttrInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//把新增加的平台属性id 赋值给 id属性
	@Column
	private String id;
	@Column
	private String attrName;
	@Column
	private String catalog3Id;
	//封装平台属性值数据 平台属性：平台属性值 1：N
	@Transient //标注这个字段 是自己添加的字段 不是数据库字段 告诉通用mapper  不要做这个字段的自动映射
	private List<BaseAttrValue> attrValueList;
}
