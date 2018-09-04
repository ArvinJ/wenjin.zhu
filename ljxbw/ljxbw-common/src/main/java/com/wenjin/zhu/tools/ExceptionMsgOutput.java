package com.wenjin.zhu.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @Title: ExceptionMsgOutput.java
 * @Package org.eastbar.tools
 * @Description: TODO(异常打印)
 * @author: wenjin.zhu
 * @date: 2018年6月29日 下午3:55:39
 * @version V1.0
 */
public class ExceptionMsgOutput {
	public static Logger logger = (Logger) LoggerFactory.getLogger(ExceptionMsgOutput.class);
	
	/**
	 * 
	 * @Title: getStackTraceInfo @Description: TODO(获取e.printStackTrace()
	 * 的具体信息，赋值给String 变量，并返回) @param @param e @param @return 参数 @return String 返回类型
	 * (e.printStackTrace() 中 的信息) @user wenjin.zhu @throws
	 */
	public static String getStackTraceInfo(Exception e) {

		StringWriter sw = null;
		PrintWriter pw = null;

		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);// 将出错的栈信息输出到printWriter中
			pw.flush();
			sw.flush();

			return sw.toString();
		} catch (Exception ex) {
			logger.info("ExceptionMsgOutput----发生错误");
			return "发生错误";
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (pw != null) {
				pw.close();
			}
		}

	}
}
