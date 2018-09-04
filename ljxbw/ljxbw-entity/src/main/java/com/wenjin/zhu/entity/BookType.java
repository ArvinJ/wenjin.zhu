package com.wenjin.zhu.entity;

/**
 * 
 * 
 * @Title: BookType.java
 * @Package com.wenjin.zhu.entities
 * @Description: 图书类型
 * @author: wenjin.zhu
 * @date: 2018年8月30日 上午10:27:34
 * @version V1.0
 */
public class BookType {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 类型名
	 */
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "BookType [id=" + id + ", typeName=" + typeName + "]";
	}

}
