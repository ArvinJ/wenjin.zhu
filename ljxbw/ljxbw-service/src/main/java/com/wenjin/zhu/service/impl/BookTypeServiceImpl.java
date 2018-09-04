package com.wenjin.zhu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenjin.zhu.dao.BookTypeDAO;
import com.wenjin.zhu.entity.BookType;
import com.wenjin.zhu.service.BookTypeService;

/**
 * 
 * 
 * @Title: BookTypeServiceImpl.java
 * @Package com.wenjin.zhu.service.impl
 * @Description: 业务逻辑处理
 * @author: wenjin.zhu
 * @date: 2018年8月30日 下午2:07:07
 * @version V1.0
 */

@Service
public class BookTypeServiceImpl implements BookTypeService {

	@Autowired
	BookTypeDAO bookTypeDAO;

	public void saveBookType(BookType bookType) {

	}

	public void updateBookType(BookType bookType) {

	}

	public List<BookType> showBookTypeList(BookType bookType) {
		return bookTypeDAO.getAllBookTypes();
	}

	public void deleteBookType(BookType bookType) {

	}

	public BookType showBookType(int id) {
		return null;
	}

}
