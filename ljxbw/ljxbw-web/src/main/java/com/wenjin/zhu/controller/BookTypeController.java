package com.wenjin.zhu.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 
 * 
 * @Title:  BookTypeController.java   
 * @Package com.wenjin.zhu.controller   
 * @Description:测试  
 * @author: wenjin.zhu    
 * @date:   2018年8月30日 下午3:03:44   
 * @version V1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenjin.zhu.entity.BookType;
import com.wenjin.zhu.service.BookTypeService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/book")
public class BookTypeController {
	public Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	BookTypeService bookTypeService;

	@RequestMapping(value = "/showList", method = RequestMethod.GET)
	@ResponseBody
	public List<BookType> showBookTypes() {
		logger.info("showBookTypes  >>>  start.");
		List<BookType> bookTypes = bookTypeService.showBookTypeList(new BookType());
		logger.info(bookTypes.toString());
		return bookTypes;
	}
	
	@RequestMapping(value = "/show")
	public void show() {
		logger.info("show >>>  start.");
	}

}
