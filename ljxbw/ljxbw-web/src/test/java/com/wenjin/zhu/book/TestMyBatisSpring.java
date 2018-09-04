package com.wenjin.zhu.book;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenjin.zhu.dao.BookTypeDAO;
import com.wenjin.zhu.entity.BookType;

public class TestMyBatisSpring {

	@SuppressWarnings("resource")
	@Test
	public void test01() {
		// 初始化容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		// 获得bean
		BookTypeDAO bookTypeDao = ctx.getBean(BookTypeDAO.class);
		// 访问数据库
		List<BookType> booktypes = bookTypeDao.getAllBookTypes();
		for (BookType bookType : booktypes) {
			System.out.println(bookType);
		}
		assertNotNull(booktypes);
	}

}
