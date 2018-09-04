package com.wenjin.zhu.service;

import java.util.List;

import com.wenjin.zhu.entity.BookType;


/**
 * 
 * 
 */
public interface BookTypeService {

	void saveBookType(BookType bookType);

	void updateBookType(BookType bookType);

	List<BookType> showBookTypeList(BookType bookType);

	void deleteBookType(BookType bookType);

	BookType showBookType(int id);

}
