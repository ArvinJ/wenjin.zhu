/*package com.wenjin.zhu.controller;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wenjin.zhu.service.activemq.ProducerUrlService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private static ProducerUrlService producerUrlService;
	@Autowired
	private static Destination urlQueueDestination;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "user login!");
		return "login";
	}

	@RequestMapping(value = "/mq", method = RequestMethod.GET)
	public String sendMq(ModelMap model) {
		model.addAttribute("message", "send mq");
		try {
			producerUrlService.sendMessage(urlQueueDestination, "urlTest");
			System.out.println("jms-url-success");
		} catch (Exception e) {
			System.out.println("jms-url-failure" + e.getMessage());
		}

		return "login";
	}

	@ModelAttribute
	public void init() {
		System.out.println("在方法定义上使用 @ModelAttribute 注解：Spring MVC 在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法");
	}

	public void parm(@ModelAttribute String aa) {
		System.out.println("在方法的入参前使用 @ModelAttribute 注解：可以从隐含对象中获取隐含的模型数据中获取对象，再将请求参数 –绑定到对象中，再传入入参将方法入参对象添加到模型中 ");
	}

	@RequestMapping("/person")
	public String toPerson(ModelMap model, String name, double age) {
		// 自动匹配参数 ljxbw-web/user/person?name=abc&age=18
		System.out.println(name + " " + age);
		model.addAttribute("name", name);
		return "login";
	}

	// redirect
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/user/login";
	}

}
*/