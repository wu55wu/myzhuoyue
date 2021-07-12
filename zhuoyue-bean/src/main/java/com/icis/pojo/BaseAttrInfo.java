package com.icis.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String id;
	@Column
	private String attrName;
	@Column
	private String catalog3Id;
	@Transient
	private List<BaseAttrValue> attrValueList;
}
